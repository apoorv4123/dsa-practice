package L3_feb2;

import java.util.Scanner;

public class pattern3 {
//	* * * * *
//	* *   * *
//	*       *
//	* *   * *
//	* * * * *
	public static void main(String[] args) {
				Scanner s=new Scanner(System.in);
				int n=s.nextInt();
				int nst=n/2;
				int nsp=0;
				int k=0;
				for(int row=1;row<=n;row++) {
					//stars1
					int cst=1;
					if(row==1 || row==n)
						cst=2;
					for(;cst<=nst;cst++) {
						System.out.print("*");
					}
					//space
					for(int csp=1;csp<=2*k-1;csp++) {
						System.out.print(" ");
					}
					//stars
					for(int cst1=1;cst1<=nst;cst1++) {
						System.out.print("*");
					}
					System.out.println();
					if(row<n/2) {
						nst--;
						k++;
					}
					else {
						nst++;
						k--;
					}
				}
	}
}