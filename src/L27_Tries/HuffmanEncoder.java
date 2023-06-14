package L27_Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import L28_Graph.HeapGeneric;

public class HuffmanEncoder {

	// we'll be using heap we built earlier and the in-built hash-map of java
	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	public HuffmanEncoder(String feeder) {

		// 1. Create frequency map of feeder
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char cc = feeder.charAt(i);
			int of = map.getOrDefault(cc, 0);
			map.put(cc, of + 1);
		}

		// 2. Create minHeap and insert all nodes inside minHeap
		// to avoid bound mismatch, make Node implements comparable
		HeapGeneric<Node> minHeap = new HeapGeneric<>();
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			Node node = new Node(entry.getKey(), entry.getValue());
			minHeap.add(node);
		}

		// 3. combine nodes until 1 node is left in minHeap
		while (minHeap.size() != 1) {
			Node one = minHeap.remove();
			Node two = minHeap.remove();

			Node combined = new Node(one, two);
			minHeap.add(combined);
		}

		// remove the last node of heap to parse 
		Node ft = minHeap.remove();// full tree
		// now, we have to parse through(traverse) ft

		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();

		// parse full tree(ft) and fill encoder, decoder
		this.initEncoderDecoder(ft, "");

		System.out.println(encoder);
		System.out.println(decoder);
	}

	public String encode(String source) {
		String rv = "";
		for (int i = 0; i < source.length(); i++) {
			String code = encoder.get(source.charAt(i));
			rv += code;
		}
		return rv;
	}

	public String decode(String codedString) {
		String rv = "";
		String key = "";
		for (int i = 0; i < codedString.length(); i++) {
			key += codedString.charAt(i);
			if (this.decoder.containsKey(key)) {
				rv += this.decoder.get(key);
				key = "";
			}
		}
		return rv;
	}

	// filling my encoder , decoder
	private void initEncoderDecoder(Node node, String osf) {
		if (node == null) {
			return;
		}
		if (node.right == null && node.left == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}
		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right, osf + "1");
	}

	private class Node implements Comparable<Node> {

		char data;
		int cost; // frequency
		Node left;
		Node right;

		Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		Node(Node one, Node two) {
			this.data = '\0';
			this.cost = one.cost + two.cost;
			this.left = two;
			this.right = one;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;// doubt,other-this
		}
	}

}