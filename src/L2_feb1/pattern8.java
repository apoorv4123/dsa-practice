package L2_feb1;

public class pattern8 {

	public static void main(String[] args) {
		 int n=5;
		 int row=1;
		 while(row<=5) {
			 int col=1;
			 while(col<=5) {
				 
				 if(row==col || row+col==n+1) {
					 System.out.print("*");
				 }
				 else {
					 System.out.print(" ");
				 }
				 col++;
			 }
			 System.out.println();
			 row++;
		 }

	}

}
