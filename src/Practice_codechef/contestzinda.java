package Practice_codechef;

import java.util.Scanner;

public class contestzinda {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		int N=s.nextInt();
		int K=s.nextInt();
		int[] arr=new int[N];
		int[] narr=new int[arr.length];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
			sum=sum+arr[i];
		}
		if(sum>K) {
			System.out.println("-1");
		}
		else {
			
		}
		
	}
}
