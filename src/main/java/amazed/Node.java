package amazed;

public class Node {
	int data;
	Node left;
	Node right;

	/**
	 * You are given a pointer to the root of a binary search tree and a value
	 * to be inserted into the tree. Insert this value into its appropriate
	 * position in the binary search tree and return the root of the updated
	 * binary tree. You just have to complete the function.
	 * 
	 * @param root
	 *            of the tree.
	 * @param value
	 *            to be inserted.
	 * @return root of the updated binary tree.
	 */
	static Node Insert(Node root, int value) {
		Node mainRoot = root;
		if (root == null) {
			root = new Node();
			root.data = value;
			return root;
		}
		while (true) {
			if (value < root.data) {
				// go towards left
				if (root.left == null) {
					root.left = new Node();
					root.left.data = value;
					break;
				} else {
					root = root.left;
				}
			} else if (value > root.data) {
				// go towards right
				if (root.right == null) {
					root.right = new Node();
					root.right.data = value;
					break;
				} else {
					root = root.right;
				}
			}
		}
		return mainRoot;
	}
	
	public static void main(String[] args){
		Node node = new Node();
		node.data = 4;
		Node.Insert(node, 2);
		Node.Insert(node, 7);
		Node.Insert(node, 1);
		Node.Insert(node, 3);
		Node.Insert(node, 6);
	}
}
