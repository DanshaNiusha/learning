package test;

import com.google.common.collect.Lists;
import lombok.ToString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
        // Father father = new Father();
        // father.name = "ren";
        // father.sex = "1";
        //
        // ArrayList<String> list = Lists.newArrayList("1", "2");
        // ArrayList<String> list1 = deepClone(list);
        // list.remove("1");
        // System.out.println(list1);
        // System.out.println((3&1));
        // System.out.println((3&2));
        // System.out.println((3&3));
        // System.out.println((3&4));
        // System.out.println((3&5));
        // System.out.println((3&6));
        // System.out.println((3&7));
        
        
        System.out.println(2|0|0|0);
        System.out.println(2|1);
        // Child child = new Child();
        // child.name = "child";
        // child.genfer= "das";
        // child.sex  ="2";
        //
        // Father f = child;
        // System.out.println(f);
        // Father fa = child;
        // System.out.println(fa);
        // System.out.println(15|5);
    
    }
    
    
    /**
     * 深拷贝工具
     * @author liuxiaokang
     * @date 2021/4/25
     */
    public static <T> T deepClone(T source) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(source);
            ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (Exception e) {
            return null;
        }
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
