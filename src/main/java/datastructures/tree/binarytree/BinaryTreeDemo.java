package datastructures.tree.binarytree;

import java.util.Objects;

/**
 * 二叉树前中后序遍历
 * @author liuxiaokang
 * @date 2021/1/8
 */
public class BinaryTreeDemo {
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "林冲");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "张三");
        HeroNode node4 = new HeroNode(4, "李四");
        HeroNode node5 = new HeroNode(5, "王五");
        
        // 正常应该递归创建 不应该手动创建
        node2.left = node4;
        node2.right = node5;
        root.left = node2;
        root.right = node3;
        tree.root = root;
        
        System.out.println("前序");
        tree.preOrder();
        System.out.println("中序");
        tree.infixOrder();
        System.out.println("后序");
        tree.postOrder();
        
        // 遍历
        // System.out.println(tree.preOrderSearch(2));
        // System.out.println(tree.postOrderSearch(2));
        // System.out.println(tree.infixOrderSearch(2));
    
        // 删除节点
        System.out.println("删除前,前序遍历");
        tree.preOrder(); //  1,2,3,5,4
        tree.delNode(2);
        System.out.println("删除后，前序遍历");
        tree.preOrder(); // 1,2,3,4
    
    }

}

/**
 * 二叉树
 */
class BinaryTree{
    public HeroNode root;
    
    // 前序 触发是由根节点触发的
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("empty tree");
        }
    }
    
    // 中序 触发是由根节点触发的
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("empty tree");
        }
    }
    
    // 后序 触发是由根节点触发的
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("empty tree");
        }
    }
    
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序查找");
        return root.preOrderSearch(no);
    }
    public HeroNode infixOrderSearch(int no) {
        System.out.println("中序查找");
        return root.infixOrderSearch(no);
    }
    public HeroNode postOrderSearch(int no) {
        System.out.println("后序查找");
        return root.postOrderSearch(no);
    }
    
    public void delNode(int no) {
        root.delNode(no);
    }
    
}


/**
 * 二叉树的节点
 */
class HeroNode{
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;
    
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    
    /**
     * 前序变量
     */
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        // 递归向左
        if (Objects.nonNull(this.left)) {
            this.left.preOrder();
        }
        // 递归向右
        if (Objects.nonNull(this.right)) {
            this.right.preOrder();
        }
    
    }
    
    /**
     * 中序变量
     */
    public void infixOrder(){
        // 递归向左
        if (Objects.nonNull(this.left)) {
            this.left.infixOrder();
        }
        
        System.out.println(this);
        
        // 递归向右
        if (Objects.nonNull(this.right)) {
            this.right.infixOrder();
        }
    }
    
    /**
     * 后序变量
     */
    public void postOrder(){
        // 递归向左
        if (Objects.nonNull(this.left)) {
            this.left.postOrder();
        }
        // 递归向右
        if (Objects.nonNull(this.right)) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
    
    
    /**
     * 前序遍历查找
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public HeroNode preOrderSearch(int no) {
        if (no == this.no) {
            return this;
        }
        HeroNode result = null;
        // 递归先左
        if (this.left != null) {
            result = this.left.preOrderSearch(no);
        }
        
        if (result != null) {//说明我们左子树找到
            return result;
        }
        // 递归后右
        if (this.right != null) {
            result = this.right.preOrderSearch(no);
        }
        System.out.println("not found:" + no);
        return result;
    }
    
    /**
     * 中序遍历查找
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode result = null;
        // 递归先左
        if (this.left != null) {
            result = this.left.infixOrderSearch(no);
        }
        
        if (result != null) {//说明我们左子树找到
            return result;
        }
        
        if (no == this.no) {
            return this;
        }
        
        // 递归后右
        if (this.right != null) {
            result = this.right.infixOrderSearch(no);
        }
        return result;
    }
    
    /**
     * 前序遍历查找
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode result = null;
        // 递归先左
        if (this.left != null) {
            result = this.left.postOrderSearch(no);
        }
    
        if (result != null) {
            return result;
        }
      
        // 递归后右
        if (this.right != null) {
            result = this.right.postOrderSearch(no);
        }
        //如果左右子树都没有找到，就比较当前结点是不是
        if (no == this.no) {
            return this;
        }
      
        return result;
    }
    
    /**
     * 递归删除结点
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     */
    public void delNode(int no) {
		/*
		 思路: **因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.**
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5. 如果第4步也没有删除结点，则应当向右子树进行递归删除.
		 */
        //1
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //2
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //3 递归
        if (this.left != null) {
            this.left.delNode(no);
        }
        //4
        if (this.right != null) {
            this.right.delNode(no);
        }
    
    
    }
    
    
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
