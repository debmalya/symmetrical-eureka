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
package hr.cracking.coding.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class BFSShortestInGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// number of queries
			int numberOfQueries = in.nextInt();

			// Answers to the queries
			String[] answers = new String[numberOfQueries];

			for (int i = 0; i < numberOfQueries; i++) {
				int numberOfNodes = in.nextInt();
				int numberOfEdges = in.nextInt();

				Graph graph = new Graph(numberOfNodes, numberOfEdges);

				for (int j = 0; j < numberOfEdges; j++) {
					int firstNode = in.nextInt() - 1;
					int secondNode = in.nextInt() - 1;
					graph.connect(firstNode, secondNode);
				}

				int startingNode = in.nextInt() - 1;
				answers[i] = graph.getDistanceFromNode(startingNode);
			}

			for (int i = 0; i < numberOfQueries; i++) {
				System.out.println(answers[i]);
			}
		}

	}

	static class Graph {
		// Each node will have their adjacency list.
		private List<List<Integer>> adjacencyList = new ArrayList<>();
		private int numberOfNodes;

		public Graph(int numberOfNodes, int numberOfEdges) {
			this.numberOfNodes = numberOfNodes;
			for (int i = 0; i < numberOfNodes; i++) {
				adjacencyList.add(new ArrayList<>());
			}
		}

		/**
		 * @param startingNode
		 */
		public String getDistanceFromNode(int startingNode) {
			StringBuilder sb = new StringBuilder();
			List<Integer> nodeList = adjacencyList.get(startingNode);
			int[] distanceFromNode = new int[numberOfNodes];

			for (int i = 0; i < numberOfNodes; i++) {
				if (i != startingNode) {
					if (nodeList.contains(i)) {
						// Every edge has distance 6.
						distanceFromNode[i] = 6;
						sb.append("6");
					} else {
						// no direct connection.
						// does it have any indirect link?
						// Even if there is no indirect connection, then add -1
						if (adjacencyList.get(i).isEmpty()) {
							// i is not connected to any one, no need of checking.
							sb.append("-1");
						} else {
							int indirectDistance = getIndirectConnection(
									startingNode, i);

							if (indirectDistance == 0) {
								distanceFromNode[i] = -1;
								sb.append("-1");
							} else {
								distanceFromNode[i] = indirectDistance;
								sb.append(indirectDistance);
							}
						}
					}
					sb.append(" ");
				}
			}
			return sb.toString().trim();

		}

		/**
		 * @param startingNode
		 * @param i
		 * @return
		 */
		private int getIndirectConnection(int startingNode, int secondNode) {
			List l1 = adjacencyList.get(startingNode);
			List l2 = adjacencyList.get(secondNode);
			
			for (int i = 0; i < l1.size(); i++) {
				if (l2.contains(l1.get(i))) {
					return 12;
				}
			}
			
			
			
			return 0;
		}

		/**
		 * @param firstNode
		 * @param secondNode
		 */
		public void connect(int firstNode, int secondNode) {
			adjacencyList.get(firstNode).add(secondNode);
			adjacencyList.get(secondNode).add(firstNode);
		}
	}
}
