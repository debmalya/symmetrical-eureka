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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
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
				System.out.print(result[i] + " ");
			}
		}
	}

	/**
	 * @param graph
	 * @return
	 */
	public static Integer[] getTraingle(int[][] graph) {
		GraphSolution[] solutions = new GraphSolution[graph.length];
		LinkedHashMap<Integer, Integer> pointMap = new LinkedHashMap<>();
		for (int i = 0; i < graph.length; i++) {
			solutions[i] = new GraphSolution();
			solutions[i].points.add(i + 1);

			Integer count = pointMap.get(i + 1);
			if (count == null) {
				count = 0;
			}
			count++;
			pointMap.put(i + 1, count);

			for (int j = 0; j < graph.length; j++) {
				if (i != j && graph[i][j] == 1) {
					solutions[i].points.add(j + 1);
					count = pointMap.get(j + 1);
					if (count == null) {
						count = 0;
					}
					count++;
					pointMap.put(j + 1, count);
				}
			}
		}

		Set<Integer> finalSolution = new HashSet<>();
		Set<Entry<Integer, Integer>> pointSet = pointMap.entrySet();
		Iterator<Entry<Integer, Integer>> pointIterator = pointSet.iterator();
		List<GraphSolution> proposedSolution = new ArrayList<>();
		while (pointIterator.hasNext()) {
			Entry<Integer, Integer> nextEntry = pointIterator.next();
			if (nextEntry.getValue() > 2) {
				finalSolution.add(nextEntry.getKey());
				if (finalSolution.size() > 3) {
					GraphSolution  solution = new GraphSolution();
					solution.points.addAll(finalSolution);
					solution.numberOfTraingles = finalSolution.size() - 3 + 1;
					solution.ratio = solution.points.size() / solution.numberOfTraingles;
					proposedSolution.add(solution);
				}
			}
		}
		
		if (proposedSolution.size() > 0) {
			Collections.sort(proposedSolution);
			finalSolution = new HashSet<>();
			finalSolution.addAll(proposedSolution.get(0).points);
		}
		return finalSolution.toArray(new Integer[0]);
	}

	static class GraphSolution implements Comparable<GraphSolution> {
		int numberOfTraingles;

		Set<Integer> points = new HashSet<Integer>();
		double ratio;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(GraphSolution o) {
			if (o.ratio > ratio) {
				return 1;
			} else if (o.ratio < ratio) {
				return -1;
			}
			return 0;
		}

		public int getNumberOfTraingles() {
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Solution [numberOfTraingles=" + numberOfTraingles + ", points=" + points + ", ratio=" + ratio + "]";
		}

	}
}