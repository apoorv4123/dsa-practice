package L22_Hashmap;

public class Outer_class {
	
	public Outer_class() {
		System.out.println("Outer class");
	}

	// Nested static class
	static class class1 {

		public class1() {
			System.out.println("Nested static class");
		}

		public void fun1() {
			System.out.println("Inside fun1");
		}
	}

	// Inner Class
	public class class2 {
		
		public class2() {
			System.out.println("Inner class");
		}

		public void fun2() {
			System.out.println("Inside fun2");
		}
	}

}
