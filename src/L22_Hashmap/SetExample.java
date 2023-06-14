package L22_Hashmap;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	
	public static void main(String[] args) {
		
		Set<Integer> s=new HashSet<>();
		
		// add : O(1)
		s.add(3);
		s.add(2);
		s.add(4);
		System.out.println(s);
		
		s.add(3);
		System.out.println(s);
		
		// remove : O(1)
		s.remove(2); // 2 is not the index but the value
		System.out.println(s);
		
		// contains : O(1)
		System.out.println(s.contains(1));
		System.out.println(s.contains(3));
		
		
	}

}