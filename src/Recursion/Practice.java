package Recursion;

import java.util.Collections;
import java.util.HashMap;

public class Practice {

	public static void main(String[] args) {

		System.out.println(superReducedString("aaaaabbbccddd"));

	}

	public static String superReducedString(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		StringBuilder str = new StringBuilder("");

		for (Character key : map.keySet()) {
			if (map.get(key) % 2 != 0) {
				str.append(key);
			}
		}

		Collections.sort(s);
		
		String res = str.toString();
		
		if (res.length() == 0) {
			return "Empty String";
		}
		return res;
	}

}
