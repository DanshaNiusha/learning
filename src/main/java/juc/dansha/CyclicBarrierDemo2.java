package juc.dansha;

import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/7/6
 */
public class CyclicBarrierDemo2 {
    /**
     * 玩了一天以后，各自回到家里，3y和女朋友约定各自洗澡完之后再聊天
     */
    public static void main(String[] args) {
        
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);//一组2个人
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName().equals("Thread-0") ? "3y" : "女朋友";
                System.out.println(name + "到了地铁站");
                try {
                    cyclicBarrier.await();
                    System.out.println(name + "发了朋友圈 ");
                    cyclicBarrier.await();
                    System.out.println(name + "到家了开始洗澡");
                    cyclicBarrier.await();
                    System.out.println(name + "洗完澡开始聊天");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        
    }
}
