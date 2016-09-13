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

import java.util.Arrays;
import java.util.Scanner;

/**
 * We are given the maximum lifting capacity of the crane, and the weight of
 * each stone. Since it's a mini crane, we cannot place more then 2 stones (of
 * any possible size) at a time, or it will disturb the balance of the crane. we
 * need to find out in how many turns we can deliver the stones to Phineas, who
 * is building the castle.
 * 
 * @author debmalyajash
 *
 */
public class CastleStone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// First line of input gives T, the number of test cases.
			int T = in.nextInt();
			int[] r = new int[T];
			for (int i = 0; i < T; i++) {
				// first line gives M, the maximum lifting capacity of the crane
				int M = in.nextInt();
				
				int N = in.nextInt();
				// first integer N of next line of each test case gives the
				// number of stones
				
				int[] weights = new int[N];
				int[] compliments = new int[N];
				for (int a = 0; a < N; a++){
					weights[a] = in.nextInt();
					compliments[a] = M - weights[a];
				}
				
				r[i] = getNumberOfTurns(M,weights,compliments);
			}
		}

	}

	/**
	 * @param craneCapacity
	 * @param weights
	 * @param compliments 
	 * @return
	 */
	private static int getNumberOfTurns(int craneCapacity, int[] weights, int[] compliments) {
		
		int c = 0;
		
		return c;
	}

}
