package L3_feb2;

import java.util.Scanner;

public class InverseNumber {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long num=s.nextLong();
		int pos=1;
		long n=num,n1=0;
		
		int count=0;
		while(n>0) {
			int digit=(int)n%10;
			count=count+1;
			n=n/10;
		}
		while(pos<=count) {
			int digit=(int)num%10;
			n1=n1+pos*(int)Math.pow(10, digit-1);
			num=num/10;
			pos=pos+1;
			}
		System.out.println(n1);
	}
}
