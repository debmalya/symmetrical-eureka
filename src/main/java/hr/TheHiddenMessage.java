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
public class TheHiddenMessage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String t = in.nextLine();
			String p = in.nextLine();
			String[] values = p.split(" ");

			String message = "YES";
			int[] startingPosition = new int[values.length];
			int[] endPosition = new int[values.length];

			int matchCount = 0;
			int cost = 0;
			int lastEndPosition = 0;
			for (int i = 0; i < values.length; i++) {
				int position = t.indexOf(values[i], lastEndPosition);
				if (position > -1) {
					startingPosition[i] = position;
					endPosition[i] = position + values[i].length() - 1;
					if (i > 0) {
						// e.g. fare far and are, far ends at 2, are starts at 1
						// Here we have to introduce two new letters a and r.
						// How to calculate the additional letters.
						// far ends at 2. far has length 3.
						// are starts at 1.
						// endPosition[i - 1] - startPosition[i - 1] + 1 -> word
						// length
						if (endPosition[i - 1] > position) {
							int wordLength = endPosition[i - 1] - startingPosition[i - 1] + 1;
							cost +=startingPosition[i - 1] + wordLength - position;
						} else {
							cost += position - endPosition[i - 1] - 1;
						}
					} else {
						cost += position - lastEndPosition;
					}

					lastEndPosition = startingPosition[i] + 1;
					matchCount++;

				} else {
					startingPosition[i] = -1;
					endPosition[i] = -1;
					message = "NO";
				}
			}

			System.out.println(message);
			if (matchCount == 0) {
				System.out.println(0);
			} else {
				boolean partial = false;
				for (int i = 0; i < values.length; i++) {
					if (startingPosition[i] != -1 && endPosition[i] != -1) {
						System.out.print(values[i] + " " + startingPosition[i] + " " + endPosition[i] + " ");
					} else {
						partial = true;
					}
				}

				if (!partial) {
					// To introduce space between words.
					cost += values.length - 1;
				}
				System.out.println();
			}
			
			if ("NO".equals(message)){
				cost = 0;
			} else {
				cost += t.length() - endPosition[values.length - 1];
			}

			System.out.println(cost);
		}

	}

}
