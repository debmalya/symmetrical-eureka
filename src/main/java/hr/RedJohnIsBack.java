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
 * Story : There is a wall of size 4xN in the victim's house. The victim also
 * has an infinite supply of bricks of size 4x1 and 1x4 in her house. There is a
 * hidden safe which can only be opened by a particular configuration of bricks
 * in the wall. In every configuration, the wall has to be completely covered
 * using the bricks. There is a phone number written on a note in the safe which
 * is of utmost importance in the murder case. Gale Bertram wants to know the
 * total number of ways in which the bricks can be arranged on the wall so that
 * a new configuration arises every time.He calls it M. Since Red John is back
 * after a long time, he has also gained a masters degree in Mathematics from a
 * reputed university. So, he wants Patrick to calculate the number of prime
 * numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should
 * call Red John on the phone number from the safe and he will surrender if
 * Patrick tells him the correct answer. Otherwise, Teresa will get another
 * murder call after a week.
 * 
 * e.g. Sample Input: 2 1 7
 * 
 * Sample output: 0 3
 * 
 * For N = 1, the brick can be laid in 1 format only The number of primes <= 1
 * is 0 and hence the answer.
 * 
 * For N = 7, There are 5 ways of arranging the bricks for N = 7 and there are 3
 * primes <= 5 and hence the answer 3.
 * 
 * @author debmalyajash
 *
 */
public class RedJohnIsBack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Range 1<= t <= 20
			int t = in.nextInt();
			int[] arr = new int[t];

			for (int i = 0; i < t; i++) {
				// Range 1 <= N <= 40
				arr[i] = in.nextInt();
			}
		}

	}

}
