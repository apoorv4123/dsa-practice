package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetCase2 {

	// subsets with duplicates

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> main = new ArrayList<List<Integer>>();
		int[] arr = { 2, 1, 2 };
		Arrays.sort(arr);
		userRespect(arr, 0, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	// array has to be sorted before using it to find sunsets
	public static void userRespect(int[] arr, int idx, List<List<Integer>> main, List<Integer> temp) {

		main.add(new ArrayList<>(temp));

		for (int i = idx; i < arr.length; i++) {

			if (i > idx && arr[i] == arr[i - 1]) {
				continue;
			}

			temp.add(arr[i]);
			userRespect(arr, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
