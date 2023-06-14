package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {

	public static void main(String[] args) {
		// print approach
		System.out.println(subsets(new int[] { 1, 2, 3 }));

		// get approach
		System.out.println(subsets(new int[] { 1, 2, 3 }, 0));
	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		subsets(nums, 0, new ArrayList<Integer>(), main);
		return main;
	}

	public static void subsets(int[] nums, int vidx, List<Integer> temp, List<List<Integer>> main) {

		if (vidx == nums.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		temp.add(nums[vidx]);
		subsets(nums, vidx + 1, temp, main);
		temp.remove(temp.size() - 1);
		subsets(nums, vidx + 1, temp, main);
	}

	public static List<List<Integer>> subsets(int[] nums, int vidx) {

		if (vidx == nums.length) {
			List<List<Integer>> br = new ArrayList<List<Integer>>();
			br.add(new ArrayList<Integer>());
			return br;
		}

		int fn = nums[vidx];
		List<List<Integer>> rr = subsets(nums, vidx + 1);
		List<List<Integer>> mr = new ArrayList<>();
		for (List<Integer> list : rr) {
			mr.add(new ArrayList<>(list));
			list.add(0, fn);
			mr.add(new ArrayList<>(list));
		}
		return mr;
	}
}