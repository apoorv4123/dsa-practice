package L3_feb2;

import java.util.Scanner;

public class RotateANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		int r=s.nextInt();
		int nod=0,n=num,i=1;
		
		//count no of digits
		while(n>0) {
			nod=nod+1;
			n=n/10;
		}
		r=r%nod;
		if(r<0) {
			r=r+nod;
		}
		while(i<=r) {
			int digit =num%10;
			num=num/10;
			num=num+digit*(int)Math.pow(10,nod-1);
			i++;
		}
		System.out.println(num);
	}

}
