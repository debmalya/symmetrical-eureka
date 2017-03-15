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
package hr.weekOfCode30;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class CandyReplenshingRobot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int t = in.nextInt();
			int[] c = new int[t];
			for (int i = 0; i < t; i++) {
				c[i] = in.nextInt();
			}

			int answer = getCandiesToAdd(n, t, c);
			System.out.println(answer);
		}

	}

	/**
	 * Party lasts for t minutes. There is a bowl of n candies. If the party is
	 * ending (i.e., it's time t), do not refill the bowl. If the bowl contains
	 * b(i) candies at the end of minute i and b(i) < 5 , add n - b(i) candies
	 * to the bowl.
	 * 
	 * 
	 * @param n
	 *            - number of candies at the beginning of the party.
	 * @param t
	 *            - party lasts for t minutes. (1<= t <= 100).
	 * @param c
	 *            - candies removed in each second. (1 <= c <= n).
	 * @return total number of new candies added during party.
	 */
	public static int getCandiesToAdd(int n, int t, int[] c) {
		int refillAmount = 0;
		int fullAmount = n;
		for (int i = 0; i < t - 1; i++) {
			n -= c[i];
			if (n < 5) {
				refillAmount += (fullAmount - n);
				n = fullAmount;
			}
		}
		return refillAmount;
	}

}
