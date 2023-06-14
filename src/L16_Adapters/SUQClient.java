package L16_Adapters;

import java.util.ArrayList;

public class SUQClient {

	public static void main(String[] args) throws Exception {

//		SUQPushEfficient stack=new SUQPushEfficient();
		SUQPopEfficient stack = new SUQPopEfficient();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		stack.display();

		System.out.println(stack.pop());
		stack.display();

	}

}
