package juc.thread.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru算法
 * @author liuxiaokang
 * @date 2020/12/7
 */

public class LruLinkedHashMapDemo<K,V> extends LinkedHashMap<K, V> {
    
    private int capacity;//缓存坑位
    
    public LruLinkedHashMapDemo(int capacity) {
        super(capacity,0.75F,true); // true false会导致顺序不一样
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }
    
    public static void main(String[] args) {
        LruLinkedHashMapDemo lruCacheDemo = new LruLinkedHashMapDemo(3);
        
        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        
        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());
        
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"x");
        System.out.println(lruCacheDemo.keySet());
    }
}
