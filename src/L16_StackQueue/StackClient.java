package L16_StackQueue;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack s = new Stack(4);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);

		// s.data=new int[5]; PAAP by this you'll lose your previous stack and to
		// restrict the user from doing so, the data
		// members shoul be made private

		s.display();
//		s.push(50);
		System.out.println(s.pop());
		s.display();
		System.out.println(s.peek());
		s.display();
	}

}
