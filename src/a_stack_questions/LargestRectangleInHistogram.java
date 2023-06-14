package a_stack_questions;

//import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {

		int[] heights = { 2, 4};

		int[] nsr = nsr(heights);
		int[] nsl = nsl(heights);

//		for (int a : nsr) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
//		for (int a : nsl) {
//			System.out.print(a + " ");
//		}
//		System.out.println();

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			if (nsl[i] == -1) {
				int a = (nsr[i] - nsl[i] -  1) * heights[i];
				ans = a > ans ? a : ans;
			} else {
				int a = (nsr[i] - nsl[i] - 1) * heights[i];
				ans = a > ans ? a : ans;
			}
		}
		System.out.println(ans);
	}

	public static int[] nsl(int[] arr) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] nslarr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				nslarr[i] = -1; // -1
			} else {
				if (arr[stack.peek()] < arr[i]) {
					nslarr[i] = stack.peek();
				} else {
					while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						nslarr[i] = -1; // -1
					} else {
						nslarr[i] = stack.peek();
					}
				}
			}
			stack.push(i);
		}
		return nslarr;
	}

	public static int[] nsr(int[] arr) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] nsrarr = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			if (stack.isEmpty()) {
				nsrarr[i] = arr.length; // -1
			} else {
				if (arr[stack.peek()] < arr[i]) {
					nsrarr[i] = stack.peek();
				} else {
					while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						nsrarr[i] = arr.length; // -1
					} else {
						nsrarr[i] = stack.peek();
					}
				}
			}
			stack.push(i);
		}
		return nsrarr;
	}

}
