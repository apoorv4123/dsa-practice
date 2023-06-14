package L22_Hashmap;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapDemo2 {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>();

		// Put players into our HashMap where they can be found with an int
		map.put(23, "David Beckham");
		map.put(7, "Cristiano Ronaldo");
		map.put(10, "Lionel Mess");
		map.put(31, "Neymar");

		// Return a specific player
		System.out.println(map.get(23)); // "David Beckham"

		// Let's create a bunch of HashMaps
		// Creating vanilla HashMap
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();

		// Creating HashMap with a capacity ... in this case 100
		Integer capacity = 100;
		HashMap<String, Integer> map2 = new HashMap<String, Integer>(capacity);

		// Creating HashMap with capacity and load factor
		Integer capacity1 = 100;
		float loadFactor = (float) 0.5;
		HashMap<String, Integer> map3 = new HashMap<String, Integer>(capacity1, loadFactor);

		// print all values using a keySet
		for (Integer key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();
		// print all values using an entrySet
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// Add a football player to the playerMap if he is not in there
		// already ... remember David Beckham is 23
		// Try adding to an existing key
		String result = map.putIfAbsent(23, "Thomas Müller");
		System.out.println(result); // David Beckham
		// Try adding to a new key
		String result1 = map.putIfAbsent(5, "Thomas Müller");
		System.out.println(result1); // Null

		System.out.println(map.get(23));
		System.out.println(map.get(5));

		System.out.println("-------REMOVAL---------");
		// Remove a player from the HashMap
		System.out.println(map.remove(23));
		System.out.println(map.get(23)); // Null
		// Remove a player only if the key maps to a specific name
		// Remember 10 is mapped to Messi
		System.out.println(map.remove(10, "Thomas Müller"));
		System.out.println(map.get(10)); // "Lionel Messi"

		System.out.println("-------------------------");
		map.put(23, "David Beckham");
		System.out.println(map.get(23));
		System.out.println("-------REPLACE----------");
		// Replace a player
		map.replace(23, "Wayne Rooney");
		System.out.println(map.get(23)); // "Wayne Rooney"
		// Replace a player only if it is currently mapped to a specific
		// value ... won't replace because does not match
		map.replace(23, "Thomas Müller", "Wayne Rooney");
		System.out.println(map.get(23)); // "Wayne Rooney"

		System.out.println("-------CONTAINS---------");
		// Check if a key exists
		Boolean hasKey = map.containsKey(23);
		System.out.println(hasKey); // True
		// Check if a value exists
		Boolean hasValue = map.containsValue("Foo Bar");
		System.out.println(hasValue); // False
		hasValue = map.containsValue("Wayne Rooney");
		System.out.println(hasValue);

		// Start with getting the entrySet and remove/edit the
		// values you want
		for (Entry<Integer, String> entry : map.entrySet()) {
			// You can set this to anything ... this is just an example
			if (entry.getKey().equals("23")) {
				System.out.println(map.remove(entry.getKey()));
			}
		}
		System.out.println(map.get(23));

	}
}
