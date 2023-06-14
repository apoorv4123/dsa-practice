package L27_Tries;

public class HuffmanClient {

	public static void main(String[] args) {

		String str = "abbccda";
		HuffmanEncoder hf = new HuffmanEncoder(str);

		String codedString = hf.encode(str);
		System.out.println(codedString);

		String os = hf.decode(codedString);
		System.out.println(os);

	}

}
