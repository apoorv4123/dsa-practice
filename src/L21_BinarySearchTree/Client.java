package L21_BinarySearchTree;

public class Client {

	public static void main(String[] args) {

		Student s = new Student("A");
		Student s1 = new Student("B");
		// when an instance is created, the variables which are allocated space are
		// called instance variables, name and rollno
		// instance variables har nye instance k saath nye nye create hote
		// hain(non-static)
		// a variable shared by all the instances must be static

		System.out.println(s.name);
		System.out.println(s1.name);
		System.out.println(Student.noOfStudents);

		// non static fxn : context will be passed
		s.introduceYourself();

		// static fxn : context won't be passed
		Student.getNoOfStudents();

	}

}
