package L22_Hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		// Instantiate
		HashMap<String, Integer> map = new HashMap<>();

		// 1. put(adding)
		map.put("India", 3);
		map.put("Pakistan", 2);
		map.put("China", 5);
		map.put("USA", 5);

		// proper o/p will be printed bcoz in println, tostring() is called
		// which would be overridden in HashMap
		System.out.println(map);

		map.put("USA", 7); // updating

		System.out.println(map);// output order is not fixed

		// 2. get
		System.out.println(map.get("India")); // 3
		System.out.println(map.get("Paris")); // null, bcoz wrapper classes are used and default value of classes is
												// null

		// 3. containsKey
		System.out.println(map.containsKey("USA")); // true
		System.out.println(map.containsKey("Paris")); // false

		// 4. size
		System.out.println(map.size());

		// 5. getOrDefault : if the given key exists in map, then return its value else
		// return its default value(default value of its type)....one more parameter is
		// passed
		System.out.println(map.getOrDefault("Paris", 0)); // 0
		System.out.println(map.getOrDefault("India", 10)); // 3

		// 6. remove
		System.out.println(map.remove("India")); // return 3 and remove India=3 entry from map
		System.out.println(map.remove("Paris")); // null

		// 7. keySet : makes set of all the keys in our map
		Set<String> keys = map.keySet();
		System.out.println(keys); // [USA ,Pakistan, China]

		// 8. values()
		Collection<Integer> values = map.values();
		for (int value : values) {
			System.out.println(value);
		}

		// 9. entrySet()
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		
		System.out.println();

		map.put("India", 1);

		// Traversal in hashmap
		// 1. Enhanced for loop
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}

		System.out.println();

		// 2. using ArrayList
		ArrayList<String> list = new ArrayList<>(map.keySet());
		for (String key : list) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}