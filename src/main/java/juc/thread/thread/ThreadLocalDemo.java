package juc.thread.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import model.Model1;
import model.Model2;
import model.Model3;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class ThreadLocalDemo {
    // private static final ExecutorService executor = new ThreadPoolExecutor(1, 1
    //         , 1, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
    
    private static final ForkJoinPool executor = ForkJoinPool.commonPool();
    
    // private static final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    // 子线程每次取值都取父线程的值
    private static final ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
    
    public static void main(String[] args) throws InterruptedException {
        testInheritableThreadLocal();
    }
    
    public static void testInheritableThreadLocal() throws InterruptedException {
        threadLocal.set("123");
        System.out.println("初始值：" + Thread.currentThread().getName() + "_" + threadLocal.get());
        Runnable task = () -> {
            System.out.println("----------start------------");
            System.out.println("父线程的值：" + Thread.currentThread().getName() + "_" + threadLocal.get());
            threadLocal.set("456");
            System.out.println("子线程覆盖后的值：" + Thread.currentThread().getName() + "_" + threadLocal.get());
            System.out.println("------------end---------------");
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable runnable = TtlRunnable.get(task);
        executor.submit(runnable);
        threadLocal.set("777");
        TimeUnit.SECONDS.sleep(1);
        executor.submit(runnable);
        System.out.println(threadLocal.get());
    }
    
    
    
}

