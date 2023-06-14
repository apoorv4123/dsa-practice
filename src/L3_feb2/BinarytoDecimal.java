package L3_feb2;

import java.util.Scanner;

public class BinarytoDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		int multiplier=1,deci=0;
		while(num>0) {
			int rem=num%10;
			deci=deci+rem*multiplier;
			multiplier=multiplier*2;
			num=num/10;
		}
		System.out.println(deci);
	}

}
