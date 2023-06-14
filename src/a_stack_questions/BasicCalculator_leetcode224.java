package a_stack_questions;

import java.util.Stack;

public class BasicCalculator_leetcode224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1+3";
		String[] arr = str.split("");
		for (String s : arr) {
			System.out.print(s + "  ");
		}
		System.out.println(calculate(str));
	}

	public static int calculate(String s) {

		Stack<Integer> stack = new Stack<>();

		String[] arr = s.split("");

		for (int i = 0; i < s.length(); i++) {
			display(stack);
			String ch = arr[i];
			if (ch.equals("(")) {
				stack.push(i);
			} else if (ch.equals(")")) {
				int val = stack.pop();
				stack.pop();
				stack.push(val);
			} else if (ch.equals("+")) {
				int ans = 0;
				if (arr[i + 1] != "+" || arr[i + 1] != "-")
					ans = stack.pop() + Integer.parseInt(arr[i++]);
				stack.push(ans);
			} else if (ch.equals("-")) {
				int ans = stack.pop() - Integer.parseInt(arr[i++]);
				stack.push(ans);
			} else if (ch.equals(" ")) {
				continue;
			} else {
				stack.push(Integer.parseInt(ch));
			}

		}
		return stack.pop();
	}

	public static void display(Stack<Integer> s) {
		System.out.println("\n" + "-------------");
		for (Integer i : s) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-------------");
	}

}
