package juc.gc;

/**
 * @author liuxiaokang
 * @date 2020/12/10
 */
public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello gc");
        // System.gc();
        // for (int i = 0; i < 100000000; i++) {
        //     HashMap<Object, Object> objectObjectHashMap = new HashMap<>(128);
        // }
        byte[] bytes = new byte[12 * 1024 * 1024];
        Thread.sleep(20000000);
    }
}
