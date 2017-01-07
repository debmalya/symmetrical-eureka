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
public class StandardDeviation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			int[] arr = new int[n];
			double mean = 0;
			for  (int i = 0; i < n; i++){
				arr[i] = in.nextInt();
				mean += arr[i];
				
			}
			
			mean /= n;
			double standardDeviation = 0;
			for  (int i = 0; i < n; i++){
				standardDeviation += (mean - arr[i]) * (mean - arr[i]);
			}
			standardDeviation /= n;
			standardDeviation = Math.sqrt(standardDeviation);
			System.out.println(String.format("%.1f", standardDeviation));
			
		}

	}

	/**
	 * @param arr
	 * @return
	 */
	public static double getMean(int[] arr) {
		
		return 0;
	}

}
