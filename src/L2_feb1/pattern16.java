package L2_feb1;

public class pattern16 {

	public static void main(String[] args) {
		 int n=5;
		 int row=1;
		 int nsp=n-1;
		 int nst=n;
		 while(row<=2*n-1) {
			 int csp=1;
			 //for spaces
			 while(csp<=nsp) {
				 csp=csp+1;
				 System.out.print(" ");
			 }
			 //for stars
			 int cst=1;
			 while(cst<=nst) {
				 System.out.print("*");
				 cst=cst+1;
				 
			 }
			 System.out.println();
			 if(row<n) {
				 nsp=nsp-1;
				 nst=nst-1;
			 }
			 else {
				 nsp=nsp+1;
				 nst=nst+1;
			 }
		 row=row+1;
		 }
		 

	}

}
