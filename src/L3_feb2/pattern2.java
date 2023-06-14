package L3_feb2;

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
				Scanner s=new Scanner(System.in);
				int n=s.nextInt();
				int nsp=n-1;
				for(int row=1;row<=n;row++) {
					for(int csp=1;csp<=nsp;csp++) {
						System.out.print(" ");
					}nsp--;
					for(int col=1;col<=n;col++) {
						if(col==1||col==n || row==1 || row==n)
						System.out.print("*");
						else
						System.out.print(" ");	
					}
					System.out.println();
				}
	}
}