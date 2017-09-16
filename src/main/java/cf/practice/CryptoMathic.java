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
package cf.practice;

/**
 * @author debmalyajash
 *
 */
public class CryptoMathic {

	/**
	 * Source: https://codefights.com/interview-practice/task/yM4uWYeQTHzYewW9H
	 * 
	 * A cryptarithm is a mathematical puzzle for which the goal is to find the
	 * correspondence between letters and digits, such that the given arithmetic
	 * equation consisting of letters holds true when the letters are converted
	 * to digits.
	 * 
	 * You have an array of strings crypt, the cryptarithm, and an an array
	 * containing the mapping of letters and digits, solution. The array crypt
	 * will contain three non-empty strings that follow the structure: [word1,
	 * word2, word3], which should be interpreted as the word1 + word2 = word3
	 * cryptarithm.
	 * 
	 * If crypt, when it is decoded by replacing all of the letters in the
	 * cryptarithm with digits using the mapping in solution, becomes a valid
	 * arithmetic equation containing no numbers with leading zeroes, the answer
	 * is true. If it does not become a valid arithmetic solution, the answer is
	 * false.
	 * 
	 * Example
	 * 
	 * For crypt = ["SEND", "MORE", "MONEY"] and
	 * 
	 * solution = [['O', '0'], ['M', '1'], ['Y', '2'], ['E', '5'], ['N', '6'],
	 * ['D', '7'], ['R', '8'], ['S', '9']] the output should be
	 * isCryptSolution(crypt, solution) = true.
	 * 
	 * When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in
	 * crypt, you get 9567 + 1085 = 10652 which is correct and a valid
	 * arithmetic equation.
	 * 
	 * For crypt = ["TEN", "TWO", "ONE"] and
	 * 
	 * solution = [['O', '1'], ['T', '0'], ['W', '9'], ['E', '5'], ['N', '4']]
	 * the output should be isCryptSolution(crypt, solution) = false.
	 * 
	 * Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes,
	 * meaning that this is not a valid solution.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] array.string crypt
	 * 
	 * An array of three non-empty strings containing only uppercase English
	 * letters.
	 * 
	 * Guaranteed constraints: crypt.length = 3, 1 ≤ crypt[i].length ≤ 14.
	 * 
	 * [input] array.array.char solution
	 * 
	 * An array consisting of pairs of characters that represent the
	 * correspondence between letters and numbers in the cryptarithm. The first
	 * character in the pair is an uppercase English letter, and the second one
	 * is a digit in the range from 0 to 9.
	 * 
	 * Guaranteed constraints: solution[i].length = 2, 'A' ≤ solution[i][0] ≤
	 * 'Z', '0' ≤ solution[i][1] ≤ '9', solution[i][0] ≠ solution[j][0], i ≠ j,
	 * solution[i][1] ≠ solution[j][1], i ≠ j.
	 * 
	 * It is guaranteed that solution only contains entries for the letters
	 * present in crypt and that different letters have different values.
	 * 
	 * [output] boolean
	 * 
	 * Return true if the solution represents the correct solution to the
	 * cryptarithm crypt, otherwise return false.
	 * 
	 * @param crypt
	 *            - array of strings.
	 * @param solution
	 * @return
	 */
	boolean isCryptSolution( String[ ] crypt, char[ ][ ] solution ) {
		long l = 0;
		long r = 0;

		// array for first number
		int[ ] fa = new int[ crypt[ 0 ].length() ];
		// array for second number
		int[ ] sa = new int[ crypt[ 1 ].length() ];
		// array for third number
		int[ ] ta = new int[ crypt[ 2 ].length() ];

		for( int i = 0; i < solution.length; i++ ) {
			// Check each character of solution whether they are present in any
			// of the word or not.
			char c = solution[ i ][ 0 ];
			int v = solution[ i ][ 1 ] - '0';
			int f = crypt[ 0 ].indexOf( c );
			int s = crypt[ 1 ].indexOf( c );
			int t = crypt[ 2 ].indexOf( c );

			if( f > -1 ) {
				// if present,
				if( v > 0 ) {
					l += v * ( int ) Math.pow( 10, crypt[ 0 ].length() - f );
					fa[ f ] = v;
				}
			}
			if( s > -1 ) {
				// if present,
				if( v > 0 ) {
					l += v * ( int ) Math.pow( 10, crypt[ 1 ].length() - s );
					sa[ s ] = v;
				}
			}

			if( t > -1 ) {
				// if present,
				if( v > 0 ) {
					r += v * ( int ) Math.pow( 10, crypt[ 2 ].length() - t );
					ta[ t ] = v;
				}
			}
		}

		if( ( fa[ 0 ] == 0 && fa.length > 1 ) || ( sa[ 0 ] == 0 && sa.length > 1 )
				|| ( ta[ 0 ] == 0 && ta.length > 1 ) ) {
			// leading zeroes
			return false;
		}

		return r == l;

	}

	boolean isCryptSolution1( String[ ] crypt, char[ ][ ] solution ) {
		long l = 0;
		long r = 0;

		// array for first number
		int[ ] fa = new int[ crypt[ 0 ].length() ];
		// array for second number
		int[ ] sa = new int[ crypt[ 1 ].length() ];
		// array for third number
		int[ ] ta = new int[ crypt[ 2 ].length() ];

		for( int i = 0; i < solution.length; i++ ) {
			// Check each character of solution whether they are present in any
			// of the word or not.
			char c = solution[ i ][ 0 ];
			int v = solution[ i ][ 1 ] - '0';
			int f = crypt[ 0 ].indexOf( c );
			int s = crypt[ 1 ].indexOf( c );
			int t = crypt[ 2 ].indexOf( c );

			if( f > -1 ) {
				l += v * ( int ) Math.pow( 10, crypt[ 0 ].length() - f );
				fa[ f ] = v;
			}
			if( s > -1 ) {
				l += v * ( int ) Math.pow( 10, crypt[ 1 ].length() - s );
				sa[ s ] = v;
			}

			if( t > -1 ) {
				r += v * ( int ) Math.pow( 10, crypt[ 2 ].length() - t );
				ta[ t ] = v;
			}
		}
		if( r != l ) {
			return false;
		}else {
			if( ( fa[ 0 ] == 0 && fa.length > 1 ) || ( sa[ 0 ] == 0 && sa.length > 1 )
					|| ( ta[ 0 ] == 0 && ta.length > 1 ) ) {
				// leading zeroes
				return false;
			}
			return r == l;
		}

	}

	boolean isCryptSolution0( String[ ] crypt, char[ ][ ] solution ) {
		int[ ] s = new int[ 3 ];
		for( int i = 0; i < crypt.length; i++ ) {
			s[ i ] = getCryptoValue( crypt[ i ], solution );
		}
		return s[ 0 ] + s[ 1 ] == s[ 2 ];
	}

	int getCryptoValue( String str, char[ ][ ] solution ) {
		int sum = 0;
		for( int i = 0; i < str.length(); i++ ) {
			char c = str.charAt( i );
			for( int j = 0; j < solution.length; j++ ) {
				if( solution[ j ][ 0 ] == c ) {
					sum += ( solution[ j ][ 1 ] - '0' );
					sum *= 10;
					break;
				}
			}
		}
		return sum / 10;
	}
}
