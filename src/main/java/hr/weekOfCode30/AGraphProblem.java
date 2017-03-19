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
package hr.weekOfCode30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class AGraphProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer n denoting (the number of
			// vertices in G).
			int n = in.nextInt();
			int[][] g = new int[n][n];
			for (int g_i = 0; g_i < n; g_i++) {
				// Each line i of the n subsequent lines contains
				// space-separated
				// binary integers where each integer j is a 1 if there is an
				// edge
				// between vertices i and j and a 0 if there is not.
				for (int g_j = 0; g_j < n; g_j++) {
					g[g_i][g_j] = in.nextInt();
				}
			}
			
			Integer[] result = getTraingle(g);
			System.out.println(result.length);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
		}
	}

	public static Integer[] getTraingle(int[][] graph) {
		Set<Integer[]> traingles = new HashSet<>();

		// to form a triangle one point must be connected to two other points.
		for (int row = 0; row < graph.length; row++) {
			
			Set<Integer> connectedPoint = new HashSet<>();
			

			for (int col = 0; col < graph.length; col++) {
				if (row != col && graph[row][col] == 1) {
					connectedPoint.add(col + 1);
					connectedPoint.add(row + 1);
				}
			}

			System.out.println(connectedPoint);
			traingles.add(connectedPoint.toArray(new Integer[0]));

		}

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		Integer[][] allTraingles = new Integer[graph.length][];
		Iterator<Integer[]> trainglesIterator = traingles.iterator();
		int i = 0;
		while (trainglesIterator.hasNext()) {
			allTraingles[i] = trainglesIterator.next();
			if (allTraingles[i].length > max && allTraingles[i].length > 2) {
				max = allTraingles[i].length;
				maxIndex = i;
			}
		}
		

		int actualLength = max - (max % 3);
		Integer[] result = new Integer[actualLength];
//		System.arraycopy(allTraingles[maxIndex], 0, result, actualLength -1, actualLength);
		System.out.println("Final Array :" + Arrays.toString(allTraingles[maxIndex]));
		for (i = 0; i < actualLength; i++) {
			result[i] = allTraingles[maxIndex][i];
		}
		return result;
	}
}
