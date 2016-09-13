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
public class Lighthouse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = Integer.parseInt(in.nextLine());
			int[] radius = new int[n];
			int maxLength = 0;
			int radiusRow = 0;
			char[][] board = new char[n][n];
			for (int i = 0; i < n; i++) {
				char[] each = in.nextLine().toCharArray();
				int count = 0;
				for (int j = 0; j < each.length; j++) {
					if (each[j] == '.') {
						count++;
					}
				}
				maxLength = Math.max(maxLength, count);
				radius[i] = count;
				if (maxLength == count) {
					radiusRow = i;
				}
				board[i] = each;
			}

			if (maxLength < 3) {
				// Not possible
				System.out.println("0");
			} else {
				//
				int proposedRadius = radius[radiusRow] / 2;
				
//				Get the starting point of radius.
//				Get the end point of radius.
				int start = -1;
				int end = n;
				for (int i = 0; i < n; i++) {
					if (start == -1 &&  board[radiusRow][i] == '.'){
						start = i;
					} else if (start != -1 && end == n && board[radiusRow][i] != '.'){
						end = i - 1;
					}
				}
				System.out.println(proposedRadius + " starts at " + start + " ends at " + end);
			}
		}

	}

}
