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
package hr.hourrank23;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Halloween {

	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy
		int c = 0;

		if (s >= p) {
			while (s >= m) {
				s -= p;
				if (p - d >= m) {
					p -= d;
				} else {
					p = m;
				}
				if (s > -1) {
					c++;
				}
			}
		}
		return c;

	}

	static int howManyGames0(int p, int d, int m, int s) {
		// Return the number of games you can buy
		int c = 0;
		int fp = p;
		while (s >= m) {
			if (p == fp) {
				s -= p;
				p -= d;

			} else if (p > m) {
				s -= p;
				p -= d;

			} else {
				s -= m;
			}
			c++;
		}
		return c;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int d = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		int answer = howManyGames(p, d, m, s);
		System.out.println(answer);
		in.close();

	}

}
