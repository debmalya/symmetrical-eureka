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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		 * 
		 * @param startingNode
		 *            distances to other nodes from the starting node.
		 * @return distance array.
		 */
		public int[] shortestReach(int startingNode) {
			int[] distances = new int[numberOfNodes];

			// by default all distances are -1 means not connected.
			Arrays.fill(distances, -1);

			// Initialize queue.
			Queue<Integer> que = new LinkedList<>();
			que.add(startingNode);

			// distance to the same node is always 0.
			distances[startingNode] = 0;

			// keeping track of the nodes we have already visited.
			boolean[] seen = new boolean[numberOfNodes];
			seen[startingNode] = true;

			while (!que.isEmpty()) {
				int curr = que.poll();
				// Get the connected nodes from the adjacency list.
				for (int node : adjacencyList.get(curr)) {
					if (!seen[node]) {
						// if the node not visited
						seen[node] = true;
						que.offer(node);
						// for each level distance will be increased by 6.
						distances[node] = distances[curr] + 6; 
					}
				}

			}

			return distances;
		}

		/**
		 * @param startingNode
		 */
		public String getDistanceFromNode(int startingNode) {
			StringBuilder sb = new StringBuilder();
			
			int[] distanceFromNode = shortestReach(startingNode);
			
			for (int i = 0; i < distanceFromNode.length; i++) {
				if (distanceFromNode[i] != 0) {
					sb.append(distanceFromNode[i]);
					sb.append(" ");
				}
				
			}
			
			return sb.toString().trim();

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
