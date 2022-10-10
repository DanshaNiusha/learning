package algorithms.lru;

import org.apache.commons.lang3.tuple.Pair;

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
    // 链表复制增删用,维护顺序
    LinkedList<Pair<Integer, Integer>> linkedList;
    
    public LruDemo1(int size) {
        this.cacheSize = size;
        linkedList = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public void put(Integer key, Integer value) {
        // gengxin
        if (map.containsKey(key)) {
            map.put(key, value);
            linkedList.remove(Pair.of(key, value));
            linkedList.addFirst(Pair.of(key, value));
        } else {
            if (map.size() == cacheSize) {
                Pair<Integer, Integer> last = linkedList.removeLast();
                map.remove(last.getKey());
            }
            map.put(key, value);
            linkedList.addFirst(Pair.of(key, value));
        }
        
    }
    
    public Integer get(Integer key) {
        Integer value = map.get(key);
        linkedList.remove(Pair.of(key, value));
        linkedList.addFirst(Pair.of(key, value));
        return value;
    }
    
    public static void main(String[] args) {
        
        LruDemo1 lruCacheDemo = new LruDemo1(3);
        
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        
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
