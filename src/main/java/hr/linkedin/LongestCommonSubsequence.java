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

	StringBuilder result = new StringBuilder();

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

			System.out.println(getLongestCommonSubsequence(a, b).trim());
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

		int ae = a.length - 1;
		int be = b.length - 1;

		if (ae == -1 || be == -1) {
			return "";
		}

		int[] ac = new int[ae];
		int[] bc = new int[be];

		System.arraycopy(a, 0, ac, 0, ae);
		System.arraycopy(b, 0, bc, 0, be);

		if (a[ae] == b[be]) {
			return getLongestCommonSubsequence(ac, bc) + " " + a[ae];
		} else {

			String first = getLongestCommonSubsequence(a, bc);
			String second = getLongestCommonSubsequence(ac, b);
			if (first.length() > second.length()) {
				return first;
			}
			return second;
		}

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
		for (int i = ae; i > -1; i--) {
			for (int j = be; j > -1; j--) {
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

	public static int LCS(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int lenA = A.length();
		int lenB = B.length();
		// check if last characters are same
		if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
			// Add 1 to the result and remove the last character from both
			// the strings and make recursive call to the modified strings.
			return 1 + LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
		} else {
			// Remove the last character of String 1 and make a recursive
			// call and remove the last character from String 2 and make a
			// recursive and then return the max from returns of both recursive
			// calls
			return Math.max(LCS(A.substring(0, lenA - 1), B.substring(0, lenB)),
					LCS(A.substring(0, lenA), B.substring(0, lenB - 1)));
		}
	}

}