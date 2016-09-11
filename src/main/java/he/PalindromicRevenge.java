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
package he;

import java.util.Scanner;

/**
 * change all the names into palindrome and will follow these rules:
 * 
 * -We can only lower the values of alphabets e.g,. we can replace the letter c
 * from b, q from p. But cannot replace b b from c c or p p from q q.
 * 
 * We can repeatedly lower any alphabet until it becomes ‘a’, after letter
 * becomes ‘a’ we cannot lower it anymore.
 * 
 * Suppose each change i.e,. reduction costs 1 1 unit so how many minimum units
 * would be required to convert whole name into palindrome.
 * 
 * @author debmalyajash
 *
 */
public class PalindromicRevenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains an integer T
			int T = in.nextInt();
			in.nextLine();
			
			String[] inputs = new String[T];
			int[] cost = new int[T];
			for (int i = 0;i < T; i++){
				inputs[i] = in.nextLine();
				cost[i] = getPallindromicCost(inputs[i]);
			}
			
			for (int i = 0; i <T; i++) {
				System.out.println(cost[i]);
			}
		}
	}

	/**
	 * @param input
	 * @return the cost to make it pallindrome.
	 */
	public static int getPallindromicCost(String input) {
		int size = input.length();
		int mid = size / 2;
		
		char[] inputC = input.toCharArray();
		int cost = 0;
		for (int i = 0; i < mid; i++){
				cost += Math.abs(inputC[i] - inputC[size - i - 1] );
		}
		return cost;
	}

}
