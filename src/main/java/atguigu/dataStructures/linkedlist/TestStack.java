package atguigu.dataStructures.linkedlist;


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
    
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            while (l1 != null) {
                int l1val = l1.val;
                ListNode temp = l2;
                while (temp != null) {
                    int l2val = l2.val;
                    temp = temp.next;
                    if (l1val < l2val) {
                        res.next = l1;
                        break;
                    }
                }
                l1 = l1.next;
                res.next = l2;
            }
            return res;
        }
    }
}