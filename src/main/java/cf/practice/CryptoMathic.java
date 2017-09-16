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
 * A cryptarithm is a mathematical puzzle for which the goal is to find the
 * correspondence between letters and digits, such that the given arithmetic
 * equation consisting of letters holds true when the letters are converted to
 * digits.
 * 
 * You have an array of strings crypt, the cryptarithm, and an an array
 * containing the mapping of letters and digits, solution. The array crypt will
 * contain three non-empty strings that follow the structure: [word1, word2,
 * word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.
 * 
 * If crypt, when it is decoded by replacing all of the letters in the
 * cryptarithm with digits using the mapping in solution, becomes a valid
 * arithmetic equation containing no numbers with leading zeroes, the answer is
 * true. If it does not become a valid arithmetic solution, the answer is false.
 * 
 * Example
 * 
 * For crypt = ["SEND", "MORE", "MONEY"] and
 * 
 * solution = [['O', '0'], ['M', '1'], ['Y', '2'], ['E', '5'], ['N', '6'], ['D',
 * '7'], ['R', '8'], ['S', '9']] the output should be isCryptSolution(crypt,
 * solution) = true.
 * 
 * @author debmalyajash
 *
 */
public class CryptoMathic {
	boolean isCryptSolution(String[] crypt, char[][] solution) {
		long l = 0;
		long r = 0;

		int[] fa = new int[crypt[0].length()];
		int[] sa = new int[crypt[1].length()];
		int[] ta = new int[crypt[2].length()];

		for (int i = 0; i < solution.length; i++) {
			char c = solution[i][0];
			int v = solution[i][1] - '0';
			int f = crypt[0].indexOf(c);
			int s = crypt[1].indexOf(c);
			int t = crypt[2].indexOf(c);

			if (f > -1) {
				l += v * (int) Math.pow(10, crypt[0].length() - f);
				fa[f] = v;
			}
			if (s > -1) {
				l += v * (int) Math.pow(10, crypt[1].length() - s);
				sa[s] = v;
			}

			if (t > -1) {
				r += v * (int) Math.pow(10, crypt[2].length() - t);
				ta[t] = v;
			}
		}
		if (r != l) {
			return false;
		} else {
			if ((fa[0] == 0 && fa.length > 1) || (sa[0] == 0 && sa.length > 1) || (ta[0] == 0 && ta.length > 1)) {
				// leading zeroes
				return false;
			}
			return r == l;
		}

	}

}
