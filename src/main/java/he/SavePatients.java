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
 * @author debmalyajash
 *
 */
public class SavePatients {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// First line contains the number of vaccines - N
			int N = in.nextInt();

			// Second line contains N integers, which are strength of vaccines
			int[] vaccines = new int[N];
			int maxVaccines = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				vaccines[i] = in.nextInt();
				maxVaccines= Math.max(maxVaccines, vaccines[i]);
			}

			// Third line contains N integers, which are midichlorians count of
			// patients.
			int[] midichlorians = new int[N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				midichlorians[i] = in.nextInt();
				max = Math.max(max, midichlorians[i]);
			}

			System.out.println(max > maxVaccines ? "No"  : "YES");
		}

	}

}
