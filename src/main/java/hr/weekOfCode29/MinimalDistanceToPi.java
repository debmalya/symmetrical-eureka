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
public class MinimalDistanceToPi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			long min = in.nextLong();
			long max = in.nextLong();

			double pi = 3.1415926535897932384626433832795028841971693993751;

			double minima = Double.MAX_VALUE;
			double currentMinima = 0.00;

			long numerator1 = 1;
			long numerator2 = 1;

			long answerNumerator = numerator1;
			long answerDenominator = Integer.MAX_VALUE;

			for (long d = min; d <= max; d++) {
				double firstDivision = (double) numerator1 / d;
				while (firstDivision < pi) {
					firstDivision = (double) (numerator1 + 1)/ d;
					if (firstDivision < pi) {
						numerator1++;
					}
				}
				numerator2 = numerator1 + 1;

				firstDivision = (double) numerator1 / d;
				double secondDivision = (double) numerator2 / d;
//				System.out.println(numerator1 + "/" + d + ", firstDivision :" + firstDivision + " <- -> " + numerator2
//						+ "/" + d + " , secondDivision : " + secondDivision);

				double first = Math.abs(pi - firstDivision);
				double second = Math.abs(pi - secondDivision);

				if (first < second) {
					currentMinima = first;
					if (currentMinima < minima) {
						minima = currentMinima;

						answerDenominator = d;
						answerNumerator = numerator1;

					}
				} else {
					currentMinima = second;
					if (currentMinima < minima) {
						minima = currentMinima;

						answerDenominator = d;
						answerNumerator = numerator2;

					}
				}

				numerator1 += 3;

			}

			System.out.println(answerNumerator + "/" + answerDenominator);
		}

	}

}
