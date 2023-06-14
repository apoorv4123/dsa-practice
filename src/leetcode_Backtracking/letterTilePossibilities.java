package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterTilePossibilities {
	static int c = 0;

// https://leetcode.com/problems/letter-tile-possibilities/

	public static void main(String[] args) {
		System.out.println(numTilePossibilities("AAB"));
	}

	public static int numTilePossibilities(String tiles) {
		int[] freq = new int[26];
		for (int i = 0; i < tiles.length(); i++) {
			char ch = tiles.charAt(i);
			freq[ch - 'A']++;
		}
		numTilePossibilities(freq);
		return c;
	}

	public static int numTilePossibilities(int[] freq) {

//		if (ans.length() > 0) {
//			c++;
//		}
		
		int count=0;
		
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				freq[i]--;
//				numTilePossibilities(freq, ans + (char) (i + 'A'));
				count+=numTilePossibilities(freq);
				freq[i]++;
			}
		}
		
		return count+1;

	}
}