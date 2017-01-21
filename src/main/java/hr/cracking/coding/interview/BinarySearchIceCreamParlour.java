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
public class BinarySearchIceCreamParlour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			String[] result = new String[t];

			for (int a0 = 0; a0 < t; a0++) {
				int m = in.nextInt();
				int n = in.nextInt();
				int a[] = new int[n];
				int z[] = new int[n];
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextInt();
//					z[a_i] = m - a[a_i];
				}

				for (int a_i = 0; a_i < n; a_i++) {
					for (int b_i = 0; b_i < n; b_i++){
						if (a_i != b_i) {
							if (a[a_i] + a[b_i] == m){
								result[a0] = (Math.min(a_i,b_i) + 1) + " " + (Math.max(a_i,b_i) + 1);
							}
						}
					}
				}

			}
			
			for (int a0 = 0; a0 < t; a0++) {
				System.out.println(result[a0]);
			}
		}

	}

}
