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
package hr.machine.learning;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class ForecastingPassengerTraffic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer, n, denoting the number of
			// months of passenger data.
			int n = in.nextInt();
			// The subsequent n lines each contain the monthly passenger counts
			// in
			// the form of 2 tab-separated values:
			// The first value is MonthNum_X, where X is an an integer denoting
			// the month number.

			// The second value is an integer denoting the number of passengers
			// for that month.
			int[] monthlyPassengers = new int[12];
			int[] monthCount = new int[12];
			
			for (int i = 0; i < n; i++) {
				String month = in.next();
				int MonthNum_X = Integer.parseInt(month.replace("MonthNum_", "")) % 12;
				monthCount[MonthNum_X]++;
				monthlyPassengers[MonthNum_X] = in.nextInt();
				
			}
		}

	}

}
