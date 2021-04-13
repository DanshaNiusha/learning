package juc.jvm;

import java.nio.ByteBuffer;

/**
 * @author liuxiaokang
 * @date 2020/12/14
 */
public class GCUnableCreateNewThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; ; i++) {
            System.out.println(i);
            new Thread(()->{
                try {
                    Thread.sleep(2000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },i+"").start();
            
        }
    
    }
}
