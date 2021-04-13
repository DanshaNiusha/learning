package juc.thread.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/7/6
 */
public class CounDownLatchDemo1 {
    
    /**
     *  3y现在去做实习生了，其他的员工还没下班，3y不好意思先走，等其他的员工都走光了，3y再走。
     */
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("现在6点下班了");
        
        // 3y想走线程启动
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有员工走完, 3y可以走了");
        }).start();
        
        // 其他员工走的线程启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                // 加锁保证getCount的值是准确的
                synchronized (CounDownLatchDemo1.class) {
                    System.out.println("员工xxx走了,还剩" + countDownLatch.getCount() + "个人没走");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
    
    
}
