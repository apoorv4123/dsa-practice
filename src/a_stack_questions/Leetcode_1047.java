package a_stack_questions;

import java.util.Stack;

public class Leetcode_1047 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String str = "abbaca", ans = "";
		StringBuilder sb = new StringBuilder("");
		Stack<Character> stack = new Stack();
		
		for (int i = 0; i < str.length(); i++) {
			
			if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
				while (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
					stack.pop();
				}
			} else {
				stack.push(str.charAt(i));
			}
		}
		for(char c : stack) {
			sb.append(c);
		}
		System.out.println(sb);
	}
	

}
