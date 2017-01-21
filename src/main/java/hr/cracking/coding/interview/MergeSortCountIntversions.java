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
			long[] result = new long[d];

			for (int i = 0; i < d; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}

				result[i] = countInversions(arr);

			}
			
			for (int i = 0; i < d; i++) {
				System.out.println(result[i]);
			}
		}

	}
	
	/**
	 * 
	 * @param arr
	 * @return
	 */
	private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }
	
	/**
	 * Divide and conquer. Divide the array in the middle. Count the inversions. 
	 * Merge the array count inversions.
	 * 
	 * @param arr for whom inversion counts will be calculated.
	 * @param lo low index.
	 * @param hi high index.
	 * @param aux auxiliary array.
	 * @return total number of inversion counts.
	 */
	  private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
	        if (lo >= hi) return 0;

	        int mid = lo + (hi - lo) / 2;

	        long count = 0;
	        count += countInversions(aux, lo, mid, arr);
	        count += countInversions(aux, mid + 1, hi, arr);
	        count += merge(arr, lo, mid, hi, aux);

	        return count;
	    }
	  
	  /**
	   * Merge the arrays arr and aux, return the inversion count.
	   * @param arr 
	   * @param lo low index.
	   * @param mid middle index.
	   * @param hi high index.
	   * @param aux auxiliary array.
	   * @return number of inversions.
	   */
	  private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
	        long count = 0;
	        int i = lo, j = mid + 1, k = lo;
	        while (i <= mid || j <= hi) {
	            if (i > mid) {
	                arr[k++] = aux[j++];
	            } else if (j > hi) {
	                arr[k++] = aux[i++];
	            } else if (aux[i] <= aux[j]) {
	                arr[k++] = aux[i++];
	            } else {
	                arr[k++] = aux[j++];
	                count += mid + 1 - i;
	            }
	        }

	        return count;
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
