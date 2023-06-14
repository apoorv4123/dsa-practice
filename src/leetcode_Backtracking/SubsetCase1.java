package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetCase1 {

	public static void main(String[] args) {

		List<List<Integer>> main = new ArrayList<List<Integer>>();
//		elementRespect(new int[] { 1, 2, 3 }, 0, main, new ArrayList<Integer>());
//		System.out.println(main);

		userRespect(new int[] { 1, 2, 3 }, 0, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	public static void elementRespect(int[] arr, int idx, List<List<Integer>> main, List<Integer> temp) {

		if (idx == arr.length) {
			main.add(new ArrayList<>(temp));
			return;
		}

		temp.add(arr[idx]);
		elementRespect(arr, idx + 1, main, temp);// yes
		temp.remove(temp.size() - 1);

		elementRespect(arr, idx + 1, main, temp);// no
	}

	public static void userRespect(int[] arr, int idx, List<List<Integer>> main, List<Integer> temp) {

		main.add(new ArrayList<>(temp));

		for (int i = idx; i < arr.length; i++) {
			temp.add(arr[i]);
			userRespect(arr, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	

}