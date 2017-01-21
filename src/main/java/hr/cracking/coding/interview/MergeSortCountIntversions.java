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
package hr.cracking.coding.interview;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MergeSortCountIntversions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int d = in.nextInt();
			int[] result = new int[d];

			for (int i = 0; i < d; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}

				result[i] = getSwapCount(arr);

			}
		}

	}

	/**
	 * @param arr
	 * @return
	 */
	public static int getSwapCount(int[] arr) {
		int result = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					result++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return result;
	}

}
