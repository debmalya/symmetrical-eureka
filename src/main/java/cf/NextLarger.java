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
package cf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class NextLarger {

	/**
	 * Given an array a composed of distinct elements, find the next larger
	 * element for each element of the array in the order in which they appear
	 * in the array, and return the results as a new array of the same length.
	 * If an element does not have a larger element to its right, put -1 in the
	 * appropriate cell of the result array.
	 * 
	 * 
	 * 
	 * @param a
	 *            array of integers.
	 * @return
	 */
	int[] nextLarger(int[] a) {
		int[] r = new int[a.length];
		r[a.length - 1] = -1;
		for (int i = 0; i < a.length -1; i++) {
			r[i] = -1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[i]) {
					r[i] = a[j];
					break;
				}
			}
		}
		return r;
	}
	int[] nextLarger0(int[] a) {
		int[] r = new int[a.length];
		r[a.length - 1] = -1;
		int nextLarger = a[a.length - 1];
		List<Integer> unchanged = new ArrayList<>();
		for (int i = a.length - 2; i > -1; i--) {
			if (a[i + 1] > a[i]) {
				r[i] = a[i + 1];
				nextLarger = a[i + 1];
			} else if (nextLarger > a[i]) {
				r[i] = nextLarger;
			} else {
				r[i] = -1;
				unchanged.add(i);
			}
		}

		return r;
	}

}
