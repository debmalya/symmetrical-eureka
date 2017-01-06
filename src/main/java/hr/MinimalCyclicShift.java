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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class MinimalCyclicShift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[] a = new int[n];
			Set<Integer> aSet = new HashSet<>();
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
				aSet.add(a[a_i]);
			}

			int[] b = new int[n];
			int[] diff = new int[n];
			Set<Integer> bSet = new HashSet<>();
			Set<Integer> diffSet = new HashSet<>();
			for (int b_i = 0; b_i < n; b_i++) {
				b[b_i] = in.nextInt();
				diff[b_i] = a[b_i] - b[b_i];
				diffSet.add(diff[b_i]);
				bSet.add(b[b_i]);
			}
			if (aSet.size() != bSet.size() && aSet.size() != diffSet.size()) {
				System.out.println("-1");
			} else {
				System.out.println(Arrays.toString(diff));
			}
		}

	}

	/**
	 * We consider two sequences of integers a, b to be similar if there exists
	 * a polynomial, P(x) with integer coefficient of a degree <= k. such that
	 * P(i) = (a(i) - b(i)) % m m = 998244353
	 * 
	 * @param a
	 *            sequence of integers.
	 * @param b
	 *            sequence of integers.
	 * @param k
	 *            degree of coefficient
	 * @return minimal integer x (0 <= x <= n) such that cyclic shift of b on x
	 *         elements ( b(x) modulus n, b(x+1) modulus n... b(x+n-1) modulus x
	 *         is similar to a).
	 * 
	 *         example a = 1 2 1 2 1 2 b = 4 3 4 3 4 3 k = 0 After a cyclic
	 *         shift of x = 1, sequence b is 3 4 3 4 3 4 and P(x) = -2 ( 1- 3 ,
	 *         2 -4) Answer is 1.
	 */
	public static int getMinimalCyclicShift(int[] a, int[] b, int k) {
		int m = 998244353;
		return -1;
	}

}
