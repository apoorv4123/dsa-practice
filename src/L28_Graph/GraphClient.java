package L28_Graph;

public class GraphClient {

	public static void main(String[] args) throws Exception {

		Graph graph = new Graph();

//		graph.addVertex("A");
//		graph.addVertex("B");
//		graph.addVertex("C");
//		graph.addVertex("D");
//		graph.addVertex("E");
//		graph.addVertex("F");
//		graph.addVertex("G");
//		graph.addVertex("H");

//		graph.addEdge("A", "B", 2);
//		graph.addEdge("B", "C", 3);
//		graph.addEdge("C", "D", 1);
//		graph.addEdge("A", "D", 6);
//		graph.addEdge("D", "E", 8);
//		graph.addEdge("E", "F", 5);
//		graph.addEdge("E", "G", 7);
//		graph.addEdge("F", "G", 4);

		// BellmanFord
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdge("A", "B", 8);
		graph.addEdge("B", "E", 2);
		graph.addEdge("D", "E", 4);
		graph.addEdge("C", "D", -3);
		graph.addEdge("A", "C", 4);
		graph.addEdge("A", "D", 5);
		graph.addEdge("E", "B", -10);

//		graph.addEdge("F", "G", 9); // for prims

		graph.display();

//		System.out.println(graph.containsEdge("A", "C"));
//		System.out.println(graph.containsEdge("A", "I"));
//		System.out.println(graph.containsEdge("E", "G"));

//		System.out.println(graph.containsVertex("G"));
//		System.out.println(graph.containsVertex("K"));

//		graph.removeVertex("E");
//		graph.display();

//		graph.addVertex("E");
//		graph.display();

//		graph.addEdge("D", "E", 10);
//		graph.addEdge("F", "E", 9);
//		graph.addEdge("E", "G", 8);

//		graph.display();
//		System.out.println();
//		graph.removeEdge("D", "E");
//		System.out.println(graph.hasPath("A", "F", new HashMap<String, Boolean>()));

//		System.out.println(graph.bfs("A", "F"));

//		System.out.println(graph.dfs("A", "F"));

//		graph.bft();
//		System.out.println();
//		graph.dft();

//		graph.removeEdge("B", "C");
//		graph.removeEdge("F", "G");
//		System.out.println(graph.isCyclic());

//		graph.removeEdge("D", "E");
//		System.out.println(graph.isConnected());

//		graph.removeEdge("B", "C");
//		graph.removeEdge("F", "G");
//		System.out.println(graph.isTree());

//		System.out.println(graph.getCC());

//		graph.prims().display();

//		graph.addEdge("A", "B", 2);
//		graph.addEdge("B", "C", 3);
//		graph.addEdge("C", "D", 1);
//		graph.addEdge("A", "D", 10);
//		graph.addEdge("D", "E", 8);
//		graph.addEdge("E", "F", 5);
//		graph.addEdge("E", "G", 6);
//		graph.addEdge("F", "G", 4);
//		System.out.println(graph.Dijkstra("A"));

//		graph.kruskal();
		
		System.out.println(graph.BellmanFord("A"));

	}
}