package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/7/6
 */
public class CounDownLatchDemo2 {
    
    /**
     * 3y现在负责仓库模块功能，但是能力太差了，写得很慢，别的员工都需要等3y写好了才能继续往下写
     */
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        // 3y开始写
        new Thread(() -> {
            System.out.println("3y正在写");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3y写完了");
            countDownLatch.countDown();
        }).start();
        
        // 其他员工走的线程启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("其他人在等3y");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3y写完了其他员工可以开始了");
            }).start();
        }
    }
    
    
}
