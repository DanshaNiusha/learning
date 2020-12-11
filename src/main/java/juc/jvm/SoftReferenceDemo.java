package juc.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author liuxiaokang
 * @date 2020/12/11
 */
public class SoftReferenceDemo {
    public static void softRef_memory_enough() {
        Object o1 = new Object();
        // SoftReference<Object> reference = new SoftReference<>(o1);// 内存不够才回收
        WeakReference<Object> reference = new WeakReference<>(o1); //只要gc就回收
        System.out.println(o1);
        System.out.println(reference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(reference.get());
    }
    
    public static void main(String[] args) {
        softRef_memory_enough();
        
    }
    
}
