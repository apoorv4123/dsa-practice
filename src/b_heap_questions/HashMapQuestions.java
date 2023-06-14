package b_heap_questions;

import java.util.HashMap;

public class HashMapQuestions {

	public static void main(String[] args) {
//		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
//		System.out.println(isHappy(7));
//		System.out.println(sq(91));
//		System.out.println(isIsomorphic("leet", "code"));

//		System.out.println(containsNearbyDuplicate(new int[] { 99, 99 }, 2));

//		System.out.println(isAnagram("dgqztusjuu", "dqugjzutsu"));

		System.out.println(lengthOfLongestSubstring(""));

	}

//	Leetcode 136
	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num))
				map.remove(num);
			else
				map.put(num, 1);
		}
		for (int key : map.keySet()) {
			return key;
		}
		return 0;
	}

// Leetcode 202
	public static boolean isHappy(int n) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (true) {
			System.out.println(n);
			if (n == 1) {
				return true;
			}
			if (map.containsKey(n)) {
				return false;
			}
			int a = n;
			int tnum = sq(n);
			map.put(a, tnum);
			n = tnum;
		}

	}

	public static int sq(int n) {
		int res = 0;
		while (n != 0) {
			res += (n % 10) * (n % 10);
			n /= 10;
		}
		return res;
	}

// Leetcode 205
	public static boolean isIsomorphic(String s, String t) {

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		boolean res = false;

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (t.charAt(i) == map.get(s.charAt(i))) {
					res = res || true;
					continue;
				}
				return false;
			} else {
				if (!map.containsValue(t.charAt(i))) {
					map.put(s.charAt(i), t.charAt(i));
					res = res || true;
					continue;
				}
				return false;
			}
		}
		return res;
	}

//	Leetcode 217
	public static boolean containsDuplicate(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			if (map.get(i) > 1) {
				return true;
			}
		}
		return false;
	}

// Leetcode 219
	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
			if (map.containsKey(nums[currentIndex])) {
				int previousIndex = map.get(nums[currentIndex]);
				if (currentIndex - previousIndex <= k) {
					return true;
				} else if (currentIndex - previousIndex > k) {
					map.put(nums[currentIndex], currentIndex);
				}
			} else {
				map.put(nums[currentIndex], currentIndex);
			}
		}
		return false;
	}

// Leetcode 242
	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> smap = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
			smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
		}

		for (char k : smap.keySet()) {
			if (smap.get(k) != 0) {
				return false;
			}
		}
		return true;
	}

// Leetcode 3
	public static int lengthOfLongestSubstring(String s) {

		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		int ans = 0, len = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				len = Math.max(ans, len);
				ans = 1;
				map.clear();
				map.put(s.charAt(i), true);
//				System.out.println();
			} else {
//				System.out.print(s.charAt(i) + " ");
				map.put(s.charAt(i), true);
				ans++;
			}
		}
		return Math.max(ans, len);

	}
}
