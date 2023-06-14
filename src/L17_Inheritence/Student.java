package L17_Inheritence;

public class Student {
	
	String name;
	int age;
	
	//@Override is an annotation which checks if the same name function exists in parent class or not
	//if the same name function is not present then error
//	@Override
//	public String ToString() {
//		return name+" is blah blah blah";
//	}
	
	@Override
	public String toString() {
		return name+" is blah blah blah";
	}


}
