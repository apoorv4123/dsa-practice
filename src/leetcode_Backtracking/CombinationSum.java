package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

//		int[] candidates = { 2, 3, 6, 7 };
//		int[] c = { 2, 5, 2, 1, 2 };
//		Arrays.sort(c);
//		List<List<Integer>> ans = combinationSum(c, 5);
//		System.out.println(ans);

		List<List<Integer>> ans = combinationSum3(3, 7);
		System.out.println(ans);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> main = new ArrayList<>();
		// CASE 1- COIN CHANGE
//		combinationSum1(candidates, target, 0, new ArrayList<Integer>(), main);

		// CASE 3- COIN CHANGE
//		combinationSum2(candidates, target, 0, new ArrayList<Integer>(), main);
		return main;

	}

	public static void combinationSum1(int[] candidates, int amount, int idx, List<Integer> temp,
			List<List<Integer>> main) {

		if (amount == 0) {
			main.add(new ArrayList<>(temp));
			return;
		}

		if (amount < 0 || idx == candidates.length) {
			return;
		}

		for (int i = idx; i < candidates.length; i++) {

			temp.add(candidates[i]);
			combinationSum1(candidates, amount - candidates[i], i, temp, main); // i bcoz of infinite supply
			temp.remove(temp.size() - 1);

		}

	}

	public static void combinationSum2(int[] candidates, int amount, int idx, List<Integer> temp,
			List<List<Integer>> main) {

		if (amount == 0) {
//			for (List<Integer> l : main) {
//				if (l.equals(temp)) {
//					return;
//				}
//			}
			main.add(new ArrayList<>(temp));
			return;
		}

		if (amount < 0 || idx == candidates.length) {
			return;
		}

		for (int i = idx; i < candidates.length; i++) {

			if (i > idx && candidates[i] == candidates[i - 1]) {
				continue;
			}

			temp.add(candidates[i]);
			combinationSum2(candidates, amount - candidates[i], i + 1, temp, main);
			temp.remove(temp.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> main = new ArrayList<>();

		combinationSum3(k, n, 1, 0, new ArrayList<Integer>(), main);
		return main;

	}

	// n is target, cc is current count
	public static void combinationSum3(int k, int n, int idx, int cc, List<Integer> temp, List<List<Integer>> main) {

		if (cc == k && n == 0) {
			main.add(new ArrayList<>(temp));
			return;
		}

		for (int i = idx; i <= 9; i++) {
			temp.add(i);
			combinationSum3(k, n - i, i + 1, cc + 1, temp, main);
			temp.remove(temp.size() - 1);
		}
	}
}