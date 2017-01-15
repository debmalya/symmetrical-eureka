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
public class Primality {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			String[] result = new String[n];
			for (int i = 0; i < n; i++) {
				result[i] = isPrime(in.nextLong()) ? "Prime" :"Not prime";
			}
			
			for (int i = 0; i < n; i++) {
				System.out.println(result[i]);
			}
		}

	}

	/**
	 * @param nextInt
	 * @return
	 */
	public static boolean isPrime(long nextInt) {
		if (nextInt == 1){
			return false;
		}
		int divisor = 2;
		for (; divisor <= Math.sqrt(nextInt); divisor++){
			if (nextInt%divisor == 0) {
				return false;
			}
		}
		return true;
	}

}
