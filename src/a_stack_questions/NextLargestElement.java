package a_stack_questions;

import java.util.ArrayList;
import java.util.Stack;

// next greater to right
public class NextLargestElement {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 0, 0, 2, 4 };

		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				al.add(-1);
			} else if (stack.peek() > arr[i]) {
				al.add(stack.peek());
			} else {
				while (!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					al.add(-1);
				} else {
					al.add(stack.peek());
				}
			}
			stack.push(arr[i]); // push current element in stack 
		}

		for (int i = al.size() - 1; i >= 0; i--) {
			System.out.print(al.get(i) + " ");
		}

	}

}
