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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class BFSShortestReachInGraph {

	/**
	 * Consider an undirected graph consisting of nodes where each node is
	 * labeled from 1 to n. and the edge between any two nodes is always of
	 * length 6.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Number of queries
			// Given q queries in the form of a graph and some starting node, s
			// ,
			// perform each query by calculating the shortest distance from
			// starting node s to all the other nodes in the graph.
			int q = in.nextInt();
			String[] answer = new String[q];

			for (int i = 0; i < q; i++) {
				// The first line contains two space-separated integers
				// describing the respective values of n (the number of nodes)
				// and
				// m (the number of edges) in the graph.
				int n = in.nextInt();
				int m = in.nextInt();

				Graph graph = new Graph(n);

				for (int j = 0; j < m; j++) {
					// Each line i of the subsequent lines contains two
					// space-separated integers, u and v, describing an edge
					// connecting node to node .
					int u = in.nextInt() - 1;
					int v = in.nextInt() - 1;
					graph.connect(u, v);

				}
				// The last line contains a single integer, s , denoting the
				// index of the starting node.
				int s = in.nextInt() - 1;

				answer[i] = describe(graph.getShortestDistance(s));
			}

			// Then print a single line of n -1 space-separated integers listing
			// node
			// s's shortest distance to each of the other nodes (ordered
			// sequentially by node number); if s is disconnected from a node,
			// print -1 as the distance to that node.
			for (int i = 0; i < q; i++) {
				System.out.println(answer[i]);
			}
		}

	}

	/**
	 * @param shortestDistance
	 * @return
	 */
	public static String describe(int[] shortestDistance) {
		StringBuilder about = new StringBuilder();

		for (int i = 0; i < shortestDistance.length; i++) {
			if (shortestDistance[i] != 0) {
				about.append(shortestDistance[i]);
				about.append(" ");
			}

		}
		return about.toString().trim();
	}

	static class Graph {
		List<Set<Integer>> adjacencyList = new ArrayList<>();
		int numberOfNodes;

		public Graph(int numberOfNodes) {
			this.numberOfNodes = numberOfNodes;
			for (int i = 0; i < numberOfNodes; i++) {
				adjacencyList.add(new HashSet<>());
			}
		}

		public void connect(int startNode, int otherNode) {
			if (startNode != otherNode) {
				adjacencyList.get(startNode).add(otherNode);
				adjacencyList.get(otherNode).add(startNode);
			}
		}

		public int[] getShortestDistance(int startNode) {
			int[] distances = new int[numberOfNodes];

			Arrays.fill(distances, -1);
			distances[startNode] = 0;

			boolean[] visited = new boolean[numberOfNodes];

			Queue<Integer> visitedNodes = new LinkedList<>();
			visitedNodes.add(startNode);
			visited[startNode] = true;

			
			while (!visitedNodes.isEmpty()) {
				int node = visitedNodes.poll();

				Integer[] nodes = adjacencyList.get(node).toArray(new Integer[0]);
				
				visited[node] = true;
				for (int i = 0; i < nodes.length; i++) {
					if (!visited[nodes[i]]) {
						visitedNodes.add(nodes[i]);

						if (nodes[i] != startNode) {
							distances[nodes[i]] = distances[node] + 6;
							visited[nodes[i]] = true;
						}
					}

				}
			}

			return distances;

		}
	}

}
