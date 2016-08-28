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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Predicting time series. Given the web traffic data for a particular website,
 * which is measured in terms of user sessions. You are provided with the number
 * of sessions for a time series of 1133 consecutive days starting from October
 * 1, 2012.
 * 
 * Task is to predict the number of sessions for the next days.
 * 
 * @author debmalyajash
 *
 */
public class TimeSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first row contains integer, N.
			int n = in.nextInt();

			// Each of the n subsequent lines contains an integer denoting the
			// number of user sessions for day i. 1<= i <= n.
			int[] sessions = new int[n];
			for (int i = 0; i < n; i++) {
				sessions[i] = in.nextInt();
			}
			
			int[] p = periodiCyclesInData(sessions);
			
			LocalDate dateAtFirstDate = LocalDate.of(2015, 11, 12);
			DayOfWeek dayOfWeek = dateAtFirstDate.getDayOfWeek();
			int dayIndex = dayOfWeek.getValue();
			int[] r = new int[30];
			for (int i = 0; i< 30; i++){
				r[i] = p[dayIndex % 7];
				dayIndex++;
				System.out.println(r[i]);
			}
		}
	}

	/**
	 * Periodic Cycles in the Data .
	 * 
	 * Think in terms of periodicity of the waveform of the data. There are two
	 * cycles. The first one is the cycle over the week. It is generally a hump,
	 * lowest on the weekends, and reaching a peak on Tuesday or Wednesday.
	 * 
	 * @param sessions
	 * @return
	 */
	public static int[] periodiCyclesInData(int[] sessions) {
		int[] p = new int[7];
		int[] c = new int[7];
//		First date is October 1st 2012.
//		which day it is ?
		LocalDate dateAtFirstDate = LocalDate.of(2012, 10, 1);
		DayOfWeek dayOfWeek = dateAtFirstDate.getDayOfWeek();
		int dayIndex = dayOfWeek.getValue();
		for (int i = 0; i < sessions.length; i++) {
			p[dayIndex % 7] += sessions[i];
			c[dayIndex % 7]++;
			dayIndex++;
		}
		
		for (int i = 0; i <7; i++){
			p[i] /= c[i];
		}
		return p;
	}
}
