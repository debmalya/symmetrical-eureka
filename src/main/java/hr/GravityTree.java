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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// It's a tree where each vertex is numbered from 1 to n and vertex 1
// always
// denotes the root. Each edge has a length of 1, so a node has a
// distance of 1 from its parent, a distance of 2 from its grandparent,
// and
// so on.

// Some vertex, v , can be turned on, which results in all vertices
// (including ) of the subtree rooted at beginning to attract the tree's
// other vertices.

// The attractive forces exerted on some vertex, u, is equal to the
// summation of squared distances between vertex u and all vertices that
// are currently switched on.

// For example, if two nodes are switched on that have distances of 1
// and 2
// from node u, then the forces exerted on would be 1**2 + 2**2 = 1 + 4
// = 5.
/**
 * @author debmalyajash
 *
 */
public class GravityTree {

	private static LinkedHashMap<Integer, Integer> childMap = new LinkedHashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains a single integer,n , denoting the number
			// of vertices in the tree.
			int n = in.nextInt();
			int[] arr = new int[n];

			// The second line contains n - 1 space-separated integers where the
			// k th integer denotes the parent vertex of vertex k + 1.
			// First one is the parent vertex.
			for (int i = 0; i < n - 1; i++) {
				arr[i] = in.nextInt();
			}

			Map<Integer, List<Integer>> gravityMap = createTree(arr);
			// The next line contains an integer, q , denoting the number of
			// experiments she plans to perform.
			int q = in.nextInt();

			// Each of the q subsequent lines contains two space-separated
			// integers denoting the respective values of u and v for an
			// experiment.
			int[] u = new int[q];
			int[] v = new int[q];
			int[] r = new int[q];
			for (int i = 0; i < q; i++) {
				u[i] = in.nextInt();
				v[i] = in.nextInt();
				r[i] = getResult(gravityMap, u[i], v[i]);
			}

			for (int i = 0; i < q; i++) {
				System.out.println(r[i]);
			}

		}

	}

	/**
	 * @param gravityMap
	 *            - Map containing tree.
	 * @param u
	 * @param v
	 * @return
	 */
	public static int getResult(Map<Integer, List<Integer>> gravityMap, int u, int v) {
		// get all the children of u

		if (v == 1) {
			// It is from root every node will be considered.
			return calculateChildForce(gravityMap, u, v) + calculateParentForce(gravityMap, u, v);
		} else {
			Integer[] nodes = turnOn(gravityMap, v);
			int distance = 0;
			// First get the distance from u to v.
			boolean found = false;
			int value = v;
			while (!found) {
				Integer parent = childMap.get(value);
				if (parent == u) {
					found = true;
				}
				value = parent; 
				distance++;
			}

			// Add the force  between u and v.
			
			// Then add that distance with every element of nodes. Square that
			// distance add with distance.
			int f = (int) Math.pow(distance, 2);
			for (int i = 0; i < nodes.length; i++) {
				f += Math.pow(nodes[i] + distance, 2);
			}
			return f;
		}
	}

	/**
	 * If v is turned on, which nodes will be considered. Distance of those
	 * nodes from v.
	 * 
	 * @param gravityMap
	 *            - contains all child nodes and parents.
	 * @param v
	 *            - node to be turned on.
	 * @return - Nodes to be considered.
	 */
	private static Integer[] turnOn(Map<Integer, List<Integer>> gravityMap, int v) {
		List<Integer> urChildren = gravityMap.get(v);
		List<Integer> distances = new ArrayList<>();
		// Continue for grand children and so on.
		List<Integer> grandChildren = new ArrayList<>();
		for (int i = 0; i < urChildren.size(); i++) {
			distances.add(1);
			grandChildren.add(urChildren.get(i));
		}
		int distance = 2;
		while (!grandChildren.isEmpty()){
			List<Integer> nextLevel = new ArrayList<Integer>();
			for (int i = 0; i < grandChildren.size(); i++){
				List<Integer> children = gravityMap.get(grandChildren.get(i));
				if (children != null && !children.isEmpty()){
					distances.add(distance);
					nextLevel.addAll(children);
				}
				
				if (i == grandChildren.size() - 1){
					grandChildren.clear();
					grandChildren.addAll(nextLevel);
					distance++;
				}
			}
		}

		return distances.toArray(new Integer[0]);
	}

	/**
	 * @param gravityMap
	 * @param u
	 * @param v
	 * @return
	 */
	private static int calculateParentForce(Map<Integer, List<Integer>> gravityMap, int u, int v) {
		int distance = 0;
		while (true) {
			Integer value = childMap.get(u);
			if (value != null) {
				if (childMap.get(u) == v) {
					distance = 1;
					break;
				} else {
					distance++;
					u = value;
				}

			} else {
				// root node
				break;
			}
		}
		return (int) Math.pow(distance, 2);
	}

	/**
	 * @param gravityMap
	 * @param u
	 * @param f
	 * @return
	 */
	public static int calculateChildForce(Map<Integer, List<Integer>> gravityMap, int u, int v) {
		List<Integer> urChildren = gravityMap.get(u);
		List<Integer> children = new ArrayList<>();
		children.addAll(urChildren);

		// all are children at a distance of 1.
		int f = children.size();

		// Continue for grand children and so on.
		List<Integer> grandChildren = new ArrayList<>();

		int distance = 2;
		while (!children.isEmpty()) {
			for (int i = 0; i < children.size(); i++) {

				List<Integer> currentChild = gravityMap.get(children.get(i));
				if (currentChild != null && !currentChild.isEmpty()) {
					grandChildren.addAll(currentChild);
					f += Math.pow(distance, 2);
				}
				if (i == children.size() - 1) {
					children.clear();
					children.addAll(grandChildren);
					grandChildren.clear();
					distance++;
				}
			}
		}
		return f;
	}

	public static Map<Integer, List<Integer>> createTree(int[] arr) {
		LinkedHashMap<Integer, List<Integer>> gravityMap = new LinkedHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int currentNode = i + 2;
			List<Integer> childList = gravityMap.get(arr[i]);
			if (childList == null) {
				childList = new ArrayList<>();
			}
			childList.add(currentNode);
			gravityMap.put(arr[i], childList);
			childMap.put(currentNode, arr[i]);
		}
		return gravityMap;
	}

	public static LinkedHashMap<Integer, Integer> getChildMap() {
		return childMap;
	}

	public static void setChildMap(LinkedHashMap<Integer, Integer> childMap) {
		GravityTree.childMap = childMap;
	}

}
