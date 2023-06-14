package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeCombinationCase2 {

	public static void main(String[] args) {
		// each coin in denomination can be used only once and there are no duplicate
		// coins in denomination

		// 1. User's respect
		int[] denominations = { 2, 3, 4, 5 };
//		int[] denominations= {1,2,2,3}; target:3
		List<List<Integer>> main = new ArrayList<>();
		userRespectCase2(denominations, 7, new ArrayList<Integer>(), main, 0);
		System.out.println(main);
		// 2. coin's respect
		main.clear();
		coinRespectCase2(denominations, 7, new ArrayList<Integer>(), main, 0);
		System.out.println(main);

	}

	public static void userRespectCase2(int[] denom, int target, ArrayList<Integer> temp, List<List<Integer>> main,
			int idx) {// idx is lastcoinused

		if (target == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (idx == denom.length || target < 0) {
			return;
		}

		for (int i = idx; i < denom.length; i++) {
			temp.add(denom[i]);
			userRespectCase2(denom, target - denom[i], temp, main, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

	public static void coinRespectCase2(int[] denom, int target, ArrayList<Integer> temp, List<List<Integer>> main,
			int idx) {

		if (target == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (idx == denom.length || target < 0) {
			return;
		}

		temp.add(denom[idx]);
		coinRespectCase2(denom, target - denom[idx], temp, main, idx + 1); // yes
		temp.remove(temp.size() - 1);
		coinRespectCase2(denom, target, temp, main, idx + 1); // no
	}
}