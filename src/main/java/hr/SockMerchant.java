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

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class SockMerchant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int c[] = new int[n];
			for (int c_i = 0; c_i < n; c_i++) {
				c[c_i] = in.nextInt();
			}

			System.out.println(getSockCount(n, c));
		}

	}

	/**
	 * @param n
	 * @param c
	 */
	public static int getSockCount(int n, int[] c) {
		Arrays.sort(c);
		int count = 0;
		for (int c_i = 1; c_i < n; ) {
			if (c[c_i - 1] == c[c_i]) {
				count++;
				c_i += 2;
			}else {
				c_i += 1;
			}
		}
		return count;
	}

}
