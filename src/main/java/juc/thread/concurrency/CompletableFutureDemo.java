package juc.thread.concurrency;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
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
     * complete()直接结束future,返回99默认值,不在等待
     */
    @Test
    public void testComplet() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(new OddCombine());
        task.complete(99);
        Integer integer = task.get(); //99
        System.out.println(integer);
        
    }
    
    /**
     * 返回已完成的CompletableFuture.没卵用
     */
    @Test
    public void testCompletedFuture() throws ExecutionException, InterruptedException {
        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
        System.out.println(completableFuture.get()); //Hello
        
    }
    
    /**
     * 实际应用,异步执行一堆任务并用返回值操作,然后等待执行完成,如果不需要返回值就不用CompletableFuture
     */
    @Test
    public void testJoin() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        try {
            for (int i = 0; i < 1; i++) {
                int finalI = i;
                futureList.add(CompletableFuture.supplyAsync(() -> addNum(finalI, 1), executor)
                        .whenComplete((result, e) -> {
                            // 这里的e是addnum中的e.addnum没e则e是null
                            System.out.println("complate e:" + e.getMessage());
                        })
                        .exceptionally(e -> {
                            // 这里如果whencomplate中的的e!=null,则e就是上面的e,如果上面e==null,则这里的e是whencomlete流程的异常 没e则不执行
                            System.out.println("exceptionally e:" + e.getMessage());
                            return -1;
                        })
                );
            }
        } catch (Exception e) {
            System.out.println("out eeee"+e.getMessage());
        }
       
        //等待所有future执行完成
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        
        // //其中一个future执行完成就解除阻塞
        // CompletableFuture.anyOf(futureList.toArray(new CompletableFuture[]{})).join();
        System.out.println("done");
        
        // 这里get已经不会阻塞了 因为上面已经allof.join了
        // futureList.forEach(num-> {
        //     try {
        //         System.out.println(num.get());
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // });
    }
    
    public int addNum(int a, int b) {
        try {
            int m = 1/0;
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
                Thread.sleep(5000);
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
