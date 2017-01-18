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
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class DFSConnectedCellInAGrid {

	/**
	 * Consider a matrix with n rows and m columns, where each cell contains
	 * either a 0 or a 1 and any cell containing a is called a filled cell. Two
	 * cells are said to be connected if they are adjacent to each other
	 * horizontally, vertically, or diagonally.
	 * 
	 * If one or more filled cells are also connected, they form a region. Note
	 * that each cell in a region is connected to at least one other cell in the
	 * region but is not necessarily directly connected to all the other cells
	 * in the region.
	 * 
	 * Task Given an matrix, find and print the number of cells in the largest
	 * region in the matrix. Note that there may be more than one region in the
	 * matrix.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1 };
		int[] dy = new int[] { -1, 0, 1, 1, -1, 0, 1 };

		try (Scanner in = new Scanner(System.in)) {
			int rowOfMatrix = in.nextInt();
			int colOfMatrix = in.nextInt();

			boolean[][] matrix = new boolean[rowOfMatrix][colOfMatrix];

			for (int i = 0; i < rowOfMatrix; i++) {
				for (int j = 0; j < colOfMatrix; j++) {
					if (in.nextInt() == 1) {
						matrix[i][j] = true;
					}
				}
			}
		}

	}
	
	static class Region {
		List<Integer> cellList = new ArrayList<>();
	}

}
