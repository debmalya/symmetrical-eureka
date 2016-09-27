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
public class Gridland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Grid has n rows and m columns
			// rows are numbered from 1 to n.
			// columns are numbered from 1 to m.
			// Gridland has a network of train tracks that always run in
			// straight
			// horizontal lines along a row.

			// Starting point and end point of train track can be r,c1 -> r,c2
			// r is the row number c1,c2 column number.

			// A lamp post can be placed in any cell that is not occupied by a
			// train
			// track.
			int numberOfRows = in.nextInt();
			int numberOfCols = in.nextInt();
			int numberOfTracks = in.nextInt();

			int freePositions = numberOfRows * numberOfCols;
			boolean[][] occupancy = new boolean[numberOfRows][numberOfCols];

			for (int i = 0; i < numberOfTracks; i++) {
				int row = in.nextInt();
				int startCol = in.nextInt();
				int endCol = in.nextInt();

				for (int col = startCol; col <= endCol; col++) {
					// to check overlapping.
					if (!occupancy[row - 1][col - 1]) {
						freePositions--;
						occupancy[row - 1][col - 1] = true;
					}
				}

			}

			System.out.println(freePositions);
		}
	}

}
