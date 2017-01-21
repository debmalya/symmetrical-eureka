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
public class DPCoinChange {

	/**
	 * Story: Given a number of dollars,n , and a list of dollar values for m
	 * distinct coins, c = {c0,c1,...,cM-1}, find and print the number of
	 * different ways you can make change for dollars if each coin is available
	 * in an infinite quantity.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();
			int coins[] = new int[m];
			for (int coins_i = 0; coins_i < m; coins_i++) {
				coins[coins_i] = in.nextInt();
			}

			System.out.println(coinChange(n, m, coins));
		}

	}

	/**
	 * @param n
	 *            dollar value for which we are looking for changes.
	 * @param m
	 *            total number of coins.
	 * @param coins
	 *            of all denominations.
	 * @return smallest possible usage of change.
	 */
	public static long coinChange(int n, int m, int[] coins) {
		//
		long[] DP = new long[n + 1];
		DP[0] = 1;
		for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
			int coin = coins[coinIndex];
			for (int j = coin; j < DP.length; j++) {
				// The only tricky step. How many combination possible with this coin ?
				DP[j] += DP[j - coin];
			}
		}
		return DP[n];

	}

}
