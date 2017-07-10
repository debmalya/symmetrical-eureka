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
public class FileOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			int[][] board = new int[5][5];
			String[] answer = new String[t];
			for (int i = 0; i < t; i++) {
				int j = 0;
				while (j < 5) {
					String nextLine = in.nextLine();

					for (int k = 0; k < nextLine.length(); k++) {
						board[j][k] = Integer.parseInt("" + nextLine.charAt(k));
					}

					j++;
				}

				// Check whether life is possible
				answer[i] = getAnswer(board);
			}

			for (int i = 0; i < t; i++) {
				System.out.println(answer[i]);
			}
		}

	}

	/**
	 * @param board
	 * @return
	 */
	public static String getAnswer(int[][] board) {
		int lc = 0;
		int h = board.length;
		int w = board[0].length;
		int[] dx = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
		int[] dy = new int[] { 1, 1, 1, 0, -1, -1, -1, 0 };
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int nc = 0;
				int row = i;
				int col = j;
				for (int k = 0; k < dx.length; k++) {
					row = i + dx[k];
					if (row == -1) {
						row = h - 1;
					} else if (row == h) {
						row = 0;
					}
					col = j + dy[k];
					if (col == -1) {
						col = w - 1;
					} else if (col == w) {
						col = 0;
					}
					if (board[row][col] == 1) {
						nc++;
					}
				}

				if (board[i][j] == 1) {
					if (nc == 2 || nc == 3) {
						lc++;
					} else {
						// if the cell has only zero or one live neighbors, the
						// cell will become dead at the next step.
						// if the cell alive and has more than three live
						// neighbors, the cell also dies.
						board[i][j] = 0;
					}
				}

				if (board[i][j] == 0 && nc == 3) {
					lc++;
					// If the cell is dead: if exactly three of its neighbors
					// are alive, the cell will become alive at the next step.
					board[i][j] = 1;
				}

			}

		}
		if (lc > 0) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
