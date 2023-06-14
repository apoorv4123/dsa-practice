package L28_Graph;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		this.vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		if (vtx == null) {
			return;
		}

		// neighbors of vname
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {
			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);
	}

	public int numEdges() {

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		int count = 0;
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			count += vtx.nbrs.size();
			// or simply, count += vtces.get(key).nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
//		vtx2.nbrs.put(vname1, cost); // this has to be commented for Bellman Ford algorithm
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {

		ArrayList<String> keys = new ArrayList<String>(this.vtces.keySet());

		System.out.println("--------------------------");
		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		System.out.println("--------------------------");

	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vtces.get(src);

		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}
		return false;
	}

	private class Pair {

		String vname;
		String psf; // path so far

		Pair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

	}

	// breadth first search
	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// put the starting pair in queue
		queue.addLast(new Pair(src, src));

		// while queue is not empty keep on doing the work
		while (!queue.isEmpty()) {
// total no. of vertices times : from line 163-184
			// remove a pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// put in processed
			processed.put(rp.vname, true);

			// check for direct edge
			if (this.containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs addition of removed vertex at end
			Vertex rpvtx = vtces.get(rp.vname);

			ArrayList<String> rpnbrs = new ArrayList<>(rpvtx.nbrs.keySet());
//

// total 2*no. of edges times : from line 186-192
			// loop on nbrs of rp
			for (String nbr : rpnbrs) {
				// process only unprocessed nbrs
				if (!processed.containsKey(nbr))
					queue.addLast(new Pair(nbr, rp.psf + nbr));
			}
//
		}
		return false;
	}

	// depth first search
	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// put the starting pair in stack
		stack.addFirst(new Pair(src, src));

		// while queue is not empty keep on doing the work
		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// put in processed
			processed.put(rp.vname, true);

			// check for direct edge
			if (this.containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex vtx = vtces.get(rp.vname);

			ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

			// loop on nbrs of rp
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					stack.addFirst(new Pair(nbr, rp.psf + nbr));
				}

			}

		}
		return false;
	}

	// breadth first traversal
	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			queue.addLast(new Pair(key, key));

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex vtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<String>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {

					if (!processed.containsKey(nbr)) {
						queue.addLast(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
		}
	}

	// depth first traversal
	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			stack.addFirst(new Pair(key, key));

			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex vtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<String>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {

					if (!processed.containsKey(nbr)) {
						stack.addFirst(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
		}
	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			queue.addLast(new Pair(key, key));

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from the queue
				Pair rp = queue.removeFirst();

				// this means that we reached the same node with another path, i.e. cycle is
				// present in graph
				if (processed.containsKey(rp.vname)) {
					return true;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						queue.addLast(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
		}
		return false;
	}

	public boolean isConnected() {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++; // if we come in this region more than once, then the graph is not connected

			queue.addLast(new Pair(key, key));

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						queue.addLast(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
		}
		if (flag >= 2) {
			return false;
		}
		return true;
	}

	// tree is acyclic an connected graph
	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	// get connected components
	public ArrayList<ArrayList<String>> getCC() {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			queue.addLast(new Pair(key, key));

			ArrayList<String> component = new ArrayList<String>();

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				component.add(rp.vname);

				processed.put(rp.vname, true);

				Vertex vtx = vtces.get(rp.vname);

				ArrayList<String> nbrs = new ArrayList<String>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {

					if (!processed.containsKey(nbr)) {
						queue.addLast(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
			ans.add(component);

		}

		return ans;
	}

	// PRIMS
	// till heap is not empty keep on doing some work
	// a) remove a pair from both heap and hashMap
	// b) add removed pair to mst: 2 cases
	// 1. if the acqvname of removed pair is null then add only removed pair
	// vname(vertex) to mst Like A
	// 2. else add removed pair's vnmae(vertex) to mst and also add an edge b/w
	// rp.vname and rp.acqvname with cst of rp.cost
	// c) do work for neighbors of removed pair i.e update the info of nbrs of rp
	// eg. For node B, for(String nbr:vtces.get(B).nbrs.keySet()) -> A,C and B is
	// stored at rp.vname
	// we are going to work for only those neighbors which are present in heap and
	// we will check this using our hashMap as we've been deleting the nodes form
	// both heap an hashMap together, So hashmap contains only those vertices which
	// are present in heap
	// updation of nbrs will be one only when old cost of nbr>new cost, so we'll
	// have to compare old cost and new cost
	// old cost will be obtained from thr pair present in heap(map.get(nbr).cost)
	// new cost vtces.get(rp.vname).nbrs.get(nbr)
	// after updating neighbors, we need to upheapify to maintain minHeap
	// but upheapify requires the index
	// we can either get the index by traversing the heap and searching for updated
	// pair vertex
	// but this will take O(n)
	// better approach to get the index of updated element:
	// we'll maintain another hashmap which stores the vname -> index

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqvname;
		int cost; // weight of cost b/w vname & acqvname, initially infinity for all

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	public Graph prims() {

		Graph mst = new Graph();
		HeapGeneric<PrimsPair> heap = new HeapGeneric<Graph.PrimsPair>();
		HashMap<String, PrimsPair> map = new HashMap<>();

		// make PrimsPair for each vertex and put in heap and map
		for (String key : vtces.keySet()) {

			PrimsPair np = new PrimsPair();// make new pair for each vertex
			np.vname = key;
			np.acqvname = null;
			np.cost = Integer.MAX_VALUE;

			heap.add(np);
			map.put(key, np);
		}

		// till heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {

			// remove a pair
			PrimsPair rp = heap.remove(); // total v*log(v) times
			map.remove(rp.vname);

			// add rp to mst
			if (rp.acqvname == null) {
				mst.addVertex(rp.vname); // like A
			} else {
				mst.addVertex(rp.vname); // like B or others
				mst.addEdge(rp.vname, rp.acqvname, rp.cost);
			}

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) { // total 2E times

				if (map.containsKey(nbr)) {// to work for only those nbrs presest in heap

					// get oldcost & newcost
					int oldcost = map.get(nbr).cost;
					int newcost = vtces.get(rp.vname).nbrs.get(nbr);

					// update the pair only when condition is met
					if (newcost < oldcost) {

						PrimsPair nbrp = map.get(nbr);

						nbrp.acqvname = rp.vname;
						nbrp.cost = newcost;

						heap.updatePriority(nbrp); // complexity of upheapify() is log(v) where v is no. of items in
													// heap
					}

				}

			}

		}

		return mst;
	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		String vname;
		String psf;// path so far from source to current vertex
		int cost;// cost from source to vname

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}
	}

	public HashMap<String, Integer> Dijkstra(String source) {

		// hashMap to store final result
		HashMap<String, Integer> ans = new HashMap<String, Integer>();
		HashMap<String, DijkstraPair> map = new HashMap<String, Graph.DijkstraPair>();

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<Graph.DijkstraPair>();

		// make a pair for each vertex and store in heap
		for (String key : vtces.keySet()) {

			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (key.equals(source)) {
				np.cost = 0;
				np.psf = source;
			}

			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!map.isEmpty()) {

			// remove a pair
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);

			// add to ans
			ans.put(rp.vname, rp.cost);

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				// work for nbrs which are present in heap
				if (map.containsKey(nbr)) {

					// get oldcost & newcost
					int oldcost = map.get(nbr).cost;
					int newcost = rp.cost + vtces.get(rp.vname).nbrs.get(nbr); // jo pair remove hua hai uss tak ki
																				// cost+edge ki cost

					// update the pair
					if (newcost < oldcost) {

						DijkstraPair nbrp = map.get(nbr);
						nbrp.psf = rp.psf + nbr;
						nbrp.cost = newcost;

						heap.updatePriority(nbrp);
					}
				}
			}
		}
		return ans;
	}

	public class DisjointSet {

		HashMap<String, Node> map = new HashMap<>();

		private class Node {
			String data;
			Node parent;
			int rank;
		}

		public void create(String value) {

			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			map.put(value, nn);

		}

		public String find(String value) {
			return find(map.get(value)).data;
		}

		private Node find(Node node) {

			if (node == node.parent) {
				return node;
			}

			Node rr = find(node.parent);
			node.parent = rr; // path compression
			return rr;

		}

		public void union(String value1, String value2) {

			Node n1 = map.get(value1);
			Node n2 = map.get(value2);

			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1.data.equals(re2.data)) {
				return;
			} else {
				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank = re1.rank + 1;
				} else if (re1.rank > re2.rank) {
					re2.parent = re1;
				} else {
					re1.parent = re2;
				}
			}
		}
	}

	public class EdgePair implements Comparable<EdgePair> {
		String v1;
		String v2;

		int cost;

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		public String toString() {
			return this.v1 + "-" + this.v2 + " : " + this.cost;
		}

	}

	public ArrayList<EdgePair> getAllEdges() { // 2*E time

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (String vertex : vtces.keySet()) {
			Vertex vtx = vtces.get(vertex);
			for (String nbr : vtx.nbrs.keySet()) {
				EdgePair np = new EdgePair();
				np.v1 = vertex;
				np.v2 = nbr;
				np.cost = vtx.nbrs.get(nbr);
				edges.add(np);
			}
		}
		return edges;
	}

	public void kruskal() {

		// sort the edges in increasing order of cost(weight)
		ArrayList<EdgePair> edges = getAllEdges(); // 2E
		Collections.sort(edges); // Elog(E)
//		System.out.println(edges);

		DisjointSet set = new DisjointSet();

		for (String vname : vtces.keySet()) { // V
			set.create(vname);
		}
	}

	// for this you need to make changes in addEdge()
	public HashMap<String, Integer> BellmanFord(String src) throws Exception {

		ArrayList<EdgePair> edges = getAllEdges();

		HashMap<String, Integer> map = new HashMap<>();

		// fill hashmap with infinity and zero
		for (String vname : vtces.keySet()) {
			map.put(vname, 100000);

			if (src.equals(vname)) {
				map.put(vname, 0);
			}
		}

		int V = map.size();
		// relax every edge v-1 times
		for (int i = 1; i <= V; i++) {

			// loop on edges
			for (EdgePair edge : edges) {

				int oc = map.get(edge.v2);
				int nc = map.get(edge.v1) + edge.cost;

				if (nc < oc) {

					if (i <= V - 1)
						map.put(edge.v2, nc);
					else
						throw new Exception(" -ve edge cycle present ");

				}
			}
		}
		return map;
	}

}