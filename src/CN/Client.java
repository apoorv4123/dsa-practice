//package CN;
//
//public class Client {
//
//	public static void main(String[] args) {
//// Before the execution of main, the blueprint of Student class comes in heap memory
////The blueprint will contain the the data members an the functions of student
//		Student s = new Student();
//		// dekha gaya ki student k kya data members hai, unko heap m space allocate kr
//		// dia gya as new keyword is being used
//		// members ko initialize kia gya aur uska address left side i.e. s ko de dia gya
//
//		System.out.println(s);// address of instance in heap
//
//		System.out.println(s.name);// null
//		System.out.println(s.age);// 0
//
//		s.name = "Apoorv";
//		s.age = 20;
//
//		System.out.println(s.name);// Apoorv
//		System.out.println(s.age);// 20
//
//		Student s1 = s;// only reference is being created
//		s1.name = "Bhoo";
//		System.out.println(s.name);
//
//		Student s2 = new Student();
//		s2.age = 10;
//		s2.name = "A";
//
//		Student s3 = new Student();
//		s3.age = 20;
//		s3.name = "B";
//
//		s3.introduceYourself();
//
//		test1(s2, s3);
//		System.out.println(s2.age + " " + s2.name);
//		System.out.println(s3.age + " " + s3.name);
//
////		 test2a(s2, s3);
////		System.out.println(s2.age + " " + s2.name);
////		System.out.println(s3.age + " " + s3.name);
//
//		test2b(s2, s3);
//		System.out.println(s2.age + " " + s2.name);
//		System.out.println(s3.age + " " + s3.name);
//
//	}
//
//	public static void test1(Student s1, Student s2) {
//		Student temp = s1;
//		s1 = s2;
//		s2 = temp;
//	}
//
//	public static void test2a(Student s1, Student s2) {
//
//		int tempa = s1.age;
//		s1.age = s2.age;
//		s2.age = tempa;
//
//		String tempb = s1.name;
//		s1.name = s2.name;
//		s2.name = tempb;
//
//	}
//
//	public static void test2b(Student s1, Student s2) {
//
//		int tempa = s1.age;
//		s1.age = s2.age;
//		s2.age = tempa;
//
//		s1 = new Student();
//		String tempb = s1.name;
//		s1.name = s2.name;
//		s2.name = tempb;
//
//	}
//
//}