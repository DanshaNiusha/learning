package datastructures.stack;

/**
 * 单链表实现栈 头插法 然后正向遍历 或者尾插法反向遍历
 *
 * @author Dansha
 * @version 1.0
 */
public class SingleLinkedListStackDemo {
    
    
    public static void main(String[] args) {
        //创建要给链表
        SingleLinkedListStack stack = new SingleLinkedListStack(3);
        //加入
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.getHead());
        
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getHead());
        
    }
}


class SingleLinkedListStack {
    // 最大栈深 不含头
    private int maxLength;
    // 当前长度 不含头
    private int length = 0;
    private Node head = new Node();
    
    public SingleLinkedListStack(int maxLength) {
        this.maxLength = maxLength;
    }
    
    //返回头节点
    public Node getHead() {
        return head;
    }
    
    /**
     * 头插法 画图理解
     *
     * @param value
     */
    public void push(int value) {
        Node node = new Node(value);
        // temp始终指向头节点的下个
        if (length >= maxLength) {
            System.out.println("full~");
            return;
        }
        Node temp = head.next;
        node.next = temp;
        head.next = node;
        length++;
    }
    
    
    public void pop() {
        // temp始终指向头节点的下个节点
        Node temp = head.next;
        if (length <= 0) {
            System.out.println("empty~");
            return;
        }
        System.out.println(temp.value);
        head.next = temp.next;
        length--;
    }
    
    public void list() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    
    public Node(int value) {
        this.value = value;
    }
    
    public Node() {
    }
    
    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                " " + next +
                '}';
    }
}
