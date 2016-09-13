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
public class GearsOfWar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains single integer q, denoting the number of
			// queries.
			int q = in.nextInt();
			// Each line i of the q subsequent lines contains a single integer,
			// n, denoting the number of gears for that query.
			String[] r = new String[q];
			for (int i = 0; i < q; i++) {
				r[i] = in.nextInt() % 2 == 1 ? "No" : "Yes";
			}
			
			for (int i = 0; i < q; i++) {
				System.out.println(r[i]);
			}
		}

	}

}
