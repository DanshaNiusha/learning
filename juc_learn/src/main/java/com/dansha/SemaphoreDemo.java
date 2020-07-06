package com.dansha;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/7/6
 */
public class SemaphoreDemo {
    /**
     * 3y女朋友开了一间卖酸奶的小店，小店一次只能容纳5个顾客挑选购买，超过5个就需要排队啦
     */
    public static void main(String[] args) {
        // 假设有50个人来到门口
        int num = 50;
        final Semaphore semaphore = new Semaphore(5);
        
        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    // 取到号的人才能买
                    semaphore.acquire();
                    System.out.println("顾客" + finalI + "在挑选商品，购买...");
                    // 假设挑选了xx长时间，购买了
                    Thread.sleep(1000);
                    // 买完归还一个许可，后边的就可以进来购买了
                    System.out.println("顾客" + finalI + "购买完毕了...");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        
    }
}
