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
        Father person = new Father();
        person.name = "ren";
        person.sex = "1";
        Child father = new Child();
        father.name = "child";
        father.genfer= "das";
        father.sex  ="2";
    
        Child child = (Child) person;
        System.out.println(child);
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
