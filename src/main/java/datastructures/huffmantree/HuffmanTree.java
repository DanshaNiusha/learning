package datastructures.huffmantree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 霍夫曼树
 *
 * @author liuxiaokang
 * @date 2021/1/12
 */
public class HuffmanTree {
    
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        // System.out.println(Arrays.toString(arr));
        root.preOrder();
    }
    
    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        Arrays.stream(arr).forEach(value -> nodes.add(new Node(value)));
        //我们处理的过程是一个循环的过程
        
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            // 取最小
            Node left = nodes.get(0);
            // 取次小
            Node right = nodes.get(1);
            // 弄一个新的小树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            
            // 原来的节点移除, 放新树
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        // 循环完list中只有一个节点, 就是霍夫曼树
        return nodes.get(0);
        
    }
    
    
    
}

class Node implements Comparable<Node> {
    // 值
    int value;
    // 左子节点
    Node left;
    // 右子节点
    Node right;
    
    public Node(int value) {
        this.value = value;
    }
    
    //编写一个前序遍历的方法
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
