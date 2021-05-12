package juc.thread.string;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/11/24
 */
public class InternDemo {
    public static void main(String[] args) {
        String s1 = "dansha";
        System.out.println(s1==s1.intern());
        String s2 = new String("java");
        System.out.println(s2==s2.intern());
    }
}
