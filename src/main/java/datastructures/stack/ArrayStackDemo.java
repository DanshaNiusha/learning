package datastructures.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show:");
			System.out.println("exit:");
			System.out.println("push:");
			System.out.println("pop: ");
			System.out.println("输入");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		
	}

}

/**
 * 数组实现栈
 */
class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;// 栈顶
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if (isFull()) {
			System.out.println("full");
			return;
		}
		stack[++top] = value;
		
	}
	public int pop() {
		if (isEmpty()) {
			System.out.println("empty statck");
			throw new RuntimeException("empty");
		}
		return stack[top--];
		
	}
	public void list() {
		if(isEmpty()) {
			System.out.println("empty stack");
			return;
		}
		for (int i = stack.length-1; i >= 0; i--) {
			System.out.print(stack[i]+"\t");
		}
		
	}
	
}
