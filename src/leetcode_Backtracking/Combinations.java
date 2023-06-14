package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// all possible combinations of k numbers out of 1 to n
		List<List<Integer>> main = new ArrayList<List<Integer>>();
		combine(4, 2, 0, 1, new ArrayList<Integer>(), main);
		System.out.println(main);

	}

	// cc is current count
	public static void combine(int n, int k, int cc, int idx, List<Integer> temp, List<List<Integer>> main) {

		if (cc == k) {
			main.add(new ArrayList<>(temp));
			return;
		}

		if (idx > n) {
			return;
		}

		for (int i = idx; i <= n; i++) {
			temp.add(i);
			combine(n, k, cc + 1, i + 1, temp, main);
			temp.remove(temp.size() - 1);
		}
	}

}