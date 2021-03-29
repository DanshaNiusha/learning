import java.util.LinkedList;
import java.util.List;

/**
 * @author liuxiaokang
 * @date 2021/2/3
 */
public class LinkedListTest {
    
    public static void main(String[] args) {
        ListNode head = create(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNode listNode = new LinkedListTest().removeElements(head, 6);
        System.out.println();
    }
    
    public ListNode removeElements(ListNode head, int val) {
        // 创建一个假头
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
    
    private static ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);
        return head;
    }
    
    
}


class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}



