/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hr;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class LevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node();
		root.data = 3;

		Node left = root.addLeft(5);
		Node right = root.addRight(2);
		left.addLeft(1);
		left.addRight(4);

		right.addLeft(6);

		root.LevelOrder(root);

	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node addLeft(int data) {
			left = new Node();
			left.data = data;
			return left;
		}

		Node addRight(int data) {
			right = new Node();
			right.data = data;
			return right;
		}

		void LevelOrder(Node root) {
			Stack<Node> level = new Stack<>();
			if (root != null) {
				System.out.println(root.data);
				if (root.right != null) {
					level.push(root.right);
				}
				if (root.left != null) {
					level.push(root.left);
				}
				printLevel(level);
			}
		}

		/**
		 * @param level
		 */
		private void printLevel(Stack<Node> level) {
			if (!level.isEmpty()) {
				Stack<Node> nextLevel = new Stack<>();

				while (!level.isEmpty()) {
					Node next = level.pop();
					System.out.println(next.data + " ");
					if (next.left != null) {
						nextLevel.push(next.left);
					}
					if (next.right != null) {
						nextLevel.push(next.right);
					}
				}

				Stack<Node> reverseNextLevel = new Stack<>();
				while (!nextLevel.isEmpty()) {
					reverseNextLevel.push(nextLevel.pop());
				}
				printLevel(reverseNextLevel);
			}
		}

		/**
		 * @param root
		 * @param sb
		 */
		private void createNestedLevel(Node root, StringBuilder sb) {
			if (root == null) {
				return;
			}
			if (sb.length() == 0) {
				sb.append(root.data);
			}
			if (root.left != null) {
				sb.append("->");
				sb.append(root.left.data);
			}
			if (root.right != null) {
				sb.append("->");
				sb.append(root.right.data);
			}
			createNestedLevel(root.left, sb);
			createNestedLevel(root.right, sb);

		}

		void LevelOrder1(Node root) {
			// List containing a list of integer.
			// Each inner list represents a level
			// levelList(0) will have 3
			// levelList(1) will have 5 ,2
			// levelList(2) will have 1, 4, 6
			List<List<Integer>> levelList = new ArrayList<>();
			createLevel(levelList, root);

		}

		/**
		 * @param levelList
		 * @param root
		 */
		private void createLevel(List<List<Integer>> levelList, Node root) {

		}

		void LevelOrder0(Node root) {
			Queue<Integer> levelQueue = new ArrayDeque<>();
			levelQueue.add(root.data);
			Node next = root;
			while (next != null) {
				if (next.left != null) {
					levelQueue.add(next.left.data);
				}
				if (next.right != null) {
					levelQueue.add(next.right.data);
				}
				next = next.left;
			}

			StringBuilder sb = new StringBuilder();
			while (!levelQueue.isEmpty()) {

				sb.append(levelQueue.poll());
				if (levelQueue.size() > 0) {
					sb.append("->");
				}

			}
			System.out.println(sb.toString());
		}
	}
}
