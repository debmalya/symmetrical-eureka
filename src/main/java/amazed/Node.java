package amazed;

import java.util.Stack;

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
	static Node Insert( Node root, int value ) {
		Node mainRoot = root;
		if( root == null ) {
			root = new Node();
			root.data = value;
			return root;
		}
		while( true ) {
			if( value < root.data ) {
				// go towards left
				if( root.left == null ) {
					root.left = new Node();
					root.left.data = value;
					break;
				}else {
					root = root.left;
				}
			}else if( value > root.data ) {
				// go towards right
				if( root.right == null ) {
					root.right = new Node();
					root.right.data = value;
					break;
				}else {
					root = root.right;
				}
			}
		}
		return mainRoot;
	}

	/**
	 * You are given pointer to the root of the binary search tree and two
	 * values v1 and v2. You need to return the lowest common ancestor (LCA) of
	 * v1 and v2 in the binary search tree.
	 * 
	 * @param root
	 * @param v1
	 * @param v2
	 * @return
	 */
	static Node lca( Node root, int v1, int v2 ) {
		if( root != null ) {
			if( ( root.data < v1 && root.data > v2 ) || ( root.data <= v1 && root.data > v2 )
					|| ( root.data < v1 && root.data >= v2 ) || ( root.data > v1 && root.data < v2 )
					|| ( root.data >= v1 && root.data < v2 ) || ( root.data > v1 && root.data <= v2 )
					|| ( root.data == v1 && root.data == v2 ) ) {
				return root;
			}else if( v1 < root.data && v2 < root.data ) {
				return lca( root.left, v1, v2 );
			}else if( v1 > root.data && v2 > root.data ) {
				return lca( root.right, v1, v2 );
			}
		}
		return null;
	}

	static Node lca0( Node root, int v1, int v2 ) {
		Stack< Node > depthFirstSearch = new Stack<>();
		depthFirstSearch.add( root );
		if( root.data != v1 ) {
			findParent( depthFirstSearch, v1, root.left );
		}
		return null;
	}

	/**
	 * @param depthFirstSearch
	 * @param v1
	 * @param left2
	 */
	private static Stack< Node > findParent( Stack< Node > depthFirstSearch, int v1, Node left2 ) {
		if( left2.data == v1 ) {
			return depthFirstSearch;
		}
		return null;

	}

	public static void main( String[ ] args ) {
		Node node = new Node();
		node.data = 4;
		Node.Insert( node, 2 );
		Node.Insert( node, 7 );
		Node.Insert( node, 1 );
		Node.Insert( node, 3 );
		Node.Insert( node, 6 );
		Node answer = Node.lca( node, 1, 7 );

	}
}
