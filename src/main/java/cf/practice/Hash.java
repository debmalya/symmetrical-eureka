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
public class Hash {
	/**
	 * Given an array strings, determine whether it follows the sequence given
	 * in the patterns array. In other words, there should be no i and j for
	 * which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which
	 * strings[i] ≠ strings[j] and patterns[i] = patterns[j].
	 * 
	 * Example
	 * 
	 * For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the
	 * output should be areFollowingPatterns(strings, patterns) = true; For
	 * strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the
	 * output should be areFollowingPatterns(strings, patterns) = false.
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.string strings
	 * 
	 * An array of strings, each containing only lowercase English letters.
	 * 
	 * Guaranteed constraints: 1 ≤ strings.length ≤ 105, 1 ≤ strings[i].length ≤
	 * 10.
	 * 
	 * [input] array.string patterns
	 * 
	 * An array of pattern strings, each containing only lowercase English
	 * letters.
	 * 
	 * Guaranteed constraints: patterns.length = strings.length, 1 ≤
	 * patterns[i].length ≤ 10.
	 * 
	 * [output] boolean
	 * 
	 * Return true if strings follows patterns and false otherwise.
	 * 
	 * @param strings
	 * @param patterns
	 * @return
	 */

	public boolean areFollowingPatterns( String[ ] strings, String[ ] patterns ) {

		if( strings == null || patterns == null ) {
			return false;
		}

		if( strings.length != patterns.length ) {
			return false;
		}

		int[ ] first = new int[ strings.length ];
		int[ ] second = new int[ patterns.length ];

		for( int i = 1; i < strings.length; i++ ) {
			if( strings[ i - 1 ].equals( strings[ i ] ) ) {
				first[ i ] = first[ i - 1 ];
			}else {
				first[ i ] = first[ i - 1 ] + 1;
			}
		}

		for( int i = 1; i < patterns.length; i++ ) {
			if( patterns[ i - 1 ].equals( patterns[ i ] ) ) {
				second[ i ] = second[ i - 1 ];
			}else {
				second[ i ] = second[ i - 1 ] + 1;
			}
		}

		System.out.println( Arrays.toString( first ) + " " + Arrays.toString( second ) );
		return Arrays.equals( first, second );
	}

}
