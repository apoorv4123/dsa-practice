package L4_feb9;

import java.util.Scanner;

public class L_case_U_case {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char ch = s.next().charAt(0);
		if (ch >= 'a' && ch <= 'z') {
			System.out.println("Lower Case");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("Upper Case");
		} else {
			System.out.println("Invalid Character");
		}
	}
}
