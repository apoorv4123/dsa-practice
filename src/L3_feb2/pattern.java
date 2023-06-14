package L3_feb2;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int nsp1=n-1;
		int nsp2=0;
		int nst=1;
		int row=1;
		while(row<=n) {
			//space1
			int csp1=1;
			while(csp1<=nsp1) {
				System.out.print(" ");
				csp1++;
			}
			//stars
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			//space2
			int csp2=1;
			while(csp2<=nsp2) {
				System.out.print(" ");
				csp2++;
			}
			//stars
			int cst1=1;
			if(row==1 || row==n) {
				cst1=2;
			}
			while(cst1<=nst) {
				System.out.print("*");
				cst1++;
			}
			System.out.println();
			if(row<n/2+1) {
				nsp1-=2;
				nst++;
				nsp2+=2;
			}
			else {
				nsp1+=2;
				nst--;
				nsp2-=2;
				
			}
			row++;
		}
	
	}
}