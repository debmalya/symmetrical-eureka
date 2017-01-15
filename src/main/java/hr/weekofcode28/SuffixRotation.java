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
package hr.weekofcode28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class SuffixRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int numberOfGames = in.nextInt();
			int[] result = new int[numberOfGames];

			for (int i = 0; i < numberOfGames; i++) {
				result[i] = getSuffixRotation(in.next());
			}

			for (int i = 0; i < numberOfGames; i++) {
				System.out.println(result[i]);
			}
		}

	}

	/**
	 * 
	 * @param S
	 * @return
	 */
	public static int lcs(String S) {
		S += S; // Concatenate string to it self to avoid modular
				// arithmetic.

		int[] f = new int[S.length()]; // Failure Function.
//		Arrays.fill(f, -1);

		int k = 0; // Least rotation found so far.

		for (int j = 1; j < S.length(); j++) {
			char sj = S.charAt(j);
			int i = f[j - k - 1];

			while (i != -1 && sj != S.charAt(k + i + 1)) {

				if (sj < S.charAt(k + i + 1)) {
					k = j - i - 1;
				}
				i = f[i];
				
				if (sj != S.charAt(k + i + 1)){
					if (sj < S.charAt(k)){
						k = j;
					}
					f[j-k] = -1;
				} else {
					f[j-k] = i+1;
				}

			}
		}
		return k;
	}

	/**
	 * @param next
	 * @return
	 */
	public static int getSuffixRotation(String next) {
		if (next != null && next.trim().length() > 0) {
			char prev = next.charAt(0);
			for (int i = 1; i < next.length(); i++) {
				char current = next.charAt(i);
				if (current - prev < 0) {
					return rotate(next, i - 1);
				}
				prev = current;
			}
		}
		return 0;
	}

	/**
	 * @param next
	 * @param i
	 */
	public static int rotate(String next, int i) {
		String rotate = next.substring(i);
		int len = rotate.length();

		rotate += rotate;
		int result = 0;
		for (int a = 0; a < len; a++) {
			String afterRotation = rotate.substring(a, a + len);
			if (isSorted(afterRotation)) {
				return a;
			} else {
				String remaining = afterRotation.substring(a + 1);
				result = getSuffixRotation(remaining);
				if (result > 0) {
					// System.out.println(a + " " + remaining + " " + (a + 1 +
					// result));
					return a + 1 + result;
				}
			}
		}
		return result;
	}

	/**
	 * @param afterRotation
	 * @return
	 */
	private static boolean isSorted(String afterRotation) {
		char prev = afterRotation.charAt(0);
		for (int i = 1; i < afterRotation.length(); i++) {
			char current = afterRotation.charAt(i);
			if (current < prev) {
				return false;
			}
			prev = current;
		}
		return true;
	}

}
