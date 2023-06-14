package a_stack_questions;

import java.util.ArrayList;

public class MinStack {

	private int tos;
	private ArrayList<Node> al;

	/** initialize your data structure here. */
	public MinStack() {
		this.tos = -1;
		this.al = new ArrayList<>();
	}

	public void push(int x) {
		if (tos == -1)
			al.add(new Node(x, x));
		else
			al.add(new Node(x, Math.min(x, al.get(tos).min)));
		tos++;
	}

	public void pop() {
		al.remove(tos--);
	}

	public int top() {
		return al.get(tos).val;
	}

	private class Node {
		int val;
		int min;

		public Node(int val, int min) {
			this.val = val;
			this.min = min;
		}

	}

	public int getMin() {
		return al.get(tos).min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top()); // return 0
		System.out.println(minStack.getMin()); // return -2
	}
}
