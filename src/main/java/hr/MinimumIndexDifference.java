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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MinimumIndexDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int minDiff = Integer.MAX_VALUE;
			int minNum = Integer.MAX_VALUE;
			int n = in.nextInt();
			int[] arr = new int[n];

			Map<Integer, Integer> mapIndex1 = new HashMap<>();

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				mapIndex1.put(arr[i], i);
			}

			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int diff = Math.abs(mapIndex1.get(a) - i);

				if (diff < minDiff) {
					minDiff = diff;
					minNum = a;
				} else if (diff == minDiff && a < minNum){
					minNum =a;
				}
			}
			System.out.println(minNum);
		}

	}

	/**
	 * @param args
	 */
	public static void main0(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int[] arr1 = new int[n];

			Map<Integer, Integer> mapIndex1 = new HashMap<>();
			Map<Integer, Integer> mapIndex2 = new HashMap<>();

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				mapIndex1.put(arr[i], i);
			}

			for (int i = 0; i < n; i++) {
				arr1[i] = in.nextInt();
				mapIndex2.put(arr1[i], i);
			}

			int minDiff = Integer.MAX_VALUE;
			int minNum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int diff = Math.abs(mapIndex1.get(arr[i]) - mapIndex2.get(arr[i]));
				if (diff <= minDiff) {
					minDiff = diff;
					if (minNum > arr[i]) {
						minNum = arr[i];
					}

				}
			}

			System.out.println(minNum);
		}

	}

}
