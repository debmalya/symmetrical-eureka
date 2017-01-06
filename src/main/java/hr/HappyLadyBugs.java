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
public class HappyLadyBugs {

	/**
	 * Happy Lady Bug is a board game. The board is represented by a String b of
	 * length n. The nth character of string b, represents nth cell of the
	 * board.
	 * 
	 * if b nth is underscore '_', it means an empty cell. If b nth is any
	 * English alphabetic letter A through Z, it means nth cell contains ladybug
	 * of colour b nth.
	 * 
	 * String b can only contain A-Z or _. A ladybug is happy only when its left
	 * or right adjacent cell is occupied by another lady bug of same colour.
	 * 
	 * Given the values of n and b for g games of Happy LadyBugs.
	 * 
	 * determine if it's possible to make all the ladybugs happy. For each game
	 * print YES on a new line if all the ladybugs can be made happy through
	 * some number of moves.
	 * 
	 * Otherwise print NO to indicate that no number of moves will result in all
	 * the ladybugs being happy.
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// get number of games. ( 1 <= g <= 100)
			int g = in.nextInt();

			int limit = 2 * g;
			// Will store result for each game.
			boolean[] result = new boolean[g];
			int resultIndex = 0;
			for (int i = 0; i < limit; i+=2) {
				int n = in.nextInt();
				String b = in.next();
				result[resultIndex++] = isLadyBugHappy(b);
			}

			for (int i = 0; i < g; i++) {
				if (result[i]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	/**
	 * @param b
	 *            board position.
	 * @return true if ladybug of same color stay together.
	 */
	public static boolean isLadyBugHappy(String b) {
		int[] colour = new int[26];

		int noOfEmptyCells = 0;
		int noOfMisMatch = 0;
		char c = ' ';
		char prevC = ' ';
		for (int i = 0; i < b.length(); i++) {
			c = b.charAt(i);
			if (prevC != ' ' && prevC != c && prevC != '_') {
				noOfMisMatch++;
			}
			if (c == '_') {
				noOfEmptyCells++;
			} else {
				colour[c - 'A']++;
			}
			prevC = c;
		}

		for (int i = 0; i < 26; i++) {
			if (colour[i] == 1) {
				// Lonely lady bug.
				return false;
			}
		}

		// There are no empty cell but they need to move.
		if (noOfMisMatch > 0 && noOfEmptyCells == 0) {
			return false;
		}

		return true;
	}

}
