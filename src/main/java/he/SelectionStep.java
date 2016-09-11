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
package he;

import java.util.Scanner;

/**
 * @author debmalyajash
 * 
 *         Consider an Array a of size N Iterate from 1 to N N In i t h ith
 *         iteration select the i th minimum and swap it with a [ i ] a[i] You
 *         are given an array a a, size of the array N N and an integer x x.
 *         Follow the above algorithm and print the state of the array after x x
 *         iterations have been performed.
 * 
 *         Input Format
 * 
 *         The first line contains two integer N N and x x denoting the size of
 *         the array and the steps of the above algorithm to be performed
 *         respectively. The next line contains N N space separated integers
 *         denoting the elements of the array.
 * 
 *         Output Format
 * 
 *         Print N N space separated integers denoting the state of the array
 *         after x x steps
 * 
 * 
 */
public class SelectionStep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains two integer N and x denoting the size of
			// the array and the steps of the above algorithm to be performed
			// respectively.
			int N = in.nextInt();
			int x = in.nextInt();

			// The next line contains N space separated integers denoting the
			// elements of the array.
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = in.nextInt();
			}

			selection_sort(A, x);

			for (int i = 0; i < N; i++) {
				System.out.print(A[i] + " ");
			}
		}

	}

	static void selection_sort(int A[], int n) {
		// temporary variable to store the position of minimum element

		int minimum;
		// reduces the effective size of the array by one in each iteration.

		for (int i = 0; i < n; i++) {

			// assuming the first element to be the minimum of the unsorted
			// array .
			minimum = i;

			// gives the effective size of the unsorted array .

			for (int j = i + 1; j < n; j++) {
				if (A[j] < A[minimum]) { // finds the minimum element
					minimum = j;
				}
			}
			// putting minimum element on its proper position.
			swap(A, minimum, i);
		}
	}

	/**
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		System.err.println("Swap :" + a[i] + " " + a[j]);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.err.println("After Swap :" + a[i] + " " + a[j]);

	}

}
