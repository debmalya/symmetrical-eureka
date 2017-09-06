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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class ParityGame {

	/**
	 * Given an array comprising of positive integers. The goal is to remove
	 * some (possibly empty) subsequence of these integers so that the sum of
	 * the resulting array is even.
	 * 
	 * The player is NOT allowed to remove all the numbers (i.e. the resulting
	 * array should be nonempty).
	 * 
	 * There can be multiple possible subsequences that can be removed to
	 * achieve this. Print the size of the smallest such subsequence. If there
	 * is no such subsequence, print -1.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line of input contains the size of the array, n.
			int n = in.nextInt();
			// The second line contains n space-separated integers, the of which
			// contains .
			int[] A = new int[n];
			for (int A_i = 0; A_i < n; A_i++) {
				A[A_i] = in.nextInt();
			}

			int result = smallestSizeSubsequence(n, A);
			System.out.println(result);
		}

	}

	/**
	 * @param n
	 * @param a
	 * @return
	 */
	public static int smallestSizeSubsequence(int n, int[] A) {
		// Return the size of the smallest subsequence to remove
		long total = 0;
		List<Integer> oddList = new ArrayList<>();
		List<Integer> evenList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			total += A[i];
			if (A[i] % 2 == 0) {
				evenList.add(A[i]);
			} else {
				oddList.add(A[i]);
			}
		}

		if (total % 2 == 0) {
			// If already even, no need to do anything.
			return 0;
		} else if (oddList.size() > 0) {
			// If there is at least one odd number, just removing that one will
			// make sum even.
			return 1;
		} else {
			return -1;
		}
	}

}
