package com.dansha;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/7/6
 */
public class CyclicBarrierDemo1 {
    /**
     * 3y和女朋友约了去夜上海吃东西，由于3y和3y女朋友住的地方不同，自然去的路径也就不一样了。
     * 于是他俩约定在地铁站集合，约定等到相互见面的时候就发一条朋友圈。最终目的是一起发朋友圈
     */
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);//一组2个人
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName().equals("Thread-0") ? "3y" : "女朋友";
                System.out.println(name+"到了地铁站");
                try {
                    cyclicBarrier.await();
                    System.out.println(name+"发了朋友圈 ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
               
            }).start();
        }
        
        
    }
}
