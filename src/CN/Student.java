package CN;

public class Student {

	// data members: adjectives
	String name;
//	int age;
	private final int age; // made private so that client cannot make it -ve
	private static int numStudents;
	public Student() { // default constructor
		age=10;
	}

	// if this constructor is used, the only name is being initialized and since age
	// is final and not initialized earlier while declaring it an not even here, it
	// gives an error
//	public Student(String n) {
//		name = n;
//	}

//	public Student(int a) {
//		age = a;
//	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		numStudents++;
	}

//	public void setAge(int a) {
//		if (a < 0) { // will return and efault value is set
//			return;
//		}
//		age = a;
//	}

	public void introduceYourself() {
		System.out.println("name is " + name + " age is " + age);
	}

	public static int getNoofStudents() { // static na bhi bnaya to bhi chalega
		return numStudents;
	}
}