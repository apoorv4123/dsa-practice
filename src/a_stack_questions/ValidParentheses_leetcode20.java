package a_stack_questions;

import java.util.Stack;

public class ValidParentheses_leetcode20 {

	public static void main(String[] args) {
		System.out.println(validParentheses("(){}}{"));
	}

	public static boolean validParentheses(String s) {

		if (s.length() == 0) {
			return true;
		}
		if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		int i = 0;
		while (i < s.length()) {
			
			char ch = s.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {

				if(stack.isEmpty()) {
					return false;
				}
				
				if (ch == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				} else if (ch == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
				} else if (ch == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
				}

			}
			i++;
		}
		return stack.isEmpty();
	}

}
