package datastructures.queue;

import java.util.Scanner;


/**
 * 环形队列 可以复用
 * @author liuxiaokang
 * @date 2020/12/3 17:22
 */
public class CircleArrayQueueDemo {
    
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        CircleArray queue = new CircleArray(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * 数组实现队列
 */
class CircleArray {
    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 队列头指针
     */
    private int front;
    /**
     * 队列尾指针
     */
    private int rear;
    /**
     * 实现队列的数组
     */
    private int[] arr;
    
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }
    
    private boolean isFull() {
        return (rear  + 1) % maxSize == front;
    }
    
    
    private boolean isEmpty() {
        return rear == front;
    }
    
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }
    
    /**
     * 当前队列的元素个数
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    
    
    /**
     * 出队
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }
    
    /**
     * 显示头部
     *
     * @return
     */
    public int headQueue() {
        return arr[front + 1];
    }
    
    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("Can Not Add: Queue Is Full");
            return;
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }
}