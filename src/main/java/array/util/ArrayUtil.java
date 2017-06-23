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
package array.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class ArrayUtil {

	
	/**
	 * Given an array a that contains only numbers in the range from 1 to
	 * a.length, find the first duplicate number for which the second occurrence
	 * has the minimal index. In other words, if there are more than 1
	 * duplicated numbers, return the number for which the second occurrence has
	 * a smaller index than the second occurrence of the other number does. If
	 * there are no such elements, return -1.
	 * 
	 * Example
	 * 
	 * For a = [2, 3, 3, 1, 5, 2], the output should be firstDuplicate(a) = 3.
	 * 
	 * There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a
	 * smaller index than than second occurrence of 2 does, so the answer is 3.
	 * 
	 * For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.integer a
	 * 
	 * Guaranteed constraints: 1 ≤ a.length ≤ 10**5, 1 ≤ a[i] ≤ a.length.
	 * 
	 * [output] integer
	 * 
	 * The element in a that occurs in the array more than once and has the
	 * minimal index for its second occurrence. If there are no such elements,
	 * return -1.
	 * 
	 * @param a - array of integer.
	 * @return - minimal index of the duplicate element
	 */
	public int firstDuplicate(int[] a) {
		int index = -1;
		Set<Integer> unique = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (!unique.add(a[i])) {
				index = a[i];
				break;
			}
		}
		return index;
	}

}
