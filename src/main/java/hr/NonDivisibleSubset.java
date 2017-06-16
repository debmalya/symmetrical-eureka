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
 * Given a set ,S, of n distinct integers, print the size of a maximal subset,S1
 * , of S where the sum of any 2 numbers in S1 are not evenly divisible by k.
 * 
 * @author debmalyajash
 *
 */
public class NonDivisibleSubset {

	/**
	 * @param args
	 * 
	 *            5 5 2 7 12 17 22 - 5
	 * 
	 * 
	 *            6 9 422346306 940894801 696810740 862741861 85835055 313720373
	 *            - 5
	 */
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[] arr = new int[n];
			int[] rem = new int[k];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				rem[arr[i] % k]++;
			}

			int count = 0;
			if (rem[0] > 0) {
				count++;
			}
			for (int i = 1, j = k - 1; i <= j; i++, j--) {
				if (rem[i] > rem[j]) {
					count += rem[i];
				}else {
					count += rem[j];
				}
			}

			System.out.println(count);

		}
	}
	
	/**
	 * 
	 * @param n - number of distinct integers ( 1<= n <= 100000)
	 * @param k - divisor (1<= k <= 100)
	 * @param arr - array containing distinct integers
	 * @return size of a maximal subset.
	 */
	public int getNumberOfNonDivisibleSet(int n,int k,int[] arr) {
		
		int[] rem = new int[k];
		for (int i = 0; i < n; i++) {
			rem[arr[i] % k]++;
		}
		int count = 0;
		if (rem[0] > 0) {
			count++;
		}
		for (int i = 1, j = k - 1; i <= j; i++, j--) {
			if (rem[i] > rem[j]) {
				count += rem[i];
			}else {
				count += rem[j];
			}
		}
		return count;
	}

}
