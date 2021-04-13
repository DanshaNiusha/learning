package juc.sgg.lock;

/**
 * @description sendSMS调sendEmail不阻塞 代表可重入, 外层获取锁之后再获取内存的锁时是直接可以获取的
 * @author liuxiaokang
 * @date 2020/11/25 9:44
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Thread 1").start();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Thread 2").start();
    }
}

class Phone{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t -----invoked sendSMS()");
        Thread.sleep(3000);
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t +++++invoked sendEmail()");
    }
}