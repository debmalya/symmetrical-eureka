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

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MeanMedianMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			// Get the number of elements in array
			int n = scanner.nextInt();
			long[] nums = new long[n];

			double mean = 0.00;
			double median = 0.00;
			

			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
				mean += nums[i];
			}

			Arrays.sort(nums);
			mean /= n;
			System.out.println(String.format("%.1f", mean));

			// Median calculation
			int mid = n / 2;

			if (n % 2 == 1) {
				median = nums[mid];
			} else {
				median = (double)(nums[mid] + nums[mid - 1]) / 2;
			}
			System.out.println(String.format("%.1f", median));

			// Mode calculation (Most popular number)
			int popularityIndex = -1;
			int currentPopularityIndex = -1;
			long mode = nums[0];
			for (int i = 1; i < n; i++){
				if (nums[i -1] == nums[i]){
					if (currentPopularityIndex == -1) {
						currentPopularityIndex = 1;
					} 
					currentPopularityIndex++;
					if (currentPopularityIndex > popularityIndex){
						popularityIndex = currentPopularityIndex;
						mode = nums[i];
					}
				} else {
					currentPopularityIndex = -1;
				}
			}
			System.out.println(mode);
			
		}

	}

}
