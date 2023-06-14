package hackerBlocks_DS;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListQuestions {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
//		sumOfTwoLinkedLists();
		tripletFrom3LLs();
	}

	public static void sumOfTwoLinkedLists() {

		LinkedList<Integer> ll1 = new LinkedList<>();
		LinkedList<Integer> ll2 = new LinkedList<>();

		// Sizes of linked lists
		int n = s.nextInt();
		int m = s.nextInt();

		// values for first linked list
		for (int i = 1; i <= n; i++) {
			ll1.addLast(s.nextInt());
		}

//		for (int i = 0; i < ll1.size(); i++) {
//			System.out.print(ll1.get(i) + " ");
//		}
//		System.out.println();

		// values for second linked list
		for (int i = 1; i <= m; i++) {
			ll2.addLast(s.nextInt());
		}

//		for (int i = 0; i < ll2.size(); i++) {
//			System.out.print(ll2.get(i) + " ");
//		}
//		System.out.println();

		int carry = 0;
		LinkedList<Integer> ans = new LinkedList<>();
		while (ll1.size() != 0 && ll2.size() != 0) {

			int ab = ll1.removeLast();
			int be = ll2.removeLast();
			int sum = ab + be + carry;

			ans.addFirst(sum % 10);

			carry = sum / 10;

		}

		if (ll1.size() == 0) {
			while (ll2.size() != 0) {
				int sum = ll2.removeLast() + carry;
				ans.addFirst(sum % 10);
				carry = sum / 10;
			}
		}

		if (ll2.size() == 0) {
			while (ll1.size() != 0) {
				int sum = ll1.removeLast() + carry;
				ans.addFirst(sum % 10);
				carry = sum / 10;
			}
		}

		if (carry != 0) {
			ans.addFirst(carry);
		}

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static void tripletFrom3LLs() {

		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();

		LinkedList<Integer> ll1 = new LinkedList<>();
		LinkedList<Integer> ll2 = new LinkedList<>();
		LinkedList<Integer> ll3 = new LinkedList<>();

		for (int i = 0; i < a; i++) {
			ll1.addLast(s.nextInt());
		}

		for (int i = 0; i < b; i++) {
			ll2.addLast(s.nextInt());
		}

		for (int i = 0; i < c; i++) {
			ll3.addLast(s.nextInt());
		}

		int target = s.nextInt();

		for (int i = 0; i < ll1.size(); i++) {
			for (int j = 0; j < ll2.size(); j++) {
				for (int k = 0; k < ll3.size(); k++) {
					if (ll1.get(i) + ll2.get(j) + ll3.get(k) == target) {
						System.out.println(ll1.get(i) + " " + ll2.get(j) + " " + ll3.get(k));
						System.exit(0);
//						break;
					}
				}
			}
		}

	}

}
