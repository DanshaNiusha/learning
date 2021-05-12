package juc.thread.concurrency;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题解决AtomicStampedReference
 */
public class AtomicReferenceDemo {
    
    public static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    
    public static void main(String[] args) {
        System.out.println("------------ABA问题的解决----------------");
        new Thread(() -> {
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 第1次版本号:" + stamp +
                    "\t 当前值：" + atomicStampedReference.getReference());
            //暂停1s为了让t4获取到同一版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + " 第2次版本号:" + atomicStampedReference.getStamp() +
                    "\t当前值：" + atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + " 第3次版本号:" + atomicStampedReference.getStamp() +
                    "\t当前值：" + atomicStampedReference.getReference());
        }, "t3").start();
        
        new Thread(() -> {
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 第1次版本号:" + stamp + "\t当前值：" + atomicStampedReference.getReference());
            //暂停3s，保证上面的t3完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //t4还是用傻傻地用上面获取的版本号
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + " 修改结果：" + result);
            System.out.println(Thread.currentThread().getName() + "当前版本号：" + atomicStampedReference.getStamp() +
                    "\t当前最新值" + atomicStampedReference.getReference());
        }, "t4").start();
    }
}

