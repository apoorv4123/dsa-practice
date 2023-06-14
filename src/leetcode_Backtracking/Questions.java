package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Questions {

	public static void main(String[] args) {

//		List<String> ans = new ArrayList<>();
//		genParenthesis(3, 0, 0, ans, "");
//		System.out.println(ans);

//		List<List<String>> ans = new ArrayList<>();
//		nQueens(new boolean[4][4], 0, 0, 0, ans, new ArrayList<>(), "");
//		System.out.println(ans);
//
		int[] nums = { 1, 1, 2 };
		ArrayList<Integer> num = new ArrayList<>();
		for (int val : nums) {
			num.add(val);
		}
		List<List<Integer>> ans = new ArrayList<>();
		genPermutationsii(num, ans, new ArrayList<>());
		System.out.println(ans);

//		List<List<String>> ans = new ArrayList<>();
//		List<String> a = getper("abc", ans);
//		for (int i = 0; i < a.size(); i++) {
//			List<String> al=new ArrayList<>();
//			al.add(a.get(i));
//			ans.add(al);
//		}
//		System.out.println(ans);

	}

	public static void genParenthesis(int n, int nopen, int nclose, List<String> mr, String ans) {

		if (nopen == nclose && nopen == n) {
			mr.add(ans);
			return;
		}
		if (nopen > n || nclose > nopen) {
			return;
		}
		genParenthesis(n, nopen + 1, nclose, mr, ans + "(");
		genParenthesis(n, nopen, nclose + 1, mr, ans + ")");
	}

	public static void nQueens(boolean[][] box, int row, int col, int qpsf, List<List<String>> mr, List<String> str,
			String ans) {

		if (qpsf == box.length) {
			mr.add(new ArrayList<>(str));
			return;
		}
		if (col == box[0].length) {
			str.add(ans);
			row++;
			col = 0;
		}
		if (row == box.length) {
			return;
		}
		if (isItPossible(box, row, col)) {
			box[row][col] = true;
			str.add("Q");
			nQueens(box, row, col + 1, qpsf + 1, mr, str, ans + "Q");
			box[row][col] = false;
		}
		nQueens(box, row, col + 1, qpsf, mr, str, ans + ".");

	}

	private static boolean isItPossible(boolean[][] box, int row, int col) {
		for (int r = row, c = col; c >= 0; c--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0; r--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c >= box[0].length; r--, c++) {
			if (box[r][c]) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> getper(String str, List<List<String>> ans) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getper(ros, ans);
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		return mr;
	}

	public static void genPermutationsii(List<Integer> nums, List<List<Integer>> ans, List<Integer> al) {

		if (nums.size() == 0) {
			for(List<Integer> val:ans) {
				if(val.equals(al)) {
					return;
				}
			}
			ans.add(new ArrayList<>(al));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {

			List<Integer> num = new ArrayList<>();
			for (int val : nums) {
				num.add(val);
			}
			int n1 = num.remove(i);
			al.add(n1);
			genPermutationsii(num, ans, al);
			al.remove(al.size() - 1);

		}

	}

}