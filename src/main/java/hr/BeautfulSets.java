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
 * @author debmalyajash
 *
 */
public class BeautfulSets {

	/**
	 * Story: Consider a set,S , consisting of k integers. The set is beautiful
	 * if at least one of the following conditions hold true. for every x
	 * belongs to S. Condition 1: x - 1 belongs to S. Condition 2: x + 1 belongs
	 * to S.
	 * 
	 * For example, {1,2,50,51} is beautiful but {1,5,9} is not beautiful.
	 * 
	 * Task: Given two integers, n and k, can you find the number of different
	 * -element beautiful sets you can create using integers [1,n] ?
	 * 
	 * Perform q queries where each query i consists of some n(i) and k(i).
	 * 
	 * For each query: Find the number of different beautiful sets having
	 * exactly elements that can be generated using integers in the inclusive
	 * range from 1 to n.
	 * 
	 * Print the number of beautiful sets, modulo ,10**9 + 7 on a new line.
	 * 
	 * Constraints: 1 <= q <= 10 1 <= n <= 10**6 1 <= k <= n
	 * 
	 * @param args
	 */
	public static final int mod = 1000000007;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer,q , denoting the number of
			// queries.
			int q = in.nextInt();

			// Each line i of the q subsequent lines consists of two
			// space-separated
			// positive integers describing the respective values n(i) of k(i)
			// and for the
			// query.
			int[] n = new int[q];
			int[] k = new int[q];
			long[] answers = new long[q];
			for (int i = 0; i < q; i++) {
				n[i] = in.nextInt();
				k[i] = in.nextInt();
				answers[i] = getNumberOfBeautifulSets(n[i], k[i]);
			}

			for (int i = 0; i < q; i++) {
				System.out.println(answers[i]);
			}
		}

	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	public static long getNumberOfBeautifulSets(int n, int k) {
		int elements = n - 1;
		if (k == n) {
			return 1;
		} else if (k == 2) {
			return elements;
		} else {
			if (k % 2 == 0) {
				long i = 2;
				long result = 0;

				while (i <= k) {
					result += (elements - i);
					i++;
				}
				return (result % mod);
			} else {
				return (((n - k) + n % 2) % mod);
			}
		}

	}

}
