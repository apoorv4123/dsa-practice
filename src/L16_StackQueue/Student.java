package L16_StackQueue;

public class Student {

	// data members of student i.e. adjectives
	private String name; // private means sirf aur sirf stuent class he in data
	private int age; // members ko use kr skti hai koi aur class na he inhe upate
						// kar skti ahi aur na he access, then how do we do our work?
						// Answer: make use of getters an setters.

	public int getAge() {
		return age;
	}

	public void fun(int age) /*throws Exception*/ {

		System.out.println("hi fun");

//		try {
		setAge(age);
//		} catch (Exception e) {
//			System.out.println("in fun catch");
//		}

		System.out.println("bye fun");
	}

	public void setAge(int age) {

		System.out.println("hi setAge");

		try {
			if (age < 0) {
				throw new Exception("Invalid age");// generation of exception
			}
			this.age = age;
		} catch (Exception e) {
			System.out.println("in setAge Catch");
		}
		System.out.println("bye setAge");
	}
}
