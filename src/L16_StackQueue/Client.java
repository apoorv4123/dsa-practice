package L16_StackQueue;

public class Client {

	public static void main(String[] args) /*throws Expception*/ {

		// the right side will create a reference of student an will return
		// its address to the reference on the left side i.e. s
		System.out.println("hi");
//		try {
		Student s = new Student();
		// s.age=10; //class m member private krne k baad error
		// right now, the value of age is totally upto client, inly he ecies what age he
		// wants to set
		// client negative age bhi daal skta hai jo ki galat kaam hoga aur hume client
		// ko vo galat kaam
		// krne se rokna hai.
		// System.out.println(s.age);
		// private keyword is used to take away the access from the user

		s.fun(-10);
		System.out.println(s.getAge());
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("in Catch");
//		}
		System.out.println("bye");
	}
}
