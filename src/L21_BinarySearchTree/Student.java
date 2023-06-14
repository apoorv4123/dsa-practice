package L21_BinarySearchTree;

public class Student {

	String name;
	int rollno;
	static int noOfStudents;

	public Student(String name) {
		// name update
		this.name = name;

		// rollno update
		noOfStudents++;
		this.rollno = noOfStudents;
	}

	// can i use a static variable inside a non-static fxn ? YES
	// can i use a non-static variable inside a non-static fxn ? YES
	// can i call a static fxn from a non-static fxn ? YES
	// can i call a non-static fxn from a non-static fxn ? YES
	public void introduceYourself() {
		System.out.println("--------------");
		System.out.println(this.name + " has rollno as " + this.rollno);
		System.out.println("--------------");
	}

	// you cannot use this is static fxn
	// you cannot use a non-static/instance variable in static function
	// you cannot use super keyword in static fxn
	// can i use a static variable inside a static fxn ? YES
	// can i call a non-static function from inside static fxn ? NO
	// can i call a static function from inside static fxn ? YES
	public static void getNoOfStudents() {
		System.out.println(noOfStudents);
	}
}