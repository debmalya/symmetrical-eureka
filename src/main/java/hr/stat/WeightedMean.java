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
package hr.stat;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class WeightedMean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			int n = scanner.nextInt();
			int[] nums = new int[n];
			int[] weights = new int[n];
			double sum = 0.00;
			
			for (int i = 0; i < n; i++){
				nums[i] = scanner.nextInt();
			}
			
			int total = 0;
			for (int i = 0; i < n; i++){
				weights[i] = scanner.nextInt();
				sum += (nums[i] * weights[i]);
				total += weights[i];
			}
			
			System.out.println(String.format("%.1f", (sum/total)));
		}

	}

}
