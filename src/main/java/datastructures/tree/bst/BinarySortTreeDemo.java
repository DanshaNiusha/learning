package datastructures.tree.bst;


/**
 * BST 二叉排序(搜索)树
 *
 * @author liuxiaokang
 * @date 2021/1/18
 */
public class BinarySortTreeDemo {
    
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.infixOrder(); // 1 2 3 5 7 9 10 12 自己画图这个就是bst
        binarySortTree.delNode(3);
        System.out.println("删除后--->");
        binarySortTree.infixOrder();
    }
    
    
}


/**
 * 创建二叉排序树
 */
class BinarySortTree {
    
    /**
     * 根节点
     */
    private Node root;
    
    /**
     * 删除结点
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        // 找到要删除的节点
        Node targetNode = search(value);
        // 没找到retrun
        if (targetNode == null) {
            return;
        }
        //如果我们发现当前这颗二叉排序树只有一个结点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        // 该删除了, 找到他的父节点
        Node parent = searchParent(value);
        // 情况1: 如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断target是左子节点还是右子节点
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {// 情况2: 删除有2个子树的节点
            // 右子树的最小节点的值换到待删除的节点来, 构造完以后还是bst(因为要满足bst的左小右大的特性,所以要从右子树来删)
            targetNode.value = delMinNode(targetNode.right);
        } else { // 情况3: 删除有1个子树的节点
            if (targetNode.left != null) {
                if (parent != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {
                if (parent != null) {
                    if (parent.left.value == value){
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                }else {
                    root = targetNode.right;
                }
            }
        }
    
    
        if (targetNode.left != null && targetNode.right == null) {
            if (parent.left != null && parent.left.value == value) {
                parent.left = targetNode.left;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = targetNode.right;
            }
        }
    
        if (targetNode.right != null && targetNode.left == null) {
            if (parent.left != null && parent.left.value == value) {
                parent.left = targetNode.left;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = targetNode.right;
            }
        }
    
    }
    
    /**
     * 删除node子树中最小的节点 并返回他的值
     * @param node 二叉排序树的根节点
     * @return  返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delMinNode(Node node) {
        // 临时保存
        Node target = node;
        // 循环的查找左节点就会找到最小值
        while (target.left!=null){
            target = target.left;
        }
        // 这时target已经指向了最小节点
        // 删除最小节点
        delNode(target.value);
        return target.value;
    
    }
    
    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    
    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    
    public void infixOrder() {
        if (root == null) {
            System.out.println("empty!!");
        } else {
            root.infixOrder();
            System.out.println();
        }
    }
    
}


class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }
    
    
    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) { //找到就是该结点
            return this;
        } else if (value < this.value) {//如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else { //如果查找的值不小于当前结点，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    
    
    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }
        
    }
    
    
    /**
     * 给一个节点添加节点
     * 思路:没有就直接挂上, 有东西就继续递归到没有 然后挂上
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
                
            }
        }
        
        if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
    
    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        
        System.out.print(this.value+"\t");
        
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}