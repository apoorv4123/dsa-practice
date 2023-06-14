package L11_mar8;

public class PrintSubSequences {

	public static void main(String[] args) {
		printSS("abc", "");
		printSSAscii("abc", "");
		printPermutations("abc", "");
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSS(roq, ans);
		printSS(roq, ans + ch);
	}

	public static void printSSAscii(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSSAscii(roq, ans);
		printSSAscii(roq, ans + ch);
		printSSAscii(roq, ans + (int) ch);
	}

	public static void printPermutations(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int c = 0; c < ques.length(); c++) {
			char ch = ques.charAt(c);
			String roq = ques.substring(0, c) + ques.substring(c + 1);
			printPermutations(roq, ans + ch);
		}
	}
}