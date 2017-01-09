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
package hr.stat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class InterQuartileRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();

			int[] x = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
			}

			int[] f = new int[n];
			List<Integer> arrL = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				f[i] = in.nextInt();
				for (int j = 0; j < f[i]; j++) {
					arrL.add(x[i]);
				}
			}

			int[] arr = new int[arrL.size()];
			for (int i = 0; i < arrL.size(); i++) {
				arr[i] = arrL.get(i);
			}

			double[] v = getQuartile(arr);

			System.out.println(String.format("%.1f", (v[2] - v[0])));

		}

	}

	/**
	 * @param arr
	 *            containing all the integers.
	 * @return quartile values.
	 */
	public static double[] getQuartile(int[] arr) {
		double[] quartiles = new double[3];
		quartiles[1] = getMedian(arr);
		int mid = arr.length / 2;
		int[] arr1 = new int[mid];
		int secondArrayLength = arr.length - mid;
		if (arr.length % 2 == 1) {
			secondArrayLength--;
		}
		int[] arr2 = new int[secondArrayLength];
		System.arraycopy(arr, 0, arr1, 0, mid);
		System.arraycopy(arr, mid + 1, arr2, 0, arr.length - mid - 1);

		quartiles[0] = getMedian(arr1);
		quartiles[2] = getMedian(arr2);
		return quartiles;
	}

	/**
	 * @param arr
	 *            containing all the integers.
	 * @return median.
	 */
	public static double getMedian(int[] arr) {
		Arrays.sort(arr);
		int mid = arr.length / 2;
		if (arr.length % 2 == 1) {
			return arr[mid];
		} else {
			return (double) (arr[mid] + arr[mid - 1]) / 2;
		}
	}

}
