package juc.sgg.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2020/12/8
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        // System.out.println(queue.add("1"));//true
        // System.out.println(queue.add("2"));//true
        // System.out.println(queue.add("3"));//true
        // System.out.println(queue.add("4"));// java.lang.IllegalStateException: Queue full
        //
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());//java.util.NoSuchElementException
    
        // System.out.println(queue.offer("1"));//true
        // System.out.println(queue.offer("2"));//true
        // System.out.println(queue.offer("3"));//true
        // System.out.println(queue.offer("4"));//false
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());//null
    
        /*
            true
            true
            true
            1
            true
            [2, 3, 4]
            [2, 3, 4]
         */
        System.out.println(queue.offer("1", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("2",2, TimeUnit.SECONDS));
        System.out.println(queue.offer("3",2, TimeUnit.SECONDS));
        new Thread(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(queue.poll());
        }).start();
        // 等待2s 但是上面的线程1s就取出了一个元素, 所以又有了一个坑位
        System.out.println(queue.offer("4",2, TimeUnit.SECONDS));
        System.out.println(queue.toString());
        
    
    }
}
