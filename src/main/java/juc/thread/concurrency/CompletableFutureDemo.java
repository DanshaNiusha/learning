package juc.thread.concurrency;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * CompletableFuture 解决了传统线程池futureList不知道什么时候全部执行完成的痛点
 * @author liuxiaokang
 * @date 2021/5/26
 */
public class CompletableFutureDemo {
    
    private static final ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2
            , 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
    
    /**
     * 先各自执行相加,然后合并到一起并执行回调内容
     */
    @Test
    public void testCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(new OddCombine());
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(new EvenCombine());
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(new OddNumberPlus());
        
        // 两个合并
        // CompletableFuture<Integer> resultFuturn = task1.thenCombine(task2,(odd,even)->{
        //     System.out.println("odd"+odd);
        //     System.out.println("even"+even);
        //     return odd + even;
        // });
        // System.out.println(resultFuturn.get());
        
        // 多个合并
        AtomicInteger sum = new AtomicInteger();
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList(task1, task2, task3);
        for (CompletableFuture<Integer> future : futureList) {
            future.whenComplete((res,e)->{
                sum.addAndGet(res);
            }).exceptionally(e->{
                e.printStackTrace();
                return 0;
            });
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        System.out.println(sum.get());
        
    }
    
    /**
     * 实际应用,异步执行一堆任务并用返回值操作,然后等待执行完成,如果不需要返回值就不用CompletableFuture
     */
    @Test
    public void testJoin() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            futureList.add(CompletableFuture.supplyAsync(() -> addNum(finalI, 1), executor)
                    .whenComplete((result, e) -> { // 这里是执行完后的附加操作,可以不要,因为addNUm的结果已经在Future中了,可以get
                        System.out.println(result);
                    })
                    .exceptionally(e -> {
                        // 这里捕获的是whencomplate中的异常 不是addNum的异常,addNUm异常会被外层捕获
                        e.printStackTrace();
                        return -1;
                    })
            );
        }
        //等待所有future执行完成
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        
        // //其中一个future执行完成就解除阻塞
        // CompletableFuture.anyOf(futureList.toArray(new CompletableFuture[]{})).join();
        System.out.println("done");
        
        // 这里get已经不会阻塞了 因为上面已经allof.join了
        futureList.forEach(num-> {
            try {
                System.out.println(num.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public int addNum(int a, int b) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
    
    public class OddCombine implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }
    }
    
    public class EvenCombine implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        }
    }
    
    public class OddNumberPlus implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 30;
        }
    }
    
}
