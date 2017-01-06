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

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class MicroNOptimusPrime {
	
	static long totalNumberOfDivisors = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			int modulo = 1000000007;
			for (int i = 0; i < t; i++) {
				long n = in.nextLong();
				totalNumberOfDivisors = 0;
				getPrimeFactors(n);
			}
		}

	}

	public static boolean isOptimusPrime(long l){
		Set<Long> primeList = getPrimeFactors(l);
		
		return false;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static Set<Long> getPrimeFactors(long n) {
		Set<Long> primeSet = new HashSet<>();
		long n1 = n;
		while (n > 1) {
			int limit = (int) Math.sqrt(n);
			for (long i = 2; i < limit; i++) {
				while (n % i == 0) {
					if (primeSet.add(i)){
						// new prime factor
					}
					n /= i;
					totalNumberOfDivisors++;
				}
			}
			
			if (n == n1){
				primeSet.add(n);
				break;
			}
		}
		return primeSet;
	}
}
