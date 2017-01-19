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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		try (Scanner in = new Scanner(System.in)) {
			int rowOfMatrix = in.nextInt();
			int colOfMatrix = in.nextInt();

			int[][] matrix = new int[rowOfMatrix][colOfMatrix];

			for (int i = 0; i < rowOfMatrix; i++) {
				for (int j = 0; j < colOfMatrix; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			System.out.println(getMaxSize(matrix));

		}

	}

	static class Region {
		List<Integer> cellList = new ArrayList<>();

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Region [cellList=" + cellList + "]";
		}

	}

	public static int getMaxSize(int[][] cell) {
		int rowOfMatrix = cell.length;
		int colOfMatrix = cell[0].length;

		int[] dx = new int[] { -1, -1, -1, 0, 0, 1, -1, 1 };
		int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		int maxSize = 0;

		// Will contain all the regions.
		List<Region> regionList = new ArrayList<>();
		// Key is the cell id and value is the region id.
		Map<Integer, Integer> cellNRegionMap = new HashMap<>();

		for (int i = 0; i < rowOfMatrix; i++) {
			for (int j = 0; j < colOfMatrix; j++) {
				if (cell[i][j] == 1) {

					int currentPosition = i * colOfMatrix + j;

					// check whether this cell will be part of existing
					// region or need to create a new region.
					boolean regionFound = false;
					Integer currentRegionID = cellNRegionMap.get(currentPosition);

					if (currentRegionID == null) {
						List<Integer> unalloctedList = new ArrayList<>();
						for (int a = 0; a < dx.length; a++) {

							int new_i = i + dx[a];
							int new_j = j + dy[a];
							// System.out.println("Checking : (" + new_i + "," +
							// new_j + ")");
							
							
							if (new_i > -1 && new_i < rowOfMatrix && new_j > -1 && new_j < colOfMatrix
									&& cell[i + dx[a]][j + dy[a]] == 1) {
								int neighbourPosition = (i + dx[a]) * colOfMatrix + j + dy[a];
								Integer regionID = cellNRegionMap.get(neighbourPosition);
								if (regionID != null) {
									Region matchedRegion = regionList.get(regionID);
									if (!matchedRegion.cellList.contains(currentPosition)) {
										matchedRegion.cellList.add(currentPosition);
										if (matchedRegion.cellList.size() > maxSize) {
											maxSize = matchedRegion.cellList.size();
										}
									}

									cellNRegionMap.put(currentPosition, regionID);
									regionFound = true;

								} else {
//									System.out.println("currentPosition " + currentPosition + " current region :" + cellNRegionMap.get(neighbourPosition) + " neighbour " + neighbourPosition);
									unalloctedList.add(neighbourPosition);
								}
							}
						}

						if (!regionFound) {
							// Add new region
							Region region = new Region();
							region.cellList.add(currentPosition);
							if (region.cellList.size() > maxSize) {
								maxSize = region.cellList.size();
							}
							cellNRegionMap.put(currentPosition, regionList.size());
							regionList.add(region);
						}
						
						if (!unalloctedList.isEmpty()) {
							Integer currentRegion = cellNRegionMap.get(currentPosition);
							for (int ui = 0; ui < unalloctedList.size(); ui++){
//								System.out.println(unalloctedList.get(ui)+ " will be allocated to region " + currentRegion + " currentPosition " + currentPosition);
								
								// Allocation to unallocated
								Region matchedRegion = regionList.get(currentRegion);
								int unallocated = unalloctedList.get(ui);
								if (!matchedRegion.cellList.contains(unallocated)) {
									matchedRegion.cellList.add(unallocated);
									if (matchedRegion.cellList.size() > maxSize) {
										maxSize = matchedRegion.cellList.size();
									}
									cellNRegionMap.put(unallocated, currentRegion);
//									System.out.println(unallocated+ " allocated to region " + currentRegion + " .");
								}
							}
							
						}
						

					}
				}
			}
		}

//		 System.out.println(regionList);
//		 System.out.println(cellNRegionMap);
		 System.out.println(maxSize);

		return maxSize;
	}

}
