package L2_feb1;

import java.util.Scanner;

public class pattern4 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		 int n=s.nextInt();
		 int row=1;
		 int nsp=n-1;
		 int nst=1;
		 while(row<=n) {
			 int csp=1;
			 //for spaces
			 while(csp<=nsp) {
				 csp=csp+1;
				 System.out.print(" ");
			 }
			 //for stars
			 int cst=1;
			 while(cst<=nst) {
				 cst=cst+1;
				 System.out.print("*");
			 }
			 System.out.println();
			 row=row+1;
			 nsp=nsp-1;
			 nst=nst+1;
		 }
	}
}
