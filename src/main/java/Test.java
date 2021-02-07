import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuxiaokang
 * @date 2021/2/3
 */
public class Test {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
    
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 一直指向左节点
                stack.push(cur);
                cur = cur.left;
            } else {
                // 直到左节点空了
                cur = stack.pop(); // 栈中放的是历史遍历下来的节点
                list.add(cur.val); // 加进去
                cur = cur.right; // 指向right再继续看右边有没有值
            }
        }
    
        return list;
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
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}