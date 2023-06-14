package L8_feb23;

import java.util.Scanner;

public class Question1 {
static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		String str=scn.nextLine();
		//String str = "The Sky is Blue";
		ReverseWordsinString(str);
		// Expected output is "Blue is Sky The"
	}

	public static void ReverseWordsinString(String str) {
		String nstr = "";
		String s = str;
		while (nstr.length() < str.length()) {
			int id1 = s.lastIndexOf(" ");
			nstr = nstr.concat(s.substring(id1 + 1, s.length()));

			if (id1 != -1) {
				nstr = nstr + " ";
				s = s.substring(0, id1);
			}
		}
	//	System.out.println(str.length());
		System.out.println(nstr);
	//	System.out.println(nstr.length());
	}
}
