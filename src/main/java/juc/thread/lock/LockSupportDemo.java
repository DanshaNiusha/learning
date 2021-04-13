package juc.sgg.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxiaokang
 * @description LockSupport就是wait notify的增强版 换成了park和unpark 不需要锁块
 * @date 2020/11/25 9:44
 */
public class LockSupportDemo {
    
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "----A come in");
            try {
                LockSupport.park();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "----A 被唤醒");
        }, "Thread A");
        a.start();
        
        TimeUnit.SECONDS.sleep(2);
        
        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "----unpark  A");
            try {
                LockSupport.unpark(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Thread B");
        b.start();
        
    }
}

