package L15_OOPS;

public class Student {

	// data members: adjectives
	String name;
	int age;
//	private int age; // made private so that client cannot make it -ve

	public Student() { // default constructor

	}

	public Student(String n) {
		name = n;
	}

	public Student(int a) {
		age = a;
	}

	public Student(String n, int a) {
		name = n;
		age = a;
	}

	public void setAge(int a) {
		if (a < 0) { // will return and efault value is set
			return;
		}
		age = a;
	}

	public void introduceYourself() {
		System.out.println("name is " + name + " age is " + age);
	}

}