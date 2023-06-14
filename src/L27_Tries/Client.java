package L27_Tries;

public class Client {

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("amit");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("seen");
		trie.addWord("commit");
		trie.display();
		System.out.println(trie.search("boy"));

		System.out.println();

		trie.remove("art");
		trie.display();
		trie.remove("arts");
		System.out.println();
		trie.display();

	}

}