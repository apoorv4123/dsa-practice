package leetcode_backtracking3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2_47 {

	public static void main(String[] args) {

		int[] nums = { 3, 3, 0, 3 };
		System.out.println(getPermutations(nums));

	}

	public static List<List<Integer>> getPermutations(int[] nums) {

		Arrays.sort(nums);

		boolean[] available = new boolean[nums.length];
		Arrays.fill(available, true);

		List<List<Integer>> main = new ArrayList<List<Integer>>();

		getPermutations(nums, available, main, new ArrayList<Integer>());

		return main;

	}

	private static void getPermutations(int[] nums, boolean[] available, List<List<Integer>> main, List<Integer> temp) {

		if (temp.size() == nums.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (!available[i]) {
				continue;
			}

			if (i > 0 && nums[i] == nums[i - 1] && available[i] && available[i - 1]) {
				continue;
			}

			available[i] = false;
			temp.add(nums[i]);
			getPermutations(nums, available, main, temp);
			temp.remove(temp.size() - 1);
			available[i] = true;

		}

	}

}
