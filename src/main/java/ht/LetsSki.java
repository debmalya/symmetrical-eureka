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
package ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class LetsSki {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int x = in.nextInt();
			int y = in.nextInt();

			int[][] court = new int[x][y];

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					court[i][j] = in.nextInt();
				}
			}

			int[] result = bestSkiWay(court);
			System.out.println(result[0]);
			System.out.println(result[1]);
		}

	}

	/**
	 * 
	 * @param skiCourt
	 * @param i
	 * @param j
	 * @return
	 */
	public static Solution getSolutionFrom(int[][] skiCourt,int i, int j) {
		Solution finalSolution = new Solution();
		return finalSolution;
	}
	/**
	 * Get the best sky path.
	 * 
	 * @param skiCourt
	 * @return length of the sky path, depth of sky path.
	 */
	public static int[] bestSkiWay(int[][] skiCourt) {
		int[] result = new int[2];
		int[] dx = new int[] { 0, -1, 0, 1 };
		int[] dy = new int[] { -1, 0, 1, 0 };

		String[][] occupy = new String[skiCourt.length][skiCourt.length];

		Map<Position, List<Position>> positionalMap = new HashMap<>();

		for (int i = 0; i < skiCourt.length; i++) {
			for (int j = 0; j < skiCourt[i].length; j++) {
				Position position = new Position();
				position.x = i;
				position.y = j;
				for (int a = 0; a < 4; a++) {
					if (i + dx[a] > -1 && i + dx[a] < skiCourt.length && j + dy[a] > -1
							&& j + dy[a] < skiCourt[i].length && skiCourt[i][j] > skiCourt[i + dx[a]][j + dy[a]]) {

						List<Position> positionalList = positionalMap.get(position);
						if (positionalList == null) {
							positionalList = new ArrayList<>();
						}
						Position connectedPosition = new Position();
						connectedPosition.x = i + dx[a];
						connectedPosition.y = j + dy[a];
						
						
						
						positionalList.add(connectedPosition);

						if (occupy[i][j] == null) {
							occupy[i][j] = "" +skiCourt[i][j];
						}
						occupy[i][j] +=  " " + skiCourt[i + dx[a]][j + dy[a]];

						positionalMap.put(position, positionalList);

					}

				}
			}
		}

		for (int i = 0; i < occupy.length; i++) {
			System.out.println(Arrays.toString(occupy[i]));
		}
//		System.out.println(positionalMap);
		return result;
	}

	static class Position {
		int x;
		int y;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "{" + x + "," + y + "}";
		}

	}

	static class Solution implements Comparable<Solution> {
		Position startPosition;
		Position endPosition;
		int length;
		int depth;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Solution o) {
			if (o.length > length) {
				return -1;
			} else if (o.length < length) {
				return 1;
			} else {
				if (o.depth > depth) {
					return -1;
				}
				if (o.depth < depth) {
					return 1;
				}
			}
			return 0;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Solution [length=" + length + ", depth=" + depth + "]";
		}
		
		
	}
}
