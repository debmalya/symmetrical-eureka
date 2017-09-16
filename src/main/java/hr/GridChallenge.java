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
package hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GridChallenge {

	/**
	 * @param args
	 */
	public static void main( String[ ] args ) {
		try( Scanner in = new Scanner( System.in ) ) {
			int t = in.nextInt();
			boolean[ ] answers = new boolean[ t ];
			for( int i = 0; i < t; i++ ) {
				int n = in.nextInt();
				String[ ] arr = new String[ n ];
				for( int j = 0; j < n; j++ ) {
					arr[ j ] = in.next();
				}
				answers[ i ] = check( arr );
				
			}
			
			for( int i = 0; i < t; i++ ) {
				if (answers[i]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	/**
	 * @param arr
	 * @return
	 */
	public static boolean check( String[ ] arr ) {

		char[ ][ ] arrCh = new char[ arr.length ][ arr.length ];
		for( int i = 0; i < arr.length; i++ ) {
			arrCh[ i ] = arr[ i ].toCharArray();
			Arrays.sort( arrCh[ i ] );
		}

		for( int col = 0; col < arr.length; col++ ) {
			char prev = ' ';
			char current = ' ';
			for( int row = 0; row < arr.length; row++ ) {
				current = arrCh[row][col];
				if (col > 0 && prev > current) {
					return false;
				}
				prev = current;
			}
		}
		return true;
	}

}
