/**
 * Copyright 2015-2017 Debmalya Jash
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
package hr.openbracketdelware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class SpecialPathInStrangeTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// n denoting number of vertices in the given tree.
			int n = in.nextInt();
			int[] arr = new int[n - 1];

			// The second line contains n -1 space-separated integers, where the
			// i th integer p[i] denotes the edge between vertexes i + 1 and
			// p[i].
			for (int i = 0; i < n - 1; i++) {
				arr[i] = in.nextInt();
			}

			// The next line contains n space-separated integers, where ith
			// integer denotes the number that was written on the vertex i.
			int[] vertexWeigt = new int[n];
			for (int i = 0; i < n; i++) {
				vertexWeigt[i] = in.nextInt();
			}

			System.out.println(calculateNumberOfSpecialPath(arr, vertexWeigt));
		}

	}

	static class StrangePath {
		/**
		 * Each path will have unique weights.
		 */
		Set<Integer> weights;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "StrangePath [weights=" + weights + "]";
		}
		
		
	}

	/**
	 * A special path is a sequence of vertices v1,v2,v3,...,vm such that:
	 * 
	 * There is an edge between vi and v(i+1) for each i < m.
	 * 
	 * If we write down the integers written on every vertex , no integer will
	 * occur more than once.
	 * 
	 * @param arr
	 *            - edges
	 * @param vw
	 *            - vertex weights
	 * @return total number of special paths
	 * 
	 *         example arr - 1,2,3 vw - 1,2,1,2 edges 1->2, 2->3, 3->4
	 * 
	 */
	public static int calculateNumberOfSpecialPath(int[] arr, int[] vw) {
		int count = vw.length;

		// It will store all the strange paths.
		List<StrangePath> strangePathList = new ArrayList<>();
		
		// This map will maintain vertex wise strange path list.
		Map<Integer, List<Integer>> strangePathMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			// the edge between vertexes i + 1 and p[i] ( arr[i] )
			if (vw[i + 1] != vw[arr[i] - 1]) {
				List<Integer> existing = strangePathMap.get(arr[i] - 1);
				if (existing != null) {
					// Check whether can be added in any existing or not.
					for (int index : existing) {
						if (strangePathList.get(index - 1).weights.add(vw[arr[i] - 1]) || strangePathList.get(index - 1).weights.add(vw[i + 1])) {
							count += 2;
//							List<Integer> existingPathList = strangePathMap.get(arr[i] - 1);
//							if (existingPathList == null) {
//								existingPathList = new ArrayList<>();
//							}
//							existingPathList.add(index);
//							strangePathMap.put(arr[i] - 1, existingPathList);
						}
					}
				}

				List<Integer> existingPathList = strangePathMap.get(arr[i] - 1);
				if (existingPathList == null) {
					existingPathList = new ArrayList<>();
				}
				StrangePath newPath = new StrangePath();
				newPath.weights = new HashSet<>();
				newPath.weights.add(vw[arr[i] - 1]);
				newPath.weights.add(vw[i + 1]);
				strangePathList.add(newPath);
				existingPathList.add(strangePathList.size());

				strangePathMap.put(arr[i] - 1, existingPathList);
				
				
				
				 existingPathList = strangePathMap.get(arr[i]);
				if (existingPathList == null) {
					existingPathList = new ArrayList<>();
				}
				existingPathList.add(strangePathList.size());
				

				strangePathMap.put(arr[i], existingPathList);
//				System.out.println("strangePathMap " + strangePathMap);
//				System.out.println("strangePathList " + strangePathList);

				count += 2;
			}

		}

		return count;
	}
	
	public static int calculateNumberOfSpecialPath1(int[] arr, int[] vw) {
		int count = vw.length;

		// It will store all the strange paths.
		List<StrangePath> strangePathList = new ArrayList<>();
		
		// This map will maintain vertex wise strange path list.
		Map<Integer, List<Integer>> strangePathMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			// the edge between vertexes i + 1 and p[i] ( arr[i] )
			if (vw[i + 1] != vw[arr[i] - 1]) {
				List<Integer> existing = strangePathMap.get(arr[i] - 1);
				if (existing != null) {
					// Check whether can be added in any existing or not.
					for (int index : existing) {
						if (strangePathList.get(index).weights.add(vw[arr[i] - 1])) {
							count += 2;
							List<Integer> existingPathList = strangePathMap.get(arr[i] - 1);
							if (existingPathList == null) {
								existingPathList = new ArrayList<>();
							}
							existingPathList.add(index);
							strangePathMap.put(arr[i] - 1, existingPathList);
						}
					}
				}

				List<Integer> existingPathList = strangePathMap.get(arr[i] - 1);
				if (existingPathList == null) {
					existingPathList = new ArrayList<>();
				}
				StrangePath newPath = new StrangePath();
				newPath.weights = new HashSet<>();
				newPath.weights.add(vw[arr[i] - 1]);
				newPath.weights.add(vw[i + 1]);
				existingPathList.add(strangePathList.size());

				strangePathMap.put(arr[i] - 1, existingPathList);
				strangePathList.add(newPath);
				
				 existingPathList = strangePathMap.get(arr[i]);
				if (existingPathList == null) {
					existingPathList = new ArrayList<>();
				}
				newPath = new StrangePath();
				newPath.weights = new HashSet<>();
				newPath.weights.add(vw[arr[i] - 1]);
				newPath.weights.add(vw[i + 1]);
				existingPathList.add(strangePathList.size());
				strangePathList.add(newPath);

				strangePathMap.put(arr[i], existingPathList);

				count += 2;
			}

		}

		return count;
	}

	public static int calculateNumberOfSpecialPath0(int[] arr, int[] vw) {
		int count = vw.length;
		for (int i = 0; i < arr.length; i++) {
			// the edge between vertexes i + 1 and p[i] ( arr[i] )
			if (vw[i + 1] != vw[arr[i] - 1]) {
				count += 2;
			}
		}

		return count;
	}

}
