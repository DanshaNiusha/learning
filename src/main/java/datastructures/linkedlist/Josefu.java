package datastructures.linkedlist;

/**
 * Josephu约瑟夫问题:" 问题为：设编号为 1，2，… n 的 n 个人围坐一圈，约定编号为 k（1<=k<=n）的人从 1 开始报数，数到
 * m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，依次类推，直到所有人出列为止，由此
 * 产生一个出队编号的序列
 *
 * @author liuxiaokang
 * @date 2020/12/29
 */
public class Josefu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(10);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(2, 3, 10); // 2->4->1->5->3
        // circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
    }
    
    
}

class CircleSingleLinkedList {
    private Boy first = null;
    
    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("nums非法");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;
                cur = first;
            } else {
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }
    }
    
    public void showBoy() {
        if (first == null) {
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("%d\t", curBoy.no);
            if (curBoy.next == first) {
                break;
            }
            curBoy = curBoy.next;
        }
        System.out.println();
    }
    
    /**
     * 输出出队编号的序列
     *
     * @param startNo  从几号开始数
     * @param countNum 数到几出队 数countnum下其实节点移动countnum-1次, 因为自己会数一次
     * @param nums     环的长度
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误");
            return;
        }
        
        // 辅助指针应该指向当前节点的前一个, 帮助完成出圈
        Boy helper = first;
        // 把helper移动到first的前一个, 让helper一直跟着first
        while (helper.next!=first){
            helper = helper.next;
        }
    
        // 报数之前先定位到startNo同学
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        
        // 开始报数 指针同时移动m-1次, 是一个循环的操作, 直到圈中只有一个节点(helper和firt执行同一个节点了)
        while (helper != first) {
            // 让fist和helper同时移动counnum-1次
            for (int i = 0; i < countNum-1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // 数完以后fistr指向的就是要出圈的人
            System.out.print(first.no+"出圈\t");
            // 把出圈的小孩弄出去
            first = first.next;
            helper.next = first;
    
        }
        System.out.println("\n留在圈中的小孩:" + first.no);
        showBoy();
        
    }
}

class Boy {
    public int no;
    public Boy next;
    
    public Boy(int no) {
        this.no = no;
    }
    
    
}
