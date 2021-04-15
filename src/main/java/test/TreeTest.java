package test;

import lombok.ToString;

/**
 * @author liuxiaokang
 * @date 2021/3/19
 */
public class TreeTest {
    static class TreeNode {
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
    
    public static void main(String[] args) {
        Father father = new Father();
        father.name = "ren";
        father.sex = "1";
        Child child = new Child();
        child.name = "child";
        child.genfer= "das";
        child.sex  ="2";
    
        Father f = child;
        System.out.println(f);
        Father fa = child;
        System.out.println(fa);
    
    }
    @ToString
    static class Father {
        public String name;
        public String sex;
        
    }
    @ToString
    static class Child extends Father {
        public String genfer;
    }
}
