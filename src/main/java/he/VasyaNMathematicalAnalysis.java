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

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class VasyaNMathematicalAnalysis {

	private static Map<Long, Long> valueMap = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			long[] arr = new long[n];

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextLong();
			}

			int t = in.nextInt();
			long[] results = new long[t];
			for (int i = 0; i < t; i++) {
				int l = in.nextInt() - 1;
				int r = in.nextInt() - 1;
				results[i] = q(arr, l, r);

			}

			for (int i = 0; i < t; i++) {
				System.out.println(results[i]);
			}
		}

	}

	/**
	 * @param arr
	 * @param modulo
	 * @param results
	 * @param i
	 * @param l
	 * @param r
	 */
	public static long q(long[] arr, int l, int r) {
		int modulo = 1000000007;
		long result = 1;
		for (int j = l; j <= r; j++) {
			Long value = valueMap.get(arr[j]);
			if (value != null) {
				result *= value % modulo;
			} else {
				value = f(arr[j]);
				result *= value % modulo;
				valueMap.put(arr[j], value);
			}
		}
		return result;
	}

	
	public static long f(long n) {
		long start = n >> 1;
		
		for (int i = 2; i <= start; i++ ){
			long divisor = 0;
			while (n % i == 0){
				divisor += i;
				n /= i;
			}
		}
		
		return 1;
	}
	public static long f0(long n) {
		long start = n >> 1;
		
		for (long i = start; i > 0; i--) {
			if (n % i == 0) {
				return i;
			}
		}
		return 1;
	}

}
