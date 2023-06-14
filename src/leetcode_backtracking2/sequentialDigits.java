package leetcode_backtracking2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sequentialDigits {

	// https://leetcode.com/problems/sequential-digits/

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<>();
		sd(1000, 13000, 0, al);
//		al.sort(null);
		Collections.sort(al);
		System.out.println(al);

	}

	public static void sd(int low, int high, int curr, List<Integer> temp) {

		if (curr >= low && curr <= high) {
			temp.add(curr);
//			return; // not to be done here
		}

		if (curr == 0) {

			for (int i = 1; i <= 9; i++) {
				sd(low, high, curr + i, temp);
			}

		} else {

			int lastdgt = curr % 10;
			if (lastdgt != 9) {
				sd(low, high, curr * 10 + (lastdgt + 1), temp);
			}
		}

	}

}
