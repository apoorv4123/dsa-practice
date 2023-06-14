package a_stack_questions;

import java.util.Stack;

public class EvaluateRPN_leetcode150 {

	public static void main(String[] args) {

		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));

	}

	public static int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();
		int num2, num1;
		int i = 0;
		while (i < tokens.length) {

			String str = tokens[i];

			if (str.equals("+")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 + num2);
			} else if (str.equals("-")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 - num2);
			} else if (str.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (str.equals("/")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 / num2);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
			i++;
		}
		return stack.pop();
	}

}
