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
package array.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class ArrayUtil {

	/**
	 * Given an array a that contains only numbers in the range from 1 to
	 * a.length, find the first duplicate number for which the second occurrence
	 * has the minimal index. In other words, if there are more than 1
	 * duplicated numbers, return the number for which the second occurrence has
	 * a smaller index than the second occurrence of the other number does. If
	 * there are no such elements, return -1.
	 * 
	 * Example
	 * 
	 * For a = [2, 3, 3, 1, 5, 2], the output should be firstDuplicate(a) = 3.
	 * 
	 * There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a
	 * smaller index than than second occurrence of 2 does, so the answer is 3.
	 * 
	 * For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.integer a
	 * 
	 * Guaranteed constraints: 1 ≤ a.length ≤ 10**5, 1 ≤ a[i] ≤ a.length.
	 * 
	 * [output] integer
	 * 
	 * The element in a that occurs in the array more than once and has the
	 * minimal index for its second occurrence. If there are no such elements,
	 * return -1.
	 * 
	 * @param a
	 *            - array of integer.
	 * @return - minimal index of the duplicate element
	 */
	public int firstDuplicate(int[] a) {
		int index = -1;
		Set<Integer> unique = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (!unique.add(a[i])) {
				index = a[i];
				break;
			}
		}
		return index;
	}

	/**
	 * Note: Write a solution that only iterates over the string once and uses
	 * O(1) additional memory, since this is what you would be asked to do
	 * during a real interview.
	 * 
	 * Given a string s, find and return the first instance of a non-repeating
	 * character in it. If there is no such character, return '_'.
	 * 
	 * Example
	 * 
	 * For s = "abacabad", the output should be firstNotRepeatingCharacter(s) =
	 * 'c'.
	 * 
	 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return c
	 * since it appears in the string first.
	 * 
	 * For s = "abacabaabacaba", the output should be
	 * firstNotRepeatingCharacter(s) = '_'.
	 * 
	 * There are no characters in this string that do not repeat.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] string s
	 * 
	 * A string that contains only lowercase English letters.
	 * 
	 * Guaranteed constraints: 1 ≤ s.length ≤ 105.
	 * 
	 * [output] char
	 * 
	 * The first non-repeating character in s, or '_' if there are no characters
	 * that do not repeat.
	 * 
	 * 
	 * @param s
	 *            - String .
	 * @return first non repeating character.
	 */
	public char firstNotRepeatingCharacter(String s) {
		char r = '_';

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String f = s.substring(0, i);
			String l = "";

			if (f.indexOf(c) == -1) {
				if (i < s.length() - 1) {
					l = s.substring(i + 1);
				}
				if (l.indexOf(c) == -1) {
					r = c;
					break;
				}
			}
		}
		return r;
	}

	/**
	 * You are given an n x n 2D matrix that represents an image. Rotate the
	 * image by 90 degrees (clockwise).
	 * 
	 * Try to solve this in-place - in a real interview, you will only be
	 * allowed to use O(1) additional memory.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] the output should be
	 * 
	 * rotateImage(a) = [[7, 4, 1], [8, 5, 2], [9, 6, 3]] Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.array.integer a
	 * 
	 * Guaranteed constraints: 1 ≤ a.length ≤ 100, a[i].length = a.length, 1 ≤
	 * a[i][j] ≤ 104.
	 * 
	 * [output] array.array.integer
	 * 
	 * 
	 * @param a
	 *            array of integer
	 * @return - rotated array
	 */
	public int[][] rotateImage(int[][] a) {

		int[][] arr = new int[a.length][a.length];
		for (int j = 0, row = 0; j < a.length; j++, row++) {
			for (int i = a.length - 1, col = 0; i > -1; i--, col++) {
				System.out.print(a[i][j] + " ");
				arr[row][col] = a[i][j];
			}
			System.out.println();
		}

		return arr;

	}

	public int[][] rotateImage1(int[][] a) {

		int[][] arr = new int[a.length][a.length];
		for (int j = 0, row = 0; j < a.length; j++, row++) {
			for (int i = a.length - 1, col = 0; i > -1; i--, col++) {
				System.out.print(a[i][j] + " ");
				arr[row][col] = a[i][j];
			}
			System.out.println();
		}

		return arr;

	}

	public int[][] rotateImage0(int[][] a) {

		int mid = a.length / 2;
		for (int i = a.length - 1; i > mid; i--) {
			for (int j = 0; j <= mid; j++) {
				int temp = a[0][j];
				a[0][j] = a[i - j][0];
				a[i - j][0] = a[i][i - j];
				a[i][i - j] = a[j][i];
				a[j][i] = temp;
			}
		}

		return a;

	}

	/**
	 * Given an array of integers, find the pair of adjacent elements that has
	 * the largest product and return that product.
	 * 
	 * Example
	 * 
	 * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
	 * adjacentElementsProduct(inputArray) = 21.
	 * 
	 * 7 and 3 produce the largest product.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.integer inputArray
	 * 
	 * An array of integers containing at least two elements.
	 * 
	 * Guaranteed constraints: 2 ≤ inputArray.length ≤ 10, -1000 ≤ inputArray[i]
	 * ≤ 1000.
	 * 
	 * [output] integer
	 * 
	 * The largest product of adjacent elements.
	 * 
	 * 
	 * 
	 */
	int adjacentElementsProduct(int[] inputArray) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 1; i < inputArray.length; i++) {
			int eachProduct = inputArray[i] * inputArray[i - 1];
			if (eachProduct > maxProduct) {
				maxProduct = eachProduct;
			}
		}
		return maxProduct;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	int shapeArea(int n) {
		int n1 = n + (n - 1);
		int r = n1;
		while (n1 > 1) {
			n1 -= 2;
			r += n1;
			r += n1;
		}
		return r;
	}

	/**
	 * Given a sequence of integers as an array, determine whether it is
	 * possible to obtain a strictly increasing sequence by removing no more
	 * than one element from the array.
	 * 
	 * Example
	 * 
	 * For sequence = [1, 3, 2, 1], the output should be
	 * almostIncreasingSequence(sequence) = false;
	 * 
	 * There is no one element in this array that can be removed in order to get
	 * a strictly increasing sequence.
	 * 
	 * For sequence = [1, 3, 2], the output should be
	 * almostIncreasingSequence(sequence) = true.
	 * 
	 * You can remove 3 from the array to get the strictly increasing sequence
	 * [1, 2]. Alternately, you can remove 2 to get the strictly increasing
	 * sequence [1, 3].
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.integer sequence
	 * 
	 * Guaranteed constraints: 2 ≤ sequence.length ≤ 105, -105 ≤ sequence[i] ≤
	 * 105.
	 * 
	 * [output] boolean
	 * 
	 * Return true if it is possible to remove one element from the array in
	 * order to get a strictly increasing sequence, otherwise return false.
	 * 
	 * 
	 * @param sequence
	 *            of integer.
	 * @return true if removing one element can increase
	 */
	boolean almostIncreasingSequence(int[] sequence) {

		short c = 0;
		int l = sequence.length;
		int last = 0;
		boolean started = false;

		for (int i = 0; i < l; i++) {
			if (i == 0 && i < l - 1) {

				if (sequence[i] < sequence[i + 1]) {
					c++;
					last = sequence[i];
				}

			} else if (i < l - 1 && sequence[i - 1] < sequence[i] && sequence[i] < sequence[i + 1]) {
				c++;
				if (started && sequence[i] < last) {
					return false;
				}
				last = sequence[i];

			} else if (i == l - 1 && sequence[i - 1] < sequence[i]) {
				if (started && sequence[i] < last) {
					return false;
				}
				c++;
				last = sequence[i];
			}

			if (c > 0) {
				started = true;
			}
		}

		if (c == l)

		{
			// perfect condition
			return true;
		}

		if (l - c > 2) {
			// perfect false
			return false;
		}

		// dropping the proper one can make it increasing array.
		c = 0;
		Arrays.sort(sequence);
		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i] <= sequence[i - 1]) {
				c++;
			}
			if (c > 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * After becoming famous, CodeBots decided to move to a new building and
	 * live together. The building is represented by a rectangular matrix of
	 * rooms, each cell containing an integer - the price of the room. Some
	 * rooms are free (their cost is 0), but that's probably because they are
	 * haunted, so all the bots are afraid of them. That is why any room that is
	 * free or is located anywhere below a free room in the same column is not
	 * considered suitable for the bots.
	 * 
	 * Help the bots calculate the total price of all the rooms that are
	 * suitable for them.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * matrix = [[0, 1, 1, 2], [0, 5, 0, 0], [2, 0, 3, 3]] the output should be
	 * matrixElementsSum(matrix) = 9.
	 * 
	 * Here's the rooms matrix with unsuitable rooms marked with 'x':
	 * 
	 * [[x, 1, 1, 2], [x, 5, x, x], [x, x, x, x]] Thus, the answer is 1 + 5 + 1
	 * + 2 = 9.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.array.integer matrix
	 * 
	 * 2-dimensional array of integers representing a rectangular matrix of the
	 * building.
	 * 
	 * Guaranteed constraints: 1 ≤ matrix.length ≤ 5, 1 ≤ matrix[i].length ≤ 5,
	 * 0 ≤ matrix[i][j] ≤ 10.
	 * 
	 * [output] integer
	 * 
	 * 
	 * @param matrix
	 *            of integer.
	 * @return Sum of charges of available rooms.
	 */
	public int matrixElementsSum(int[][] matrix) {
		int total = 0;
		boolean[] checked = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || (i > 0 && !checked[j])) {
					total += matrix[i][j];
				}
				if (matrix[i][j] == 0) {
					checked[j] = true;
				}
			}
		}
		return total;
	}

	/**
	 * Given two strings, find the number of common characters between them.
	 * 
	 * Example
	 * 
	 * For s1 = "aabcc" and s2 = "adcaa", the output should be
	 * commonCharacterCount(s1, s2) = 3.
	 * 
	 * Strings have 3 common characters - 2 "a"s and 1 "c".
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] string s1
	 * 
	 * A string consisting of lowercase latin letters a-z.
	 * 
	 * Guaranteed constraints: 1 ≤ s1.length ≤ 15.
	 * 
	 * [input] string s2
	 * 
	 * A string consisting of lowercase latin letters a-z.
	 * 
	 * Guaranteed constraints: 1 ≤ s2.length ≤ 15.
	 * 
	 * [output] integer
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int commonCharacterCount(String s1, String s2) {
		int[] a1 = new int[26];
		int[] a2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			a1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			a2[s2.charAt(i) - 'a']++;
		}

		int c = 0;
		for (int i = 0; i < 26; i++) {
			if (a1[i] > 0 && a2[i] > 0) {
				c += Math.min(a1[i], a2[i]);
			}
		}

		return c;
	}

	/**
	 * 
	 * @param someSet
	 * @return
	 */
	public boolean goodSet(int[] someSet) {
		Arrays.sort(someSet);
		for (int i = 0; i < someSet.length; i++) {
			for (int j = 0; j < someSet.length; j++) {

				if (i != j && (someSet[i] != 0 && someSet[j] != 0)
						&& Arrays.binarySearch(someSet, (someSet[i] + someSet[j])) > -1) {
					return false;
				}
			}
		}
		return true;
	}

}
