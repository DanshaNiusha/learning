package juc.gc;

/**
 * @author liuxiaokang
 * @date 2020/12/14
 */
public class GCMetaSpaceDemo {
    public static void main(String[] args) {
        try {
            for (; ; ) {
                new InnerClass();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
    
    static class InnerClass{
        // 静态内部类放在元空间里
    }
}
