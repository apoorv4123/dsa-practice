package L22_Hashmap.Generics;

public class Client {

	public static void main(String[] args) throws Exception {

		HashTable<String, Integer> map = new HashTable<String, Integer>(5);
		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);

		map.display();
		
		map.put("Sweden", 400);
		map.display();
		
		map.put("India", 325);
		map.display();
		
		System.out.println("==========get==========");
		System.out.println(map.get("India"));
		System.out.println(map.get("SA"));
		
		System.out.println("==========remove==========");
		System.out.println(map.remove("China"));
		map.display();
	}

}
