package L2_feb1;

public class pattern32 {

	public static void main(String[] args) {
		 int n=4;
		 int row=1;
		 int nst=1;
		 while(row<=2*n-1) {
			 int val=nst;
			//for numbers
			 int cst=1;
			while (cst <= 2 * nst - 1) {
				if (cst % 2 == 0)
					System.out.print("*");
				else {
					System.out.print(val);
				}
				cst = cst + 1;
			}
			 
			 System.out.println();
			 row=row+1;
			 if(row<=n) {
				 nst=nst+1;
			 }
			 else {
				 nst=nst-1;
			 }
		 }
	}
}
