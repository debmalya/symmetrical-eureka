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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given N sticks, where the length of each stick is a positive integer.
 * A cut operation is performed on the sticks such that all of them are reduced
 * by the length of the smallest stick.
 * 
 * Suppose we have six sticks of the following lengths:
 * 
 * 5 4 4 2 2 8 Then, in one cut operation we make a cut of length 2 from each of
 * the six sticks. For the next cut operation four sticks are left (of non-zero
 * length), whose lengths are the following:
 * 
 * 3 2 2 6 The above step is repeated until no sticks are left.
 * 
 * Given the length of sticks, print the number of sticks that are left before
 * each subsequent cut operations.
 * 
 * Note: For each cut operation, you have to recalcuate the length of smallest
 * sticks (excluding zero-length sticks).
 * 
 * 
 * 
 * @author debmalyajash
 *
 */
public class CutTheStick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			List<Integer> stages = new ArrayList<Integer>();

			int arr[] = new int[n];
			int count = 0;
			int min = Integer.MAX_VALUE;
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
				if (arr[arr_i] < min) {
					min = arr[arr_i];
				}
				count++;
			}

			while (count > 0) {
				Arrays.sort(arr);
				System.out.println(Arrays.toString(arr));
				stages.add(count);
				boolean first = true;
				count = 0;
				int nextMin = 0;
				for (int arr_i = 0; arr_i < n; arr_i++) {
					arr[arr_i] -= min;
					if (arr[arr_i] > 0) {
						count++;
						if (first) {
							first = false;
							nextMin = arr[arr_i];
						}
					}
				}
				min = nextMin;
				
			}
			System.out.println(Arrays.toString(arr));
			for (Integer each : stages) {
				System.out.println(each);
			}
		}

	}

}
