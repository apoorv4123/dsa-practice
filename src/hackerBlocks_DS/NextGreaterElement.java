package hackerBlocks_DS;

import java.util.Scanner;

class Stack {

	private int data[];
	private int tos;

	public Stack(int size) {
		data = new int[size];
		tos = -1;
	}

	public void push(int item) {

		tos++;
		data[tos] = item;

	}

	public int pop() {

		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;

	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == data.length;
	}

}

public class NextGreaterElement {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Stack stack;
		stack = new Stack(2);
		int t = s.nextInt();

		while (t > 0) {

			int sz = s.nextInt();

			t--;
		}

	}
}