import java.util.Scanner;

/**
 * @author liuxiaokang
 * @date 2021/2/3
 */
public class Test {
    
    public static void main(String[] args) {
        //写一个简单的菜单
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int id = scanner.nextInt();
        int id1 = scanner.nextInt();
        System.out.println(s);
        System.out.println(id);
        System.out.println(id1);
        String name = scanner.next();
        
        
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