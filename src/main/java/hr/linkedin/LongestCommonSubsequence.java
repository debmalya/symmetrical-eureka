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
package hr.linkedin;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();

			int[] a = new int[n];
			int[] b = new int[m];

			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			for (int i = 0; i < m; i++) {
				b[i] = in.nextInt();
			}

			System.out.println(getLongestCommonSubsequence(a, b));
		}

	}

	/**
	 * @param a
	 *            first integer array.
	 * @param b
	 *            second integer array.
	 * @return string containing longest common subsequence.
	 */
	public static String getLongestCommonSubsequence(int[] a, int[] b) {
		StringBuilder answer = new StringBuilder();

		// First Property
		// Suppose that two sequences both end in the same element. To find
		// their LCS, shorten each sequence by removing the last element, find
		// the LCS of the shortened sequences, and to that LCS append the
		// removed element.
		int ae = a.length - 1;
		int be = b.length - 1;
		while (a[ae--] == b[be--]) {
			// both end with the same element.
			answer.append(a[ae + 1]);
		}
		if (answer.length() > 0) {
			answer = answer.reverse();
		}
		
		StringBuilder prefix = new StringBuilder();
		for (int i=ae; i >-1; i--){
			for (int j =be; j> -1;j--){
				if (a[i] == b[j]) {
					prefix.append(a[i]);
				}
			}
		}
		if (prefix.length() > 0) {
			prefix = prefix.reverse();
			prefix.append(answer);
			answer = prefix;
		}

		return answer.toString();
	}

	/**
	 * @param a
	 *            first integer array.
	 * @param b
	 *            second integer array.
	 * @return string containing longest common subsequence.
	 */
	public static String getLongestCommonSubsequence(char[] a, char[] b) {
		StringBuilder answer = new StringBuilder();

		// First Property
		// Suppose that two sequences both end in the same element. To find
		// their LCS, shorten each sequence by removing the last element, find
		// the LCS of the shortened sequences, and to that LCS append the
		// removed element.
		int ae = a.length - 1;
		int be = b.length - 1;
		while (a[ae--] == b[be--]) {
			// both end with the same element.
			answer.append(a[ae + 1]);
		}
		if (answer.length() > 0) {
			answer = answer.reverse();
		}
		
		StringBuilder prefix = new StringBuilder();
		for (int i=ae; i >-1; i--){
			for (int j =be; j> -1;j--){
				if (a[i] == b[j]) {
					prefix.append(a[i]);
				}
			}
		}
		if (prefix.length() > 0) {
			prefix = prefix.reverse();
			prefix.append(answer);
			answer = prefix;
		}
		return answer.toString();
	}

}
