package hackerBlocks;

import java.util.Scanner;

public class MinNoFromSequenceRightApp {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String sequence = s.next();

		int[] ans = new int[sequence.length() + 1];

		int count = 1;

		for (int i = 0; i <= sequence.length(); i++) {

			if (i == sequence.length() || sequence.charAt(i) == 'I') {

				ans[i] = count++;

				for (int j = i - 1; j >= 0 && sequence.charAt(j) != 'I'; j--) {
					ans[j] = count++;
				}
			}

		}

		for (int val : ans) {
			System.out.print(val);
		}
		
		s.close();
	}
	
}