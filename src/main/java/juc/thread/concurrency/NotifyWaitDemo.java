package juc.dansha;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 交替打印1-10
 *
 * @author liuxiaokang
 * @date 2020/11/23
 */
public class NotifyWaitDemo {
    private static final Object lock = new Object();
    private volatile static int num = 1;
    
    class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("THREAD-A:" + num++);
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("THREAD-B:" + num++);
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        NotifyWaitDemo notifyWaitDemo = new NotifyWaitDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(notifyWaitDemo.new ThreadA());
        Thread.sleep(1000);
        executorService.execute(notifyWaitDemo.new ThreadB());
        executorService.shutdown();
    }
}
