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

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MagicSquare {

	/**
	 * We define a magic square to be an n X n matrix of distinct positive
	 * integers from 1 to n**2 where the sum of any row, column, or diagonal (of
	 * length n) is always equal to the same number (i.e., the magic constant).
	 * 
	 * Consider a 3 X 3 matrix, s , of integers in the inclusive range [1,9] .
	 * We can convert any digit, a , to any other digit, b , in the range at
	 * cost |a - b|.
	 * 
	 * Given S, convert it into a magic square at minimal cost by changing zero
	 * or more of its digits. Then print this cost on a new line.
	 * 
	 * Note: The resulting magic square must contain distinct integers in the inclusive range  |1,9|.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] s = new int[3][3];
		int remove = 0;
		int result = 0;
		int diagonal = 0;

		int[] row = new int[3];
		int[] col = new int[3];
		for (int s_i = 0; s_i < 3; s_i++) {
			for (int s_j = 0; s_j < 3; s_j++) {
				s[s_i][s_j] = in.nextInt();
				row[s_i] += s[s_i][s_j];
				col[s_j] += s[s_i][s_j];

				if (s_i == s_j) {
					diagonal += s[s_i][s_j];
				}
			}
		}

		System.out.println("Rows :" + Arrays.toString(row));
		System.out.println("Cols :" + Arrays.toString(col));
		System.out.println("Diagonal :" + diagonal);
		for (int i = 0; i < 3; i++) {
			result += Math.abs(15 - row[i]);
			if (row[i] != col[i]) {
				result += Math.abs(15 - col[i]);
			}

		}
		// Print the minimum cost of converting 's' into a magic square
		System.out.println(result);

	}

}
