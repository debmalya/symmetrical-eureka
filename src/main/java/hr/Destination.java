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
package hr;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Destination {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// A single line of three space-separated positive integers denoting
			// the respective values of n (the number of cities John plans to
			// visit), m (the number of cities Zizi plans to visit), and c (the
			// number of cities they both want to visit).
			String[] nmc = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nmc[0]);
			int m = Integer.parseInt(nmc[1]);
			int c = Integer.parseInt(nmc[2]);
			
			int j = n - c;
			int z = m - c;
			int a = j + z + c - 1;
			int r = 1;
			while (a > 1){
				r *= a;
				a--;
			}
			System.out.println(r);
			
		}
	}

}
