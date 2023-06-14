package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {

	public static void main(String[] args) {

		System.out.println(combinationSum3(3, 7));

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> main = new ArrayList<List<Integer>>();

		combinationSum3(k, n, 1, main, new ArrayList<Integer>());

		return main;

	}

	private static void combinationSum3(int k, int n, int idx, List<List<Integer>> main, ArrayList<Integer> temp) {

		if (n == 0 && k == 0) {
			main.add(new ArrayList<>(temp));
			return;
		}

		if (n < 0 || k < 0 || idx > 9) { // not necessary
			return;
		}

		for (int i = idx; i <= 9; i++) {
			temp.add(i);
			combinationSum3(k - 1, n - i, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
