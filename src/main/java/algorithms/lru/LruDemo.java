package algorithms.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaokang
 * @date 2020/12/7
 */
public class LruDemo {
    
    private int cacheSize;
    // map负责存值 查找用
    Map<Integer, Node<Integer, Integer>> map;
    // 链表复制增删用,维护顺序
    DoubleLinkedList<Integer, Integer> doubleLinkedList;
    
    public LruDemo(int cacheSize) {
        this.cacheSize = cacheSize;//坑位
        map = new HashMap<>();//查找
        doubleLinkedList = new DoubleLinkedList<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node<Integer, Integer> node = map.get(key);
        // 每次访问都把该元素放到头部, 相当于刷新
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {  //update
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            // 放重复的也同样刷新顺序
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            //坑位满了 删除最后的
            if (map.size() == cacheSize) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            
            // 头插 前面是最新的
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
            
        }
    }
    
    public static void main(String[] args) {
        
        LruDemo lruCacheDemo = new LruDemo(3);
        
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
    
    
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;
        
        public Node() {
            this.prev = this.next = null;
        }
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    
    /**
     * 双向链表的结构
     */
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        
        public DoubleLinkedList() {
            // 初始化节点并头尾相连
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }
        
        /**
         * 添加头节点
         */
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
        
        /**
         * 删除节点
         */
        public void removeNode(Node<K, V> node) {
            // node前后节点连上
            node.next.prev = node.prev;
            node.prev.next = node.next;
            // 把自己前后断开
            node.prev = null;
            node.next = null;
        }
        
        /**
         * 获得最后一个节点
         */
        public Node getLast() {
            return tail.prev;
        }
        
        
    }
    
}
