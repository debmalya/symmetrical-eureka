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
package amazed;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class VyasaNWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int noOfFamilies = in.nextInt();
			String foodTypes = null;
			int[] sleepTypes = new int[noOfFamilies];

			foodTypes = in.next();
			String sleep = in.next();

			for (int i = 0; i < noOfFamilies; i++) {
				sleepTypes[i] = sleep.charAt(i) - '0';
			}

			int noOfQueries = in.nextInt();
			int[] result = new int[noOfQueries];
			for (int i = 0; i < noOfQueries; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				result[i] = getCombinations(l, r, foodTypes, sleepTypes);
			}

			for (int i = 0; i < noOfQueries; i++) {
				System.out.println(result[i]);
			}

		}

	}

	/**
	 * Now, there is a tradition in Byte land as per which any two families
	 * come-together and host a party for some other houses in the town. The
	 * party is considered Special if the two host families have either the same
	 * food type or the same sleep type, or both. Now, Vasya is a very curious
	 * girl, and she loves combinatorics too. She gives you some queries, where
	 * each query is of the form:
	 * 
	 * @param l
	 * @param r
	 * @param foodtypes
	 * @param sleepTypes
	 * @return
	 */
	public static int getCombinations(int l, int r, String foodtypes,
			int[] sleepTypes) {
		boolean[] similarities = new boolean[foodtypes.length()];
		
		Set<Character> s = new HashSet<Character>();
		for (int i = l -1; i < r; i++){
			
		}
		return 0;
	}
	
	
	public static int getCombinations0(int l, int r, String foodtypes,
			int[] sleepTypes) {
		int foodSimilarity = 0;
		int[] sleepSimilarity = new int[2];
		sleepSimilarity[0]--;
		sleepSimilarity[1]--;
		int mod = 1000000007;

		Set<Character> f = new HashSet<Character>();
		for (int i = l - 1; i < r; i++) {
			if (!f.add(foodtypes.charAt(i))) {
				foodSimilarity++;
			}
		}

		for (int i = l - 1; i < r; i++) {
			if (sleepTypes[i] == 0) {
				sleepSimilarity[0]++;
			} else {
				sleepSimilarity[1]++;
			}
		}

		if (foodSimilarity == 0) {
			return ((sleepSimilarity[1] == -1 ? 0 :sleepSimilarity[1]) + (sleepSimilarity[0] == -1 ? 0 : sleepSimilarity[0])) % mod;
		} else {
			return (foodSimilarity * sleepSimilarity[1]) % mod
					+ (foodSimilarity * sleepSimilarity[0]) % mod;
		}

	}

}
