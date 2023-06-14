package L8_feb23;

public class Stringbuilder {

	public static void main(String[] args) {
		String str = "Bopnsu!Rshw`tsbub";
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (i % 2 == 0) {
				ch--;
				sb.setCharAt(i, ch);
			} else {
				ch++;
				sb.setCharAt(i, ch);
			}
		}
		System.out.println(sb);

	}

}
