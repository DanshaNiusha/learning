package algorithms.lru;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            list.remove(key);
            list.addFirst(key);
        }
        return value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            list.remove(key);
        } else if (cache.size() >= capacity) {
            K last = list.removeLast();
            cache.remove(last);
        }
        cache.put(key, value);
        list.addFirst(key);
    }
    public static void main(String[] args) {
        
        LruDemo1 lruCacheDemo = new LruDemo1(3);
        
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        
        lruCacheDemo.get(1);
        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());
        
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());
    }
    
}