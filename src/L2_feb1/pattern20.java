package L2_feb1;

public class pattern20 {

	public static void main(String[] args) {
		 int n=7;
		 int row=1;
		 int nsp=2*n-3;
		 int nst=1;
		 while(row<=n) {
			 //for stars
			 int cst=1;
			 while(cst<=nst) {
				 System.out.print("*");
				 cst=cst+1;
				 }
			 //for spaces
			 int csp=1;
			 while(csp<=nsp) {
				 System.out.print(" ");
				 csp=csp+1;
			 }
			 //for stars
			 int cst2=1;
			 if(row==n) {
				 cst2=2;
			 }
			 while(cst2<=nst) {
				 System.out.print("*");
				 cst2=cst2+1;
				 }
			 System.out.println();
			 row=row+1;
			 nsp=nsp-2;
			 nst=nst+1;
		 }
	}
}
