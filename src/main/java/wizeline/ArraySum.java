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
package wizeline;

import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class ArraySum {
	/**
	 * Two arrays represents two number. (e.g. 99 and 98 array1[0] = 9 array1[1]
	 * = 9
	 * 
	 * array2[0] = 9 array2[1] = 8
	 * 
	 * Have to sum this two array and return the result.
	 * 
	 * @param array1
	 *            - array to represent first integer.
	 * @param array2
	 *            - array to represent second integer.
	 * 
	 * 
	 * @return sum of the two number as an array.
	 * 
	 */
	public int[] sum(int[] array1, int[] array2) {
		Stack<Integer> result = new Stack<>();
		int i = 0;
		boolean carry = false;
		int r = 0;
		for (i = 0; i < array1.length || i < array2.length; i++) {
			r = 0;
			if (i < array1.length && i < array2.length) {
				

				if (carry) {
					r = result.pop();
				}
				r += array1[array1.length - 1 - i] + array2[array2.length - 1 - i];
				if (r > 9) {
					carry = true;
				} else {
					carry = false;
				}
				result.push(r % 10);
				if (carry) {
					result.push(r / 10);
				}

			} else if (i < array1.length) {
				if (carry) {
					r = result.pop();
				}
				result.push(r + array1[array1.length - 1 - i]);
			} else if (i < array2.length) {
				if (carry) {
					r = result.pop();
				}
				result.push(r + array2[array2.length - 1 - i]);
			}

		}
		Integer[] ri = result.toArray(new Integer[0]);
		int[] arr = new int[ri.length];

		for (i = ri.length - 1; i > -1; i--) {
			arr[ri.length - 1 - i] = ri[i];
		}
		return arr;

	}
}
