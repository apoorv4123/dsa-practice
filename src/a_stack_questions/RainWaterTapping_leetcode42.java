package a_stack_questions;

import java.util.ArrayList;
import java.util.Stack;

public class RainWaterTapping_leetcode42 {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int[] arr = { 4, 2, 0, 3, 2, 5 };

		// max to left array
		int[] maxlarr = new int[arr.length];
		maxlarr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxlarr[i - 1])
				maxlarr[i] = arr[i];
			else
				maxlarr[i] = maxlarr[i - 1];
		}

		// max to right array
		int maxr = arr[arr.length - 1];
		int[] maxrarr = new int[arr.length];
		maxrarr[arr.length - 1] = maxr;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > maxr) {
				maxr = arr[i];
			}
			maxrarr[i] = maxr;
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans += Math.min(maxlarr[i], maxrarr[i]) - arr[i];
		}
		System.out.println(ans);

	}

	public static ArrayList<Integer> ngr(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = arr.length - 1; i >= 0; i--) {

			if (stack.isEmpty()) {
				al.add(0, -1);
			} else {
				if (stack.peek() > arr[i]) {
					al.add(0, stack.peek());
				} else {
					while (!stack.isEmpty() && stack.peek() <= arr[i]) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						al.add(0, -1);
					} else {
						al.add(0, stack.peek());
					}
				}
			}
			stack.push(arr[i]);
		}
		return al;
	}

	public static ArrayList<Integer> ngl(int[] arr) {

		Stack<Integer> stack = new Stack<>();
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
		return al;
	}

}
