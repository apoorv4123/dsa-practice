package hackerBlocks_Recursion;

public class dictionaryOrder {

	public static void main(String[] args) {
		printPermutations("bacd", "bacd", "");

	}

	public static void printPermutations(String os, String str, String ans) { // larger

		if (str.length() == 0) {
			if (ans.compareTo(os) > 0)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(os, ros, ans + str.charAt(i));
		}

	}

}