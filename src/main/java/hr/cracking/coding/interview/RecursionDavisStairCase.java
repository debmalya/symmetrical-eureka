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
package hr.cracking.coding.interview;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RecursionDavisStairCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Number of stair cases in the house.
			int s = in.nextInt();
			int[] result = new int[s];
			for (int a0 = 0; a0 < s; a0++) {
				int n = in.nextInt();
				result[a0] = getNumberOfWays(n);
			}
			
			for (int a0 = 0; a0 < s; a0++) {
				System.out.println(result[a0]);
			}

		}

	}

	/**
	 * At time user can climb 1, 2 or 3 steps. How many ways they can reach n
	 * stairs?
	 * 
	 * @param n
	 *            number of stairs.
	 * @return number of ways user can reach n
	 */
	public static int getNumberOfWays(int n) {

		int[] answer = new int[n];

		// number of step 1, at time can take one step only.
		if (answer.length > 0) {
			answer[0] = 1;
		}

		// number of step 2, at time can take 2 step or 1+1.f
		if (answer.length > 1) {
			answer[1] = 2;
		}

		// number of steps 3, 1+1+1,2+1,1+2,3
		if (answer.length > 2) {
			answer[2] = 4;
		}

		for (int i = 3; i < n; i++) {
			answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
		}

		return answer[n - 1];
	}

}
