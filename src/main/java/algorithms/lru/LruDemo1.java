package algorithms.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author liuxiaokang
 * @date 2020/12/7
 */
public class LruDemo1 {
    
    private int cacheSize;
    // map负责存值 查找用
    Map<Integer, Integer> map;
    // 链表复制增删用,维护顺序 存key
    LinkedList<Integer> linkedList;
    
    public LruDemo1(int size) {
        this.cacheSize = size;
        linkedList = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
        } else if (map.size() == cacheSize) {
            Integer last = linkedList.removeLast();
            map.remove(last);
        }
        map.put(key, value);
        linkedList.addFirst(key);
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            linkedList.remove((Integer) key);
            linkedList.addFirst(key);
        }
        
        return value == null ? -1 : value;
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
        
    }
    
    
}
