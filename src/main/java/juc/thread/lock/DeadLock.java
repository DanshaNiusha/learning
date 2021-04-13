package juc.thread.lock;

import lombok.SneakyThrows;

/**
 * 死锁案例
 * @author liuxiaokang
 * @date 2020/12/8
 */
class HoldLockThread implements Runnable {
    private String lockA ;
    private String lockB;
    
    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    
    @SneakyThrows
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockA+"\t尝试获得:"+lockB);
            Thread.sleep(1000);// 防止第二个线程还没启动第一个线程就执行完了
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockB+"\t尝试获得:"+lockA);
            }
        }
    }
}
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        
        new Thread(new HoldLockThread(lockA,lockB)).start();
        new Thread(new HoldLockThread(lockB,lockA)).start();
    }
    
    
}
