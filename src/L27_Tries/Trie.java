package L27_Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Trie {

	private class Node {

		char data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(char data, boolean isTerminal) {
			this.data = data;
			this.children = new HashMap<>(); // to avoid null pointer exception
			this.isTerminal = isTerminal;
		}
	}

	private int numWords; // total number of words in records
	private Node root;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public int numWords() {
		return this.numWords;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal) {
				// word already exists
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if (child == null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		this.addWord(child, ros);

	}

	public void display() {
		this.display(this.root, "");
	}

	private void display(Node node, String osf) {// osf is output so far

		if (node.isTerminal) {
			String todisplay = osf.substring(1) + node.data;
			System.out.println(todisplay);
		}

		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();

		for (Map.Entry<Character, Node> entry : entries) {
			display(entry.getValue(), osf + node.data);
		}
	}

	public boolean search(String word) {
		System.out.println();
//		return search1(this.root, word, "");
		return search2(this.root, word);
	}

	private boolean search2(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true;
			}
			return false;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);

		if (child == null) {
			return false;
		}

		return search2(child, ros);
	}

	private boolean search1(Node node, String word, String wsf) {

		if (node.isTerminal) {
			String fw = wsf.substring(1) + node.data;
			if (word.equals(fw)) {
				return true;
			}
		}

		boolean result = false;

		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for (Map.Entry<Character, Node> entry : entries) {
			result = result || search1(entry.getValue(), word, wsf + node.data);
		}
		return result;
	}

	public void remove(String word) {
		remove(this.root, word);
	}

	private void remove(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.numWords--;
			} else {
				// our word is a part of another word
			}
			return;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if (child == null) {
			return;
		}
		remove(child, ros);

		if (!child.isTerminal && child.children.isEmpty()) {
			parent.children.remove(cc);
		}
	}
	
}