package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class maxLengthOfConcatStrUniqChar {

//	https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

	public static void main(String[] args) {

//		System.out.println(freqarr("asao"));
		List<String> arr = new ArrayList<String>();
//		arr.add("a");
//		arr.add("b");
//		arr.add("c");
//		arr.add("d");
//		arr.add("e");
//		arr.add("f");
//		arr.add("g");
//		arr.add("h");
//		arr.add("i");
//		arr.add("j");
//		arr.add("k");
//		arr.add("l");
//		arr.add("m");
//		arr.add("n");
//		arr.add("o");
//		arr.add("p");
//		arr.add("cha");
//		arr.add("r");
//		arr.add("act");
//		arr.add("ers");
//		arr.add("abcdefghijklmnopqrstuvwxyz");
		arr.add("un");
		arr.add("iq");
		arr.add("ue");
		System.out.println(maxLength(arr));

		mlen = 0;
		maxLengthUserRespect(arr, 0, "");
		System.out.println(mlen);
	}

	static int mlen = Integer.MIN_VALUE;

	public static void maxLengthUserRespect(List<String> arr, int idx, String ans) {
		if (ans.length() > mlen) {
			mlen = ans.length();
		}
		for (int i = idx; i < arr.size(); i++) {
			if (isDistinct(ans + arr.get(i)))
				maxLengthUserRespect(arr, i + 1, ans + arr.get(i));
		}

	}

	public static int maxLength(List<String> arr) {
		mlen = 0;
		maxLengthElementRespect(arr, 0, "");
		return mlen;
	}

	public static void maxLengthElementRespect(List<String> arr, int vidx, String ans) {

		if (vidx == arr.size()) {
			if (ans.length() > mlen)
				mlen = ans.length();
			return;
		}

		if (isDistinct(ans + arr.get(vidx)))
			maxLengthElementRespect(arr, vidx + 1, ans + arr.get(vidx));
		maxLengthElementRespect(arr, vidx + 1, ans);

	}

	public static boolean isDistinct(String str) {

		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (freq[ch - 'a'] > 0) {
				return false;
			}
			freq[ch - 'a']++;
		}
		return true;
	}

}