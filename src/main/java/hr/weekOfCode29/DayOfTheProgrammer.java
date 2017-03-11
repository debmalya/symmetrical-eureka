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
package hr.weekOfCode29;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class DayOfTheProgrammer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int year = in.nextInt();
			System.out.println(getProgrammersDay(year));
		}

	}

	/**
	 * Russia on the Day of the Programmer (the 256th day of the year) during a
	 * year in the inclusive range 1700 from to 2700. From 1700 to 1917,
	 * Russia's official calendar was the Julian calendar; since 1919 they used
	 * the Gregorian calendar system. The transition from the Julian to
	 * Gregorian calendar system occurred in 1918, when the next day after
	 * January 31st was February 14th. This means that in 1918, February 14th
	 * was the day 32nd of the year in Russia.
	 * 
	 * In both calendar systems, February is the only month with a variable
	 * amount of days; it has 29 days during a leap year, and days during all
	 * other years. In the Julian calendar, leap years are divisible by ; in the
	 * Gregorian calendar, leap years are either of the following:
	 * 
	 * @param year
	 *            to be checked for programmers day.
	 */
	public static String getProgrammersDay(int year) {
		String programmerDay = "";
		if (year < 1918) {
			if (year % 4 == 0) {
				programmerDay = "12.09." + year;
			} else {
				programmerDay = "13.09." + year;
			}
		}  else if (year != 1918) {
			if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
				programmerDay = "12.09." + year;
			} else {
				programmerDay = "13.09." + year;
			}
		} else {
			programmerDay = "26.09." + year;
		}
		return programmerDay;
	}

}
