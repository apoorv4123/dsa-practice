package hackerBlocks_DS;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}

		Stack<Integer> stack = new Stack<Integer>();

		long res = 0;

		int i = 0;

		while (i < arr.length) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				long pb = arr[stack.pop()];
				int r = i;
				long area;
				if (stack.isEmpty()) {
					area = r * pb;
				} else {
					int l = stack.peek();
					area = (r - l - 1) * pb;
				}
				if (area > res) {
					res = area;
				}
			}

		}

		while (!stack.isEmpty()) {
			long pb = arr[stack.pop()];

			int r = i;

			long area;

			if (stack.isEmpty()) {
				area = r * pb;
			} else {
				int l = stack.peek();
				area = (r - l - 1) * pb;
			}
			if (area > res) {
				res = area;
			}

		}

		System.out.println(res);
		scn.close();
	}

}
