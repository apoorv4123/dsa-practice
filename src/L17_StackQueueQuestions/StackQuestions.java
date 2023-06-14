package L17_StackQueueQuestions;

import L16_StackQueue.DynamicStack;

public class StackQuestions {

	public static void main(String[] args) throws Exception {
		DynamicStack stack = new DynamicStack();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		stack.display();// 50 40 30 20 10
		displayReverse(stack);// 10 20 30 40 50
		System.out.println();
		stack.display();// 50 40 30 20 10

		System.out.println();
		actualReverse(stack, new DynamicStack());
		stack.display();// 10 20 30 40 50
	}

	public static void displayReverse(DynamicStack s) throws Exception {

//		s. (only public functions will be visible), you cannot access data and tos

		if (s.isEmpty()) {
			return;
		}
		int temp = s.pop();
		displayReverse(s);
		System.out.print(temp + " ");
		s.push(temp);

	}

	public static void actualReverse(DynamicStack s, DynamicStack ts) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, ts);
			return;
		}
		ts.push(s.pop());
		actualReverse(s, ts);

	}

	public static void actualReverseHelper(DynamicStack s, DynamicStack ts) throws Exception {

		if (ts.isEmpty()) {
			return;
		}
		int temp = ts.pop();
		actualReverseHelper(s, ts);
		s.push(temp);

	}

}
