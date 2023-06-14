package a_stack_questions;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterToLeft {

	public static void main(String[] args) {

//		int[] arr = { 5, 3, 4, 0, 1, 2, 1 };
		int[] arr = {100, 80, 60, 70, 60, 75, 85};

		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				al.add(-1);
			} else {
				if (stack.peek() > arr[i]) {
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
			}
			stack.push(arr[i]);
		}
		for (int a : al) {
			System.out.print(a + " ");
		}
	}

}