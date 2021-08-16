package test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

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
        Father aa = new Father("1", "aa");
        Father b = deepClone(aa);
        b.name="xx";
        
        
        // HashSet<Father> set = Sets.newHashSet(aa);
        // HashSet<Father> set2 = Sets.newHashSet();
        // set2 = set;
        // for (Father father : set2) {
        //     father.name="2";
        // }
    
        System.out.println(aa);
    }
    
    /**
     * 深拷贝工具
     * @author liuxiaokang
     * @date 2021/4/25
     */
    public static <S> S deepClone(S source) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(source);
            ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (S) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    @ToString
    @AllArgsConstructor
    static class Father {
        public String name;
        public String sex;
        
    }
}
