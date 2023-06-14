package hackerBlocks_DS;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] span = new int[n];

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);
		}

		for (int sp : span) {
			System.out.print(sp + " ");
		}
		System.out.println("END");

		scn.close();
	}

}
