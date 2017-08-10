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
package ht;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main( String[ ] args ) {
		try( Scanner in = new Scanner( System.in ) ) {
			int t = in.nextInt();
			String[ ] a = new String[ t ];
			for( int i = 0; i < t; i++ ) {
				String[ ] arr = new String[ 5 ];
				for( int j = 0; j < 5; j++ ) {
					arr[ j ] = in.nextLine();
				}
				a[ i ] = getAnswer( arr );
			}
		}

	}

	/**
	 * @param arr
	 * @return
	 */
	public static String getAnswer( String[ ] arr ) {
		int[ ] dx = new int[] { -1, 0, 1, 0 };
		int[ ] dy = new int[] { 0, 1, 0, -1 };

		int count = 0;
		int lc = 0;
		for( int i = 0; i < arr.length; i++ ) {
			for( int j = 0; j < arr[ 0 ].length(); j++ ) {
				int nc = 0;
				for( int k = 0; k < dx.length; k++ ) {
					int modX = i + dx[ k ];
					int modY = j + dy[ k ];

					if( modX > -1 && modX < arr.length && modY > -1 && modY < arr[ 0 ].length() ) {
						if( arr[ modX ].charAt( modY ) == '1' ) {
							nc++;
						}
					}
				}

				if( arr[ i ].charAt( j ) == '0' && nc == 3 ) {
					lc++;
				}else if( arr[ i ].charAt( j ) == '1' && ( nc == 2 || nc == 3 ) ) {
					lc++;
				}
			}
			count++;
			if( count > 98 ) {
				// How many are active at the end of 100 units of time?
				if( lc > 0 ) {
					return "YES";
				}else {
					return "NO";
				}
			}
		}
		return null;
	}

}
