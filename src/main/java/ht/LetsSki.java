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

import java.util.Scanner;

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
	 * Get the best sky path.
	 * 
	 * @param skiCourt
	 * @return length of the sky path, depth of sky path.
	 */
	public static int[] bestSkiWay(int[][] skiCourt) {
		int[] result = new int[2];
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		
		return result;
	}

	static class Position {
		int x;
		int y;
	}
}
