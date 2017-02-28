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
package hr.weekOfCode29;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MegaPrime {
	
	static BitSet primes;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			long first = in.nextLong();
			long last = in.nextLong();

			System.out.println(getNumberOfMegaPrimes(first, last));
		}

	}

	/**
	 * Get number of mega primes.
	 * 
	 * @param first
	 *            starting from.
	 * @param last
	 *            upto this.
	 */
	public static int getNumberOfMegaPrimes(long first, long last) {
		int count = 0;

		long num = first;
		while (num < last) {
			if (isAllDigitsPrime(num)) {
				if (isPrime(num)) {
					count++;
				}
			}
			num++;
		}

		return count;

	}

	

	/**
	 * This method will check whether all the single digits of number are prime
	 * are not.
	 * 
	 * @param num
	 *            to be checked.
	 * @return true if all the single digits are prime, false otherwise.
	 */
	public static boolean isAllDigitsPrime(final long num) {

		long value = num;
		while (value > 0) {
			long r = value % 10;
			if (r != 2 && r != 3 && r != 5 && r != 7) {
				return false;
			}
			value /= 10;
		}

		return true;
	}

	private static boolean isPrime(long num) {
		if (num == 2 || num == 3) {
			return true;
		}

		if (num % 2 == 0) {
			return false;
		}

		if (num % 3 == 0) {
			return false;
		}

		long i = 5;
		long w = 2;
		
		while (i * i <= num) {
			if (num % i == 0) {
				return false;
			}
			i += w;
			// alternatively value of w will be 2 and 4
			// i += w will be like 5 + 2 = 7 , 7 + 4 = 11, 11 + 2 = 13, 13 + 4 =
			// 17, 17 + 2 = 19, 19 + 4 = 23 and so on.
			w = 6 - w;
		}
		return true;
	}
	
	/**
	 * @param num
	 *            to be checked for prime.
	 * @return true if number is prime, false otherwise.
	 */

	private static boolean isPrime1(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	    	// checking by multiple of 5 and multiple of 7.
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}

}
