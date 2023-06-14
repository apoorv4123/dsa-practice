package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Ques {

	public static void main(String[] args) {

		int[] cds = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> main = new ArrayList<>();
		ques(cds, target, main, new ArrayList<Integer>(), 0);
		System.out.println(main);

	}

	public static void ques(int[] cds, int tgt, List<List<Integer>> main, List<Integer> temp, int idx) {

		if (tgt == 0) {
			main.add(new ArrayList<>(temp));
			return;
		}

		if (tgt < 0 || idx == cds.length) {
			return;
		}

		// yes
		temp.add(cds[idx]);
		ques(cds, tgt - cds[idx], main, temp, idx);
		temp.remove(temp.size() - 1);
		// no
		ques(cds, tgt, main, temp, idx + 1);
	}

}
