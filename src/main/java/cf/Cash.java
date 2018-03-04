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

import java.util.Arrays;

public class Cash {
	int nCash(int[] m, int p) {

		int count = 0;
		Arrays.sort(m);
		int index = Arrays.binarySearch(m, p);
		if (index > -1) {
			return 1;
		}
		while (p > 0) {
			int beforeP = p;
			p = findNearest(m, p);
			count++;
			if (beforeP == p) {
				return 0;
			} else {
				int divisor = beforeP - p;
				if (p >= divisor) {
					count+= (p / divisor);
					p %= divisor;

				}
			}
		}
		return count;
	}

	private int findNearest(int[] m, int p) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < m.length; i++) {
			if (p >= m[i]) {
				if (p - m[i] < min) {
					min = p - m[i];
					index = i;
				}
			}
		}

		if (index > -1) {
			int temp = m[index];
			m[index] -= p;
			p -= temp;
			return p;
		}
		return p;
	}
	
	

}
