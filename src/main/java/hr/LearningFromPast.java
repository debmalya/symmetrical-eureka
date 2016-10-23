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
 * Can make 2 of the 3 available trades on any given day. Have a list of
 * potential profits for the three trades available for each of the past n days,
 * and want to know what the maximum possible profit for any of these days
 * would've been so they can make better trade decisions in the future.
 * 
 * @author debmalyajash
 *
 */
public class LearningFromPast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Number of days
			int n = in.nextInt();
			
			int[][] dayTrading = new int[n][3];
			for (int i = 0; i < n; i++){
				dayTrading[i][0] = in.nextInt();
				dayTrading[i][1] = in.nextInt();
				dayTrading[i][2] = in.nextInt();
			}
			
			int maxProfit = getMaxProfit(dayTrading);
			System.out.println(maxProfit);
		}

	}

	/**
	 * @param dayTrading
	 * @return
	 */
	public static int getMaxProfit(int[][] dayTrading) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dayTrading.length; i++) {
			Arrays.sort(dayTrading[i]);
			max = Math.max(max, dayTrading[i][2]+dayTrading[i][1]);
		}
		return max;
	}

	
}
