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

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class PickingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}

			pickedNumbers(a);
		}

	}

	/**
	 * @param a
	 */
	public static int pickedNumbers(int[] a) {
		Arrays.sort(a);

		int m = 0;
		int max = 0;
		for (int i = 0, j = i + 1; j < a.length; i++, j++) {
			if (a[j] - a[i] <= 1) {

				while (i > -1 && a[j] - a[i] <= 1) {
					j++;
					if (j == a.length) {
						break;
					}
				}

				m = j - i;
				if (m > max) {
					max = m;
				}

				j = i + 1;
			}
		}
		System.out.println(max);
		return max;
	}

	/**
	 * @param a
	 */
	public static int pickedNumbers0(int[] a) {
		Arrays.sort(a);

		int m = 0;
		int max = 0;
		for (int i = 0, j = a.length - 1; i < j; i++, j--) {
			if (a[j] - a[i] <= 1) {
				int prev_i = i;
				while (i > -1 && a[j] - a[i] <= 1) {
					i--;
				}

				m = j - i;
				if (m > max) {
					max = m;
				}
				i = prev_i;
				j = a.length - 1;
			}
		}
		System.out.println(max);
		return max;
	}

	public static long getFirstUsageOfDay(long firstUsage, long recordTimeStamp) {
		return (recordTimeStamp / 86400000 - firstUsage / 86400000 > 0) ? recordTimeStamp : firstUsage;
	}
}
