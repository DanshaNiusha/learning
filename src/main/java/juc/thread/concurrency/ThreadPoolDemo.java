package juc.thread.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/1/15
 */
public class ThreadPoolDemo {
    private static final ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2
            , 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
    
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        
        long l = System.currentTimeMillis();
        System.out.println("list:" + list.toString());
        list.parallelStream().forEach(x-> {//单线程17814 //多线程 3406
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        });
        
        System.out.println(System.currentTimeMillis()-l);
        
    }
    
}

