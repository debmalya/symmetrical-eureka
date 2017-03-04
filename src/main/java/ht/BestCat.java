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
package ht;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class BestCat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// There can be maximum 1000 test cases.
			int noOfTestCases = in.nextInt();
			int[] results = new int[noOfTestCases];

			for (int i = 0; i < noOfTestCases; i++) {
				int cat1Age = in.nextInt();
				int cat1Pos = in.nextInt();
				int cat2Age = in.nextInt();
				int cat2Pos = in.nextInt();

				results[i] = getTheWinner(cat1Age, cat1Pos, cat2Age, cat2Pos);

			}

			for (int i = 0; i < noOfTestCases; i++) {
				System.out.println(results[i]);
			}
		}

	}

	/**
	 * @param cat1Pos
	 * @param cat1Age
	 * @param cat2Pos
	 * @param cat2Age
	 * @return
	 */
	public static int getTheWinner(int cat1Age, int cat1Pos, int cat2Age, int cat2Pos) {

		return 0;
	}

}
