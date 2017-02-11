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
package hr.RookieRank2;

import java.util.Scanner;

/**
 * @author debmalyajash User Story :
 * 
 *         We say that a string, , contains the word hackerrank if a subsequence
 *         of the characters in spell the word hackerrank. For example,
 *         haacckkerrannkk does contain hackerrank, but haacckkerannk does not
 *         (the characters all appear in the same order, but it's missing a
 *         second r).
 *
 */
public class HackerrankInAString {

	private static final char[] hackerrank = "hackerrank".toCharArray();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int q = in.nextInt();
			boolean[] answers = new boolean[q];
			for (int a0 = 0; a0 < q; a0++) {
				String s = in.next();
				answers[a0] = check(s);
			}

			for (int a0 = 0; a0 < q; a0++) {
				if (answers[a0]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	 /**
		 * @param s
		 * @return
		 */
		public static boolean check(String s) {
			s = s.toLowerCase();
			int hackerIndex = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (hackerIndex < hackerrank.length && c == hackerrank[hackerIndex]  ) {
					hackerIndex++;
				} 
			}
			if (hackerIndex == hackerrank.length) {
				return true;
			} else {
				return false;
			}
		}

}
