package a_stack_questions;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveOuterParentheses_leetcode1021 {

	public static void main(String[] args) {

		String s = "(()())(())(()(()))", ans = "";
		Stack<Character> stack = new Stack<>();
		int o = 0, c = 0;
		StringBuilder sb2 = new StringBuilder("");
 		ArrayList<Character> sb = new ArrayList<Character>();
		
 		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				o++;
			} else {
				c++;
			}
			stack.push(ch);
			if (stack.size() % 2 == 0 && stack.peek() == ')' && o == c) {
				stack.pop();
				String ts = "";
				StringBuilder sb1 = new StringBuilder("");
				while (stack.size() != 1) {
					char c1 = stack.pop();
//					sb.add(0, c1);
					sb1.append(c1);
					ts = c1 + ts;
				}
				String s2 = sb1.reverse().toString();
				sb2.append(s2);
				ans += rev(ts);
				stack.pop();
			}
		}
		System.out.println(sb2);
		System.out.println(ans);
	}

	public static String rev(String s) {
		char[] ca = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
			char ch = ca[i];
			ca[i] = ca[j];
			ca[j] = ch;
		}
		String s1 = "";
		for (char c : ca) {
			s1 += c;
		}
		return s1;
	}
}
