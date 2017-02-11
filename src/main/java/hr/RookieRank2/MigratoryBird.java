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
package hr.RookieRank2;

import java.util.Scanner;

/**
 * @author debmalyajash
 * 
 *         User Story : A flock of n birds is flying across the continent. Each
 *         bird has a type, and the different types are designated by the ID
 *         numbers 1, 2, 3, 4, and 5.
 * 
 *         Given an array of n integers where each integer describes the type of
 *         a bird in the flock, find and print the type number of the most
 *         common bird. If two or more types of birds are equally common, choose
 *         the type with the smallest ID number.
 *
 */
public class MigratoryBird {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer denoting n (the number of
			// birds).
			int n = in.nextInt();

			// The second line contains n space-separated integers describing
			// the
			// respective type numbers of each bird in the flock.
			int[] types = new int[n];

			// It is guaranteed that each type is 1, 2, 3, 4, or 5.
			int[] counts = new int[5];
			int maxCount = Integer.MIN_VALUE;
			int maxType = 0;
			for (int i = 0; i < n; i++) {
				types[i] = in.nextInt();
				counts[types[i] - 1]++;
				if (maxCount < counts[types[i] - 1]) {
					maxCount = counts[types[i] - 1];
					maxType = types[i];
				} else if (maxCount == counts[types[i] - 1] && types[i] < maxType) {
					maxType = types[i];
				}
			}
			
			System.out.println(maxType);
		}

	}

}
