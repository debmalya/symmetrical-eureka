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
package ht;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Stacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			int[] r = new int[t];

			for (int j = 0; j < t; j++) {
				int n = in.nextInt();
				int[] s = new int[n];
				int sum = 0;
				int g = 0;
				for (int i = 0; i < n; i++) {
					s[i] = in.nextInt();
					sum += s[i];
					if (s[i] > 1){
						g++;
					}
				}
				r[j] = getWinner(s);
			}

			// Results
			for (int i = 0; i < t; i++) {
				System.out.println(r[i]);
			}

		} catch (Exception e) {
		}

	}

	/**
	 * @param s
	 * @return
	 */
	public static int getWinner(int[] s) {
		int r = s.length;
		int c = 0;

		System.out.println("===========================");
		System.out.println("Original : " + Arrays.toString(s));
		while (r > 0) {
			// till there is any stack.
			Arrays.sort(s);

			if (r % 2 == 1) {
				//
				s[s.length - 1] = 0;
				c++;
				r--;
			} else if (s[s.length - 1] > 1) {
				s[s.length - 1] = 1;
				c++;
			} else {
				s[s.length - 1] = 0;
				r--;
				c++;
			}
			System.out.println(c + ") Conversion : " + Arrays.toString(s));
		}

		return c % 2 == 1 ? 1 : 2;
	}

	/**
	 * @param s
	 * @return
	 */
	public static int getWinner1(int[] s) {
		int r = s.length;
		int c = 0;

		System.out.println("===========================");
		System.out.println("Original : " + Arrays.toString(s));
		while (r > 0) {
			// till there is any stack.
			Arrays.sort(s);
			if (c % 2 == 0) {
				// First player perspective
				if (r % 2 == 1) {
					//
					s[s.length - 1] = 0;
					c++;
					r--;
				} else if (s[s.length - 1] > 1) {
					s[s.length - 1] = 1;
					c++;
				} else {
					s[s.length - 1] = 0;
					r--;
					c++;
				}
				System.out.println(c + ") Conversion : " + Arrays.toString(s));
			} else {
				// Second player perspective
				if (r % 2 == 0) {
					//
					s[s.length - 1] = 0;
					c++;
					r--;
				} else if (s[s.length - 1] > 1) {
					s[s.length - 1] = 1;
					c++;
				} else {
					s[s.length - 1] = 0;
					r--;
					c++;
				}
				System.out.println(c + ") Conversion : " + Arrays.toString(s));
			}
		}

		return c % 2 == 1 ? 1 : 2;
	}

}
