package L5_feb15;

import java.util.Scanner;

public class ThirdMax {
//to find third max in an array and the condition
//being that you have to traverse just once
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		int[] arr=takeInput();
		System.out.println(thirdmax(arr));
	}
	public static int[] takeInput() {
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	public static int thirdmax(int[] arr) {
		int max=Integer.MIN_VALUE;
		int smax=Integer.MIN_VALUE;
		int tmax=Integer.MIN_VALUE;
		for(int i=0;i<=arr.length-1;i++) {
			if(arr[i]>max) {
				tmax=smax;
				smax=max;
				max=arr[i];
			}
			else if(arr[i]<max && arr[i]>smax) {
				tmax=smax;
				smax=arr[i];
			}
			else if(arr[i]<smax && arr[i]>tmax) {
				tmax=arr[i];
			}
		}
		return tmax; 
	}
}
