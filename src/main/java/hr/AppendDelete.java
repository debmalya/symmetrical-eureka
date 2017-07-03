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
public class AppendDelete {

	/**
	 * You have a string, s, of lower case English alphabetic letters. You can
	 * perform two types of operations on s:
	 * 
	 * Append a lower case English alphabetic letter to the end of the string.
	 * Delete the last character in the string. Performing this operation on an
	 * empty string results in an empty string. Given an integer, k , and two
	 * strings s, and t, determine whether or not you can convert to by
	 * performing exactly k of the above operations on s. If it's possible,
	 * print Yes; otherwise, print No.
	 * 
	 * Input Format
	 * 
	 * The first line contains a string, s, denoting the initial string. The
	 * second line contains a string,t , denoting the desired final string. The
	 * third line contains an integer,k , denoting the desired number of
	 * operations.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String s = in.next();
			String t = in.next();
			int k = in.nextInt();
			System.out.println(isPossible(s, t, k));
		}

	}

	/**
	 * @param s
	 * @param t
	 * @param k
	 * @return
	 */
	public static String isPossible(String s, String t, int k) {
		int len = s.length() > t.length() ? t.length() : s.length();
		int diff = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				diff += s.length() - i;
				diff += t.length() - i;
				break;
			}
		}

		if (s.contains(t)) {
			if (diff <= k) {
				return "Yes";
			}
			return "No";
		} else if (diff == 0) {
			// s is substring of t
			diff = t.length() - s.length();
			if (diff == k) {
				return "Yes";
			} else if (diff > 1 && k % diff == 0) {
				return "Yes";
			}
			return "No";
		} else if (diff > k) {
			return "No";
		}
		return "Yes";
	}

}
