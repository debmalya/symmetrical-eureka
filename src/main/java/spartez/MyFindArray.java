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
package spartez;

/**
 * @author debmalyajash
 *
 */
public class MyFindArray implements FindArray {

	/*
	 * Implement a method that given two arrays as parameters will find the
	 * starting index where the second parameter occurs as a sub-array in the
	 * array given as the first parameter. If given sub-array (second parameter)
	 * occurs more than once, then the method should return the starting index
	 * of the last occurrence Your implementations should return -1 if the
	 * sub-array cannot be found. Your implementation must implement the
	 * FindArray interface. For extra points: implement it in an efficient way
	 * for large input arrays.
	 * 
	 *  Sample Input: [4,9,3,7,8] and [3,7] should return
	 * 2. 
	 * 
	 * 
	 * [1,3,5] and [1] should return 0. [7,8,9] and [8,9,10] should return
	 * -1. 
	 * 
	 * 
	 * [4,9,3,7,8,3,7,1] and [3,7] should return 5. 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see spartez.FindArray#findArray(int[], int[])
	 */
	@Override
	public int findArray(int[] array, int[] subArray) {
		if (array == null || subArray == null) {
			return -1;
		}

		if (array.length == 0 || subArray.length == 0) {
			return -1;
		}

		int lastIndex = -1;
		int j = subArray.length - 1;

		for (int i = array.length - 1; i > -1; i--) {
			if (array[i] == subArray[j]) {
				j--;
				if (j == -1) {
					lastIndex = i;
					return lastIndex;
				}
			} else {
				j = subArray.length - 1;
				lastIndex = -1;
			}
		}
		return lastIndex;
	}

}
