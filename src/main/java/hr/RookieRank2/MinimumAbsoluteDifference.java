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
package hr.RookieRank2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MinimumAbsoluteDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains a single integer denoting n (the number
			// of integers).
			int n = in.nextInt();

			// The second line contains space-separated integers describing the
			// respective values of a[0],a[1],...a[n -1].
			long[] a = new long[n];

			for (int i = 0; i < n; i++) {
				a[i] = in.nextLong();
			}

			Arrays.sort(a);
			long min = Long.MAX_VALUE;
			for (int i = 1; i < n; i++) {
				long abs = Math.abs(a[i] - a[i -1]);
				if (abs < min) {
					min = abs;
				}
			}
			
			System.out.println(min);
		}

	}

}
