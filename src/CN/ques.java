package CN;

import java.util.Scanner;

public class ques {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t > 0) {
			int a = s.nextInt();
			int b = s.nextInt();

			int pro = 1;
			for (int i = 1; i <= a; i++) {
				pro = (pro * i) % b;
			}
			System.out.println(pro);

			t--;
		}

		s.close();
	}

}
