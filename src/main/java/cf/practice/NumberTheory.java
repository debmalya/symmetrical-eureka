/**
 * Copyright 2015-2017 Debmalya Jash
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
package cf.practice;

import java.util.Arrays;

/**
 * @author debmalyajash
 *
 */
public class NumberTheory {
	/**
	 * You are supposed to label a bunch of boxes with numbers from 0 to n, and
	 * all the labels are stored in the array arr. Unfortunately one of the
	 * labels is missing. Your task is to find it.
	 * 
	 * Example
	 * 
	 * For arr = [3, 1, 0], the output should be missingNumber(arr) = 2.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.integer arr
	 * 
	 * An unsorted array consisting of different integers from 0 to n inclusive,
	 * with only one of them missing.
	 * 
	 * Guaranteed constraints: 1 ≤ arr.length ≤ 1000, 0 ≤ arr[i] ≤ arr.length.
	 * 
	 * [output] integer
	 * 
	 * The missing number.
	 * 
	 * 
	 * @param arr
	 *            - array containing labels.
	 * @return missing number.
	 */
	public int missingNumber( int[ ] arr ) {
		Arrays.sort( arr );
		int prev = 0;
		for( int i = 0; i < arr.length; i++ ) {
			if( i == 0 && arr[ i ] != 0 ) {
				return 0;
			}else if( i > 0 && arr[ i ] - prev > 1 ) {
				return prev + 1;
			}
			prev = arr[ i ];
		}
		return prev + 1;
	}

}
