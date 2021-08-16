package juc.thread.lock;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁来构建缓存
 * @author liuxiaokang
 * @date 2021/8/16
 */
public class ReentrantReadWriteLockDemo {
    @Test
    public void test() throws Exception{
        ICache<String,Integer> cache = new ICache();
        cache.put("1",1);
        System.out.println(cache.toString());
        
    }


    
}

class ICache<K, V> {
    private final Map<K, V> map = Maps.newHashMap();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    
    public V get(K k) {
        r.lock();
        try {
            return map.get(k);
        } finally {
            r.unlock();
        }
    }
    public Object[] allKeys() {
        r.lock();
        try {
            return map.keySet().toArray();
        } finally {
            r.unlock();
        }
    }
    public V put(K key, V value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }
    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
    
    @Override
    public String toString() {
        return "ICache{" + map + "}";
    }
}