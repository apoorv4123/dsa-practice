package L8_feb23;

public class StringOps {

	public static void main(String[] args) {
		String str = "naman";
		if (isPalindrome(str)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		allsubstrings(str);
		System.out.println(countofPalSubstr(str));

	}

	public static boolean isPalindrome(String str) {
		boolean flag = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void allsubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static int countofPalSubstr(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String st = str.substring(i, j);
				if (isPalindrome(st)) {
					count++;
				}
			}
		}
		return count;
	}

}
