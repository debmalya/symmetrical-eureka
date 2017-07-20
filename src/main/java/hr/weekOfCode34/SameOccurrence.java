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
package hr.weekOfCode34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Solution {

	/**
	 * You are given an array of size n and you have to answer q queries. Each
	 * query consists of 2 integers x and y. For each query, you need to count
	 * and print the total number of sub arrays(contiguous) in which the number
	 * of occurrences of x is equal to the number of occurrences of y.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int q = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			for (int a0 = 0; a0 < q; a0++) {
				int x = in.nextInt();
				int y = in.nextInt();
				// Write Your Code Here
				System.out.println(getContiguousArray(x, y, arr));
			}
			in.close();
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param arr
	 * @return
	 */
	public static int getContiguousArray(int x, int y, int[] arr) {
		int n = arr.length;
		int[] arr_c = new int[n];
		System.arraycopy(arr, 0, arr_c, 0, n);
		Arrays.sort(arr);
		if (Arrays.binarySearch(arr, x) < 0 && Arrays.binarySearch(arr, y) < 0) {
			return (n * (n + 1)) / 2;
		}

		//
		int pos1 = -1;
		int count1 = 0;
		int pos2 = -1;
		int count2 = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			boolean found = false;
			if (arr_c[i] == x) {
				pos1 = i;
				count1++;
				found = true;
			} else if (arr_c[i] == y) {
				pos2 = i;
				count2++;
				found = true;
			}

			if (found && count1 == count2 && count1 > 0) {
				result++;
			} else if (found && Math.abs(pos2 - pos1) == 1 && pos2 > -1 && pos1 > -1) {
				result++;
			}

		}
		return result;
	}

}
