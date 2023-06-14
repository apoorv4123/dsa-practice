package Recursion;

import java.util.ArrayList;
import java.util.List;

public class recursion {
	static int c = 0;

	public static void main(String[] args) {
//		pd(5);
//		pi(5);
//		pdi(5);
//		printArray(new int[] { 1, 2, 3, 4, 5 }, 0);
//		printArrRev(new int[] { 1, 2, 3, 4, 5 }, 0);
//		System.out.println(maxArr(new int[] { 23, 56, 7, 344, 8, 90 }, 0));
//		System.out.println(firstIdx(new int[] { 10, 20, 40, 60, 70 }, 0, 30));
//		System.out.println(getSS("abc"));
//		System.out.println(keyPadCombinations("123"));
//		System.out.println(getCoinToss(3));
//		System.out.println(getPermutations("abc"));
//		System.out.println(getMP(0, 0, 2, 2));
//		System.out.println(getBP(0, 10));
//		printSS("abc", "");
//		printSSASCII("abc", "");
//		printKeyPaCombinations("123", "");
//		printCoinToss(2, "");
//		printPermutations("abc", "");
//		printMP(0, 0, 2, 2, "");
//		printBP(0, 6, "");
//		validParentheses(0, 0, 4, "");
//		lexicographicPrint(1, 100);
//		palindromePartitioning("nitiN", "");

//		BACKTRACKING
//		queenPermutations(new boolean[4], 2, 0, "");
//		queenCombinations(new boolean[4], 2, 0, 0, "");
//		queenCombinationBoxRes1d(new boolean[4], 2, 0, 0, "");
//		queenCombination2d(new boolean[2][3], 2, 0, 0, 0, "");
//		queenCombinations2dKill(new boolean[3][4], 2, 0, 0, 0, "");
//		nQueens(new boolean[4][4], 0, 0, 4, 0, "");
//		nQueens2(new boolean[4][4], 0, 4, 0, "");
//		kQueens(new boolean[4][4], 0, 3, 0, "");

	}

	public static void pd(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		pd(n - 1);
	}

	public static void pi(int n) {
		if (n == 0) {
			return;
		}
		pi(n - 1);
		System.out.println(n);
	}

	public static void pdi(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		pdi(n - 1);
		System.out.println(n);
	}

	public static void printArray(int[] arr, int idx) {
		if (idx == arr.length) {
			return;
		}
		System.out.println(arr[idx]);
		printArray(arr, idx + 1);
	}

	public static void printArrRev(int[] arr, int idx) {
		if (idx == arr.length) {
			return;
		}
		printArrRev(arr, idx + 1);
		System.out.println(arr[idx]);
	}

	public static int maxArr(int[] arr, int idx) {
		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int m = maxArr(arr, idx + 1);
		if (arr[idx] > m) {
			return arr[idx];
		}
		return m;
	}

	public static int firstIdx(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		if (arr[idx] == item) {
			return idx;
		}
		return firstIdx(arr, idx + 1, item);
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = getSS(ros);
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}
		return mr;
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> keyPadCombinations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String code = getCode(ch);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = keyPadCombinations(ros);
		for (int i = 0; i < code.length(); i++) {
			for (String val2 : rr) {
				mr.add(code.charAt(i) + val2);
			}
		}
		return mr;
	}

	public static ArrayList<String> getCoinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getCoinToss(n - 1);
		for (String val : rr) {
			mr.add('H' + val);
			mr.add('T' + val);
		}
		return mr;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getPermutations(ros);
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}
		return mr;
	}

	public static ArrayList<String> getMP(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrh = getMP(cr, cc + 1, er, ec);
		for (String val : rrh) {
			mr.add('H' + val);
		}
		ArrayList<String> rrv = getMP(cr + 1, cc, er, ec);
		for (String val : rrv) {
			mr.add('V' + val);
		}
		ArrayList<String> rrd = getMP(cr + 1, cc + 1, er, ec);
		for (String val : rrd) {
			mr.add('d' + val);
		}
		return mr;
	}

	public static ArrayList<String> getBP(int curr, int target) {
		if (curr == target) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (curr > target) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			ArrayList<String> rr = getBP(curr + i, target);
			for (String val : rr) {
				mr.add(i + val);
			}
		}
		return mr;
	}

	public static void printSS(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, ans);
		printSS(ros, ch + ans);
	}

	public static void printSSASCII(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSSASCII(ros, ans);
		printSSASCII(ros, ch + ans);
		printSSASCII(ros, (int) ch + ans);

	}

	public static void printKeyPaCombinations(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			printKeyPaCombinations(ros, ans + code.charAt(i));
		}
	}

	public static void printCoinToss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		printCoinToss(n - 1, 'H' + ans);
		printCoinToss(n - 1, 'T' + ans);
	}

	public static void printPermutations(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, ans + ch);
		}

	}

	public static void printMP(int cc, int cr, int ec, int er, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}
		printMP(cc + 1, cr, ec, er, ans + 'H');
		printMP(cc, cr + 1, ec, er, ans + 'V');
	}

	public static void printBP(int curr, int target, String ans) {
		if (curr == target) {
			System.out.println(ans);
			return;
		}
		if (curr > target) {
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			printBP(curr + dice, target, ans + dice);
		}
	}

	public static void validParentheses(int nopen, int nclose, int n, String ans) {
		if (nopen == nclose && nopen == n) {
			System.out.println(ans);
			return;
		}
		if (nopen > n || nclose > nopen) {
			return;
		}
		validParentheses(nopen + 1, nclose, n, ans + '(');
		validParentheses(nopen, nclose + 1, n, ans + ')');
	}

	public static void lexicographicPrint(int curr, int end) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		int i = 1;
		if (curr > 0) {
			i = 0;
		}
		for (; i <= 9; i++) {
			lexicographicPrint(curr * 10 + i, end);
		}
	}

	public static void palindromePartitioning(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		// this call will divide nitin as follows
		// itin,n tin,ni in,nit n,niti, _,nitin
		// here first call will give all those possibilities in which n is a part
		for (int i = 1; i <= str.length(); i++) {
			String ros = str.substring(i);
			String stobc = str.substring(0, i);
			if (isPalindrome(stobc, 0, stobc.length() - 1)) {
				palindromePartitioning(ros, ans + stobc + " ");
			}
		}
	}

	public static boolean isPalindrome(String str, int si, int ei) {
		if (si >= ei) {
			return true;
		}
		if (str.charAt(si) == str.charAt(ei)) {
			return isPalindrome(str, si + 1, ei - 1);
		}
		return false;
	}

	public static void queenPermutations(boolean[] box, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < box.length; i++) {
			if (box[i] == false) {
				box[i] = true;
				queenPermutations(box, tq, qpsf + 1, ans + "q" + qpsf + "b" + i);
				box[i] = false;
			}
		}
	}

	public static void queenCombinations(boolean[] box, int tq, int qpsf, int lastbox, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		for (int i = lastbox; i < box.length; i++) {
			if (box[i] == false) {
				box[i] = true;
				queenCombinations(box, tq, qpsf + 1, i, ans + "q" + qpsf + "b" + i);
				box[i] = false;
			}
		}
	}

	public static void queenCombinationBoxRes1d(boolean[] box, int tq, int qpsf, int col, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col == box.length) {
			return;
		}
		box[col] = true;
		queenCombinationBoxRes1d(box, tq, qpsf + 1, col + 1, ans + "b" + col);
		box[col] = false;
		queenCombinationBoxRes1d(box, tq, qpsf, col + 1, ans);

	}

	public static void queenCombination2d(boolean[][] box, int tq, int qpsf, int row, int col, String ans) {
		if (tq == qpsf) {
			System.out.println(++c + ". " + ans);
			return;
		}
		if (col == box[0].length) {
			row++;
			col = 0;
		}
		if (row == box.length) {
			return;
		}
		box[row][col] = true;
		queenCombination2d(box, tq, qpsf + 1, row, col + 1, ans + "(" + row + "," + col + ") ");
		box[row][col] = false;
		queenCombination2d(box, tq, qpsf, row, col + 1, ans);
	}

	public static void queenCombinations2dKill(boolean[][] box, int tq, int qpsf, int row, int col, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == box[0].length) {
			row++;
			col = 0;
		}
		if (row == box.length) {
			return;
		}
		if (isItPossibleToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			queenCombinations2dKill(box, tq, qpsf + 1, row, col + 1, ans + "(" + row + "," + col + ")");
			box[row][col] = false;
		}
		queenCombinations2dKill(box, tq, qpsf, row, col + 1, ans);

	}

	public static boolean isItPossibleToPlaceQueen(boolean[][] box, int row, int col) {
		for (int r = row, c = col; c >= 0; c--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0; r--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (box[r][c]) {
				return false;
			}
		}
		for (int r = row, c = col; r >= 0 && c < box[0].length; r--, c++) {
			if (box[r][c]) {
				return false;
			}
		}
		return true;
	}

	public static void nQueens(boolean[][] box, int row, int col, int tq, int qpsf, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col == box[0].length || row == box.length) {
			return;
		}
		if (isItPossibleToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			nQueens(box, row + 1, 0, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
			box[row][col] = false;
		}
		nQueens(box, row, col + 1, tq, qpsf, ans);

	}

	public static void nQueens2(boolean[][] box, int row, int tq, int qpsf, String ans) {
		if (row == box.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < box[0].length; col++) {
			if (isItPossibleToPlaceQueen(box, row, col)) {
				box[row][col] = true;
				nQueens2(box, row + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
				box[row][col] = false;
			}
		}
	}

	public static void kQueens(boolean[][] box, int row, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (row == box.length) {
			return;
		}
		for (int col = 0; col < box[0].length; col++) {
			if (isItPossibleToPlaceQueen(box, row, col)) {
				box[row][col] = true;
				kQueens(box, row + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
				box[row][col] = false;
			}
		}
		kQueens(box, row + 1, tq, qpsf, ans);
	}

}