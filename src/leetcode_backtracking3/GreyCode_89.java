package leetcode_backtracking3;

import java.util.ArrayList;
import java.util.List;

public class GreyCode_89 {

	public static void main(String[] args) {

		System.out.println(grayCode(2));

	}

	public static List<Integer> grayCode(int n) {

		if (n == 0) {
			List<Integer> br = new ArrayList<Integer>();
			br.add(0);
			return br;
		}

		List<Integer> rr = grayCode(n - 1);

		List<Integer> mr = new ArrayList<Integer>(rr);

		for (int i = rr.size() - 1; i >= 0; i--) {
			mr.add(rr.get(i) + (int) Math.pow(2, n - 1));
		}
		return mr;
	}

}
