package juc.gc;

import java.nio.ByteBuffer;

/**
 * @author liuxiaokang
 * @date 2020/12/14
 */
public class GCDirectBufferDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("最大直接内存:" + sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024 + "mb");//3604.0mb
        //分配最大本地内存是1000000MB
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000000 * 1024 * 1024);
        // ByteBuffer byteBuffer = ByteBuffer.allocate(1000000 * 1024 * 1024);
    
    
    }
}
