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

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GravityTree {

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
			for (int i = 1; i < n; i++) {
				arr[i] = in.nextInt();
			}

			// The next line contains an integer, q , denoting the number of
			// experiments she plans to perform.
			int q = in.nextInt();

			// Each of the q subsequent lines contains two space-separated
			// integers denoting the respective values of u and v for an
			// experiment.
			int[] u = new int[q];
			int[] v = new int[q];
			for (int i = 0; i < q; i++) {
				u[i] = in.nextInt();
				v[i] = in.nextInt();
			}
		}

	}

	/**
	 * Create a Tree from the passed array of edge information.
	 * @param arr
	 * @return
	 */
	public MyTree createTree(int[] arr){
		MyTree m = new MyTree();
		return m;
	}
	/**
	 * 
	 * @param vertexTurnedOn - v.
	 * @param vertexObserving - u.
	 * @return the attractive force on vertex u.
	 */
	public int getTheForce(int vertexTurnedOn, int vertexObserving){
		return 0;
	}
	
	
	public static class MyTree {
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

		// For example, if two nodes are switched on that have distances of 1 and 2
		// from node u, then the forces exerted on would be 1**2 + 2**2 = 1 + 4 = 5.
	}
}
