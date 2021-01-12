package datastructures.tree;

/**
 * 数组和二叉树的相互转换 层序遍历
 * 公式:
 *  顺序存储二叉树的特点:
 * 1) 顺序二叉树通常只考虑完全二叉树
 * 2) 第 n 个元素的左子节点为 2 * n + 1
 * 3) 第 n 个元素的右子节点为 2 * n + 2
 * 4) 第 n 个元素的父节点为 (n-1) / 2
 * 5) n : 表示二叉树中的第几个元素(按 0 开始编号如图所示)
 * @author liuxiaokang
 * @date 2020/12/3 17:22
 */
public class ArrBinaryTreeDemo {
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		//创建一个 ArrBinaryTree
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		// arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
		arrBinaryTree.postOrder(); // 1,2,4,5,3,6,7
	}
	
}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrBinaryTree {
	private int[] arr;//存储数据结点的数组
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	public void preOrder() {
		this.preOrder(0);
	}
	
	public void postOrder() {
		this.postOrder(0);
	}
	
	/**
	 * 完成顺序存储二叉树的前序遍历
	 * @param index 数组的下标
	 */
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		// root
		System.out.println(arr[index]);
		// 左
		if (2 * index + 1 < arr.length) {
			preOrder(2 * index + 1);
		}
		
		// 右
		if (2 * index + 2 < arr.length) {
			preOrder(2 * index + 2);
		}
		
	}
	
	/**
	 * 完成顺序存储二叉树的后序遍历
	 * @param index 数组的下标
	 */
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		// 左
		if (2 * index + 1 < arr.length) {
			postOrder(2 * index + 1);
		}
		
		// 右
		if (2 * index + 2 < arr.length) {
			postOrder(2 * index + 2);
		}
		// root
		System.out.println(arr[index]);
		
	}
	
}

