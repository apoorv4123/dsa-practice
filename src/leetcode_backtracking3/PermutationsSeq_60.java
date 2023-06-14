package leetcode_backtracking3;

import java.util.ArrayList;

public class PermutationsSeq_60 {

	public static void main(String[] args) {

		int n = 3;
		int k = 3;
		System.out.println(getPermutations(n, k));

	}

	public static String getPermutations(int n, int k) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}

		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		String ans = "";

//		return getPermutationsRec(n, k, list, factorial, ans);
		return getPermutationIterative(n, k, factorial, list);
	}

	private static String getPermutationsRec(int n, int k, ArrayList<Integer> list, int[] factorial, String ans) {

		if (n == 0) {
			return ans;
		}

		int group = k / factorial[n - 1];

		if (k % factorial[n - 1] != 0) {
			group++;
		}

		int newk = k - (group - 1) * factorial[n - 1];

		int element = list.remove(group);

		return getPermutationsRec(n - 1, newk, list, factorial, ans + element);

	}

	private static String getPermutationIterative(int n, int k, int[] factorial, ArrayList<Integer> list) {
		String ans = "";

		while (n != 0) {

			int group = k / factorial[n - 1];

			if (k % factorial[n - 1] != 0) {
				group++;
			}

			k = k - (group - 1) * factorial[n - 1];

			int element = list.remove(group);

			ans += element;
			n--;

		}

		return ans;

	}

}
