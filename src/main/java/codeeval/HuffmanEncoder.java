/**
 * 
 */
package codeeval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class HuffmanEncoder  {

	private static int R = 256; // ASCII alphabets.

	/*
	 * (non-Javadoc)
	 * 
	 * @see here.Encoder#constructTree(java.lang.String)
	 */
	public String constructTree(String input1) {
		if (input1 != null) {

			int[] freq = new int[R];

			for (int i = 0; i < input1.length(); i++) {
				freq[input1.charAt(i)]++;
			}

			List<Node> nodeList = new ArrayList<Node>();
			for (char c = 0; c < R; c++) {

				if (freq[c] > 0) {
					Node node = new Node(c, freq[c], null, null);
					node.order = input1.indexOf(c);
					nodeList.add(node);
				}
			}

			Collections.sort(nodeList);

			Node root = null;

			boolean single = false;
			if (nodeList.size() == 1) {
				// if there is only one character encoded value will be 1.
				single = true;

			} else {
				if (root == null) {

					Node left = nodeList.get(0);
					Node right = nodeList.get(1);

					root = new Node('\0', left.freq + right.freq, left, right);
				}

				for (int i = 2; i < nodeList.size(); i++) {
					if (i + 1 < nodeList.size()
							&& nodeList.get(i + 1).freq == nodeList.get(i).freq
							&& nodeList.get(i).ch < nodeList.get(i + 1).ch) {

						root = new Node('\0', nodeList.get(i + 1).freq
								+ root.freq, nodeList.get(i + 1), root);
						root = new Node('\0', nodeList.get(i).freq + root.freq,
								nodeList.get(i), root);
						i++;

					} else {
						root = new Node('\0', nodeList.get(i).freq + root.freq,
								nodeList.get(i), root);
					}
				}

			}

			// Build code table
			String[] st = new String[R];
			if (!single) {
				buildCode(st, root, "");
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < input1.length(); i++) {
				if (!single) {
					System.out.println(input1.charAt(i) + " "
							+ st[input1.charAt(i)]);
					sb.append(st[input1.charAt(i)]);
				} else {
					sb.append("1");
				}
			}
			return sb.toString();
		}

		return null;

	}

	/**
	 * @param st
	 * @param root
	 * @param string
	 */
	private void buildCode(String[] st, Node root, String string) {
		if (root.isLeaf()) {
			st[root.ch] = string;
			return;
		}

		buildCode(st, root.left, string + '0');
		buildCode(st, root.right, string + '1');

	}

	static class Node implements Comparable<Node> {
		char ch;
		int freq;
		int order;
		Node left;
		Node right;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param c
		 * @param i
		 * @param object
		 * @param object2
		 */
		public Node(char c, int i, Node left, Node right) {
			this.ch = c;
			this.freq = i;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Node o) {
			if (freq > o.freq) {
				return 1;
			} else if (freq < o.freq) {
				return -1;
			} else {
				return order - o.order;
			}

		}

		/**
		 * 
		 * @param root
		 *            Node
		 * @param ch
		 *            whose encoded value will be retrieved
		 * @return encoded value.
		 */
		public String getEncodedValue(char ch) {
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [ch=" + ch + ", freq=" + freq + "]";
		}

	}

}
