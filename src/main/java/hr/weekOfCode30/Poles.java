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
package hr.weekOfCode30;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Poles {

	/**
	 * There are n telephone poles ascending a mountain and each pole has a
	 * weight and a unique altitude.Our program must move the poles into k
	 * number of stacks, but we can only rearrange the poles according to
	 * certain criteria:
	 * 
	 * 1. Poles can only be moved from higher altitudes to lower altitudes.
	 * 
	 * 2. Stacks can only be formed at the initial pole altitudes.
	 * 
	 * 3. A stack can consist of at least one pole.
	 * 
	 * Moving the poles down the mountain also costs money. Moving a pole with
	 * weight w and altitude x1 to an altitude x2 of where (x1 > x2) costs w *
	 * (x1 - x2) .
	 * 
	 * Determine the least amount of money needed to rearrange the poles into
	 * stacks.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line of input contains two integers n (the number of
			// poles) and k (the number of stacks needed).
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[] x = new int[n];
			int[] w = new int[n];

			// Each of the next n lines include two integers x(i) indicating the
			// i th pole's altitude and w(i)
			// indicating the ith pole's weight. The poles will always be listed
			// from lowest to highest altitude.
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
				w[i] = in.nextInt();
			}

			System.out.println(getMinimumCost(n,k,x,w));
		}

	}

	/**
	 * minimum cost of rearranging the poles into k stacks.
	 * @param n - number of poles.
	 * @param k - number of stacks.
	 * @param x - poles altitude.
	 * @param w - weight of pole.
	 * @return minimum cost.
	 */
	private static int getMinimumCost(int n, int k, int[] x, int[] w) {
		
		return 0;
	}

}
