package a_stack_questions;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };

		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				al.add(-1);
			} else if (arr[stack.peek()] > arr[i]) {
				al.add(stack.peek());
			} else {
				while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					al.add(-1);
				} else {
					al.add(stack.peek());
				}

			}
			stack.push(i);
		}

		int i = 0;
		for (int a : al) {
			System.out.print(i - a + " ");
			i++;
		}

	}

}
