package juc.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxiaokang
 * @description LockSupport就是wait notify的增强版 换成了park和unpark
 * @date 2020/11/25 9:44
 */
public class ConditionDemo {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "----A come in");
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "----A 被唤醒");
        }, "Thread A").start();
    
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "----notify A");
                try {
                    condition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "Thread B").start();
    
    }
}

