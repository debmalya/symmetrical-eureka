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

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class SmallRiskTrading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			DecimalFormat df = new DecimalFormat("#####.00");
			// the number of trades available
			int n = in.nextInt();
			// the maximum number of trades allowed
			int k = in.nextInt();

			// trade's potential profit
			float[] x = new float[n];
			// trade's potential loss (1 - p)
			float[] y = new float[n];
			// trade's probability of being profitable
			float[] p = new float[n];

			// n space-separated floating-point numbers
			for (int i = 0; i < n; i++) {
				p[i] = in.nextFloat();
			}

			// n space-separated floating-point numbers
			for (int i = 0; i < n; i++) {
				x[i] = in.nextFloat();
			}

			// n space-separated floating-point numbers
			for (int i = 0; i < n; i++) {
				y[i] = in.nextFloat();
			}

			// Print the maximum expected amount of money that can be made by
			// performing at most k of the n available trades. Scale your answer
			// to
			// exactly 2 decimal places (i.e., format).
			float maxProfit = getMaxProfit(n, k, x, y, p);
			System.out.println(df.format(maxProfit));

		}

	}

	/**
	 * Get maximum possible profit
	 * 
	 * @param n
	 *            - total number of available trades.
	 * @param k
	 *            - maximum number of trades allowed.
	 * @param x
	 *            - possible profit.
	 * @param y
	 *            - possible loss.
	 * @param p
	 *            - probability of profit.
	 * @return - maximum possible profit.
	 */
	public static float getMaxProfit(int n, int k, float[] x, float[] y, float[] p) {
		float[] profits = new float[n];
		for (int i = 0; i < n; i++) {
			profits[i] = x[i] * p[i] - y[i] * (1 - p[i]);
		}
		Arrays.sort(profits);
		float totalProfit = 0.00f;
		for (int i = n - 1; i > n - 1 - k; i--) {
			if (profits[i] > 0.00) {
				totalProfit += profits[i];
			}
		}
		return totalProfit;
	}

}
