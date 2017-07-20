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
package cf.practice;

/**
 * @author debmalyajash
 *
 */
public class SudukuUtil {
	
	/**
	 * 
	 Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[time limit] 3000ms (java)
[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
	 * @param grid
	 * @return
	 */
	public static boolean sudoku2(char[][] grid) {
	    // check whether same number repeated in a row
	    // check whether same number repeated in a col
	    // check whether same number repeated in a sub area
	    
	    int[][] rc = new int[10][10];
	    int[][] cc = new int[10][10];
	    int[][] subarea = new int[10][10];
	    for (int row = 0; row < grid.length; row++){
	        for (int col = 0; col < grid[0].length; col++){
	           
	            if (grid[row][col] != '.'){
	                int currentValue = grid[row][col]-'0';
	                rc[row][currentValue]++;
	                cc[col][currentValue]++;
	                if (rc[row][currentValue] > 1){
	                    // same number repeated in row.
	                    return false;
	                }
	                
	                if (cc[col][currentValue] > 1){
	                    // same number repeated in row.
	                    return false;
	                }

	                if (row < 3 && col < 3){
	                    
	                    subarea[1][currentValue]++;
	                    if (subarea[1][currentValue] > 1){
	                        return false;
	                    }
	                } else if (row < 3 && col > 2 && col < 6){
	                    
	                    subarea[2][currentValue]++;
	                    if (subarea[2][currentValue] > 1){
	                        return false;
	                    }
	                }else if (row < 3 && col > 5 && col < 9){
	                    
	                    subarea[3][currentValue]++;
	                    if (subarea[3][currentValue] > 1){
	                        return false;
	                    }
	                }else if (row > 2 && row < 6 && col < 3){
	                    
	                    subarea[4][currentValue]++;
	                    if (subarea[4][currentValue] > 1){
	                        return false;
	                    }
	                } else if (row > 2 && row < 6 && col > 2 && col < 6){
	                    
	                    subarea[5][currentValue]++;
	                    if (subarea[5][currentValue] > 1){
	                        return false;
	                    }
	                }else if (row > 2 && row < 6 && col > 5 && col < 9){
	                    
	                    subarea[6][currentValue]++;
	                    if (subarea[6][currentValue] > 1){
	                        return false;
	                    }
	                }else if (row > 5 && row < 9 && col < 3){
	                    
	                    subarea[7][currentValue]++;
	                    if (subarea[7][currentValue] > 1){
	                        return false;
	                    }
	                } else if (row > 5 && row < 9 && col > 2 && col < 6){
	                    
	                    subarea[8][currentValue]++;
	                    if (subarea[8][currentValue] > 1){
	                        return false;
	                    }
	                }else if (row > 5 && row < 6 && col > 5 && col < 9){
	                    
	                    subarea[9][currentValue]++;
	                    if (subarea[9][currentValue] > 1){
	                        return false;
	                    }
	                }
	            }
	        }
	    }
	    return true;
	}


}
