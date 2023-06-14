package leetcode_backtracking3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
//		List<Integer> list = new ArrayList<>();
//		for (int num : nums) {
//			list.add(num);
//		}
//
//		List<List<Integer>> main = new ArrayList<List<Integer>>();
//
//		permute(list, main, new ArrayList<Integer>());
//
//		System.out.println(main);

		System.out.println(getPermutations(nums));
	}

	public static void permute(List<Integer> nums, List<List<Integer>> main, List<Integer> temp) {

		if (nums.size() == 0) {
			if (main.contains(temp)) {
				return;
			}
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {

			List<Integer> n = new ArrayList<Integer>(nums);

			temp.add(n.remove(i));
			permute(n, main, temp);
			temp.remove(temp.size() - 1);

		}

	}

	public static List<List<Integer>> getPermutations(int[] nums) {

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

			available[i] = false;
			temp.add(nums[i]);
			getPermutations(nums, available, main, temp);
			temp.remove(temp.size() - 1);
			available[i] = true;

		}

	}

}
