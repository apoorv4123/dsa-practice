package hackerBlocks_Recursion;

import java.util.ArrayList;

public class codesOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printCodes("1125", "");
		System.out.println(getCodes("1125"));

		// Best approach
		ArrayList<String> al = new ArrayList<>();
		printCodesWithArrayList("1125", "", al);
		System.out.println(al);

	}

	public static void printCodes(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		// 1 digit encode call
		char ch = ques.charAt(0);
		String roq1 = ques.substring(1);

		printCodes(roq1, ans + encode1(ch));

		// 2 digit call
		if (ques.length() >= 2) {

			String ch2 = ques.substring(0, 2);
			String roq2 = ques.substring(2);

			if (Integer.parseInt(ch2) <= 26)
				printCodes(roq2, ans + encode2(ch2));
		}

	}

	public static void printCodesWithArrayList(String ques, String ans, ArrayList<String> al) {

		if (ques.length() == 0) {
			al.add(ans);
			return;
		}

		// 1 digit encode call
		char ch = ques.charAt(0);
		String roq1 = ques.substring(1);

		printCodesWithArrayList(roq1, ans + encode1(ch), al);

		// 2 digit call
		if (ques.length() >= 2) {

			String ch2 = ques.substring(0, 2);
			String roq2 = ques.substring(2);

			if (Integer.parseInt(ch2) <= 26)
				printCodesWithArrayList(roq2, ans + encode2(ch2), al);
		}

	}

	public static ArrayList<String> getCodes(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		// 1 digit encode call
		char ch = ques.charAt(0); // '1'
		String roq1 = ques.substring(1); // 125

		ArrayList<String> rr1 = getCodes(roq1); // [abe, le, ay]

		for (String val : rr1) {
			mr.add(encode1(ch) + val); // [aabe, ale, aay]
		}

		// 2 digit call
		if (ques.length() >= 2) {

			String ch2 = ques.substring(0, 2); // "11"
			String roq2 = ques.substring(2); // "25"

			if (Integer.parseInt(ch2) <= 26) {
				ArrayList<String> rr2 = getCodes(roq2); // [be, y]

				for (String val : rr2) {
					mr.add(encode2(ch2) + val); // [kbe, ky]
				}
			}

		}

		return mr;
	}

	public static char encode1(char ch) {

		// convert from char to int
		int in = ch - '0';

		// add 96 and typecast to char
		return (char) (in + 96);

	}

	public static char encode2(String str) {

		// convert from string to int
		int in = Integer.parseInt(str);

		// add 96 and typecast to char
		return (char) (96 + in);

	}

}