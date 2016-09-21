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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * You will be given a fragment of text.
 * 
 * In this fragment, you need to identify the articles used (i.e., 'a', 'an',
 * 'the').
 * 
 * And you also need to identify dates (which might be expressed in a variety of
 * ways such as '15/11/2012','15/11/12', '15th March 1999','15th March 99' or
 * '20th of March, 1999').
 * 
 * assumptions 1) In the date, year and day will always be in numeric form.
 * Which means, you don't have to worry about "fifteenth" or "twentieth" etc.
 * Month, could be either numeric form (1-12) or with its name
 * (January-December, Jan-Dec).
 * 
 * @author debmalyajash
 *
 */
public class ATextProcessingWarmup {

	static String[] articles = new String[] { " a ", " an ", " the " };
	static String[] articlesC = new String[] { "A ", "An ", "The " };
	static String[] months = new String[] { " January ", " February ", " March ", " April ", " May ", " June ",
			" July ", " August ", " September ", " October ", " November ", " December " };
	static String[] monthsWithComma = new String[] { " January, ", " February, ", " March, ", " April, ", " May, ",
			" June, ", " July, ", " August, ", " September, ", " October, ", " November, ", " December, " };
	static String[] months3 = new String[] { " Jan ", " Feb ", " Mar ", " Apr ", " May ", " Jun ", " Jul ", " Aug ",
			" Sep ", " Oct ", " Nov ", " Dec " };
	static String[] monthsWithComma3 = new String[] { " Jan, ", " Feb, ", " Mar, ", " Apr, ", " May, ", " Jun, ",
			" Jul, ", " Aug, ", " Sep, ", " Oct, ", " Nov, ", " Dec, " };

	Pattern ddmmYYYYPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
	Pattern ddmmYYPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// First line contains number of test cases.
			int T = Integer.parseInt(in.nextLine());
			
			List<int[]> resultList = new ArrayList<>();
			for (int i = 0; i < T; i++) {

				String eachLine = in.nextLine();
				int[] result = analyze(eachLine);
				resultList.add(result);

				in.nextLine();

			}

			for (int i = 0; i < resultList.size(); i++) {
				int[] eachResult = resultList.get(i);
				for (int j = 0; j < eachResult.length; j++) {
					System.out.println(eachResult[j]);
				}
			}
		}

	}

	/**
	 * @param nextLine
	 * @return result - first element number of 'a'. Second element number of
	 *         'an'. Third element number of 'the', fourth element number of
	 *         dates.
	 * 
	 */
	public static int[] analyze(String nextLine) {
		int[] result = new int[4];

		getNumberOfOccurences(nextLine, result, articles);
		getNumberOfOccurences(nextLine, result, articlesC);
		nextLine = getNumberOfDates(nextLine, result, months);
		nextLine = getNumberOfDates(nextLine, result, months3);
		nextLine = getNumberOfDates(nextLine, result, monthsWithComma);
		nextLine = getNumberOfDates(nextLine, result, monthsWithComma3);

		return result;

	}

	/**
	 * @param nextLine
	 * @param result
	 */
	public static void getNumberOfOccurences(String nextLine, int[] result, String[] searchString) {
		int formIndex = 0;
		for (int i = 0; i < searchString.length; i++) {
			formIndex = 0;
			while (formIndex > -1) {
				formIndex = nextLine.indexOf(searchString[i], formIndex);
				if (formIndex > -1) {
					result[i]++;
					formIndex++;
				}
			}
		}
	}

	/**
	 * @param nextLine
	 * @param result
	 */
	public static String getNumberOfDates(String nextLine, int[] result, String[] searchString) {
		int formIndex = 0;
		for (int i = 0; i < searchString.length; i++) {
			formIndex = 0;
			while (formIndex > -1) {
				formIndex = nextLine.indexOf(searchString[i], formIndex);
				if (formIndex > -1) {
					result[3]++;
					formIndex += searchString[i].length() + 1;
				}
			}
			nextLine = nextLine.replace(searchString[i], "");
		}
		return nextLine;
	}

}
