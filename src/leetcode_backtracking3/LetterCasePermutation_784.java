package leetcode_backtracking3;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

	public static void main(String[] args) {
		String S = "a1b2";
		System.out.println(letterCasePermutation(S));
	}

	public static List<String> letterCasePermutation(String str) {

		List<String> list = new ArrayList<String>();
		letterCasePermutation(str, 0, "", list);
		return list;

	}

	public static void letterCasePermutation(String str, int idx, String ans, List<String> list) {

		if (str.length() == idx) {
			list.add(ans);
			return;
		}

		char ch = str.charAt(idx);

		if (Character.isDigit(ch)) {
			letterCasePermutation(str, idx + 1, ans + ch, list);
		} else {
			letterCasePermutation(str, idx + 1, ans + Character.toLowerCase(ch), list);
			letterCasePermutation(str, idx + 1, ans + Character.toUpperCase(ch), list);
		}
	}

}
