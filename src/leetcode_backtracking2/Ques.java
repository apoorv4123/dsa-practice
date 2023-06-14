package leetcode_backtracking2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Ques {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
//		String ques = "25525511135";
//		restIPadd(ques, "", 0, list);
//		System.out.println(list);

		
	}
	
	public static List<String> binarywatch(int n) {
		
		List<String> list = new ArrayList<String>();
		
		binarywatch( n, 0, 0, "", list);
		
		return list;
		
	}

	private static void binarywatch(int n, int hour, int min, String ans, List<String> list) {
	
		// hour light on
		binarywatch(n-1,hour)
	}

}
