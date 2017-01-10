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
package hr.weekofcode28;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GreatXOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int q = in.nextInt();
			long[] result = new long[q];
			for (int a0 = 0; a0 < q; a0++) {
				long x = in.nextLong();
				result[a0] = getHigherXOR(x);
			}

			for (int a0 = 0; a0 < q; a0++) {
				System.out.println(result[a0]);
			}
		}

	}

	/**
	 * @param x
	 */
	public static long getHigherXOR(long x) {
		long result = 0;
		String value = Long.toBinaryString(x);
		// Get the position where it has '1'.
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '1') {
				int position = value.length() - i;
				
				// Count the possible numbers less than x starting with '1' at this position.
				
				
				
				if (position == value.length() ) {
					long number = 1;
					while (position > 1){
						number *=  2;
						position--;
					}
					
					result += x - number + 1; 
				} else {
					result += (position - 1) * 2;
				}
			}
		}
		return result;
	}

}
