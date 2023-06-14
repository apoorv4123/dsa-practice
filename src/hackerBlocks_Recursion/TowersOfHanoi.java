package hackerBlocks_Recursion;

import java.util.Scanner;

public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		TOH(3, "S", "D", "H");
		s.close();
	}

	// BP: to transfer n discs from source to destination using helper
	public static void TOH(int n, String src, String dstn, String helper) {

		if (n == 0) {
			return;
		}

		// SP: n-1 disks from src->helper using dstn
		TOH(n - 1, src, helper, dstn);

		// SW: nth disk from src->dstn
		System.out.println(n + " from " + src + " to " + dstn);

		// SP: n-1 disks from helper->dstn using src
		TOH(n - 1, helper, dstn, src);

	}

}