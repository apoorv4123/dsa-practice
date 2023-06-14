package a_stack_questions;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath_leetcode71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);
			if (ch == '/') {

				if (!stack.isEmpty() && stack.peek() == '.') {
					stack.pop();
					continue;
				}

				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					if (stack.peek() == ch) {
						continue;
					} else if (stack.peek() >= 'a' && stack.peek() <= 'z' && i == s.length() - 1) {
						continue;
					} else if (stack.peek() >= 'a' && stack.peek() <= 'z' && i != s.length() - 1 && i > 0) {
						stack.push(ch);
					}
				}
			} else if (ch == '.') {
				if (stack.peek() == ch) {
					boolean v = false;
					while (true && !stack.isEmpty()) {
						if (v == true && stack.peek() == '/') {
							stack.pop();
							break;
						}
						if (stack.peek() == '/') {
							v = true;
						}
						stack.pop();
					}
				} else {
					stack.push(ch);
				}
			} else {
				if (stack.peek() == '.') {
					stack.pop();
				}
				stack.push(ch);
			}

		}

		while (stack.size() > 1 && stack.peek() == '/') {
			stack.pop();
		}

		String ans = "";
		stack.toString();
		for (char a : stack) {
			ans += a;
		}
		System.out.println(ans);

	}

}
