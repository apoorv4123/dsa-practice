package L4_feb9;

import java.util.Scanner;

public class temperature {

	public static void main(String[] args) {
	
//		byte b=(byte)1000;
//		System.out.println(b);
//		char ch=(char) 65601;
//		System.out.println(ch);
//		int c=(int)((5.0/9.0)*(40-32));
//		System.out.println(c);
		Scanner s=new Scanner(System.in);
		int min=s.nextInt();
		int max=s.nextInt();
		int step=s.nextInt();
		for(int i=min;i<=max;i+=step) {
			int c=(int)((5f/9)*(i-32));
			System.out.println(i+"\t"+c);
		}
	}

}
