package hr;

/**
 * Huffman coding assigns variable length codewords to fixed length input
 * characters based on their frequencies. More frequent characters are assigned
 * shorter codewords and less frequent characters are assigned longer codewords.
 * A Huffman tree is made for the input string and characters are decoded based
 * on their position in the tree. We add a '0' to the codeword when we move left
 * in the binary tree and a '1' when we move right in the binary tree. We assign
 * codes to the leaf nodes which represent the input characters.
 * 
 * @author debmalyajash
 *
 */
public class HuffmanDecoding {

	private static final char INTERNAL = 'ϕ';

	public static void main(String[] args) {
		Node root = new Node();

		root.data = INTERNAL;
		root.right = new Node();
		root.right.data = 'A';

		root.left = new Node();
		root.left.data = INTERNAL;

		root.left.left = new Node();
		root.left.left.data = 'B';

		root.left.right = new Node();
		root.left.right.data = 'C';

		decode("1001011", root);

	}

	static class Node {
		public int frequency;
		public char data;
		public Node left, right;

	}

	/**
	 * 
	 * @param S
	 *            string to be decoded.
	 * @param root
	 *            of the binary tree.
	 * 
	 * 
	 * 
	 *            Sample input {ϕ,5} 0 / \ 1 {ϕ,2} {A,3} 0/ \1 {B,1} {C,1}
	 * 
	 *            S="1001011" Sample Output - ABACA Explanation S="1001011"
	 *            Processing the string from left to right. S[0]='1' : we move
	 *            to the right child of the root. We encounter a leaf node with
	 *            value 'A'. We add 'A' to the decoded string. We move back to
	 *            the root.
	 * 
	 *            S[1]='0' : we move to the left child. S[2]='0' : we move to
	 *            the left child. We encounter a leaf node with value 'B'. We
	 *            add 'B' to the decoded string. We move back to the root.
	 * 
	 *            S[3] = '1' : we move to the right child of the root. We
	 *            encounter a leaf node with value 'A'. We add 'A' to the
	 *            decoded string. We move back to the root.
	 * 
	 *            S[4]='0' : we move to the left child. S[5]='1' : we move to
	 *            the right child. We encounter a leaf node with value C'. We
	 *            add 'C' to the decoded string. We move back to the root.
	 * 
	 *            S[6] = '1' : we move to the right child of the root. We
	 *            encounter a leaf node with value 'A'. We add 'A' to the
	 *            decoded string. We move back to the root.
	 * 
	 *            Decoded String = "ABACA"
	 * 
	 *            // TODO encode hello! decoded value ? // TODO encode
	 *            HackerRank // TODO encode ThisIsHuffmanEncoding
	 */
	public static void decode(String S, Node root) {
		StringBuilder sb = new StringBuilder();
		Node mainRoot = root;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);

			if (c == '1') {
				// System.out.println("processing :" + c + " right ");
				root = root.right;
			} else {
				// System.out.println("processing :" + c + " left ");
				root = root.left;
			}

			if (root.left == null || root.right == null) {
				// leaf node, then print the data and return back to the main root.
				sb.append(root.data);
				root = mainRoot;
			}

		}

		System.out.println(sb.toString());
	}

	public static void decode0(String S, Node root) {
		StringBuilder sb = new StringBuilder();
		Node mainRoot = root;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			System.out.println("processing :" + c);
			if (c == '1') {
				System.out.println("Right : ");
				if (root.right != null) {
					root = root.right;
				}
				sb.append(root.data);
				root = mainRoot;
			} else {
				System.out.println("Left :");
				if (root.left != null) {
					root = root.left;
				} else {
					System.out.println("Reached leaf :" + root.data);
				}

			}
			System.out.println(sb.toString());
			System.out.println("---------");
		}

		System.out.println(sb.toString());

	}
}
