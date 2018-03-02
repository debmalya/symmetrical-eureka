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
package hr.weekOfCode35;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class SurfaceArea3D {

	static int H = 0;
	static int W = 0;

	static int surfaceArea( int[ ][ ] A ) {
		// Complete this function
		int total = 0;

		int[ ] di = new int[] { -1, 0, 1, 0 };
		int[ ] dj = new int[] { 0, -1, 0, 1 };

		for( int i = 0; i < H; i++ ) {
			for( int j = 0; j < W; j++ ) {
				total += 6 * A[ i ][ j ];
				if( A[ i ][ j ] - 1 > 0 )
					total -= ( ( A[ i ][ j ] - 1 ) * 2 );
				for( int k = 0; k < 4; k++ ) {
					int dii = i + di[ k ];
					int djj = j + dj[ k ];
					if( dii > -1 && dii < H && djj > -1 && djj < W ) {
						if( A[ i ][ j ] <= A[ dii ][ djj ] ) {
							total -= A[ i ][ j ];
						}else {
							total -= A[ dii ][ djj ];
						}
					}
				}
			}
		}
		return total;

	}

	public static void main( String[ ] args ) {
		try( Scanner in = new Scanner( System.in ) ) {
			H = in.nextInt();
			W = in.nextInt();
			int[ ][ ] A = new int[ H ][ W ];
			for( int A_i = 0; A_i < H; A_i++ ) {
				for( int A_j = 0; A_j < W; A_j++ ) {
					A[ A_i ][ A_j ] = in.nextInt();
				}
			}
			int result = surfaceArea( A );
			System.out.println( result );
			in.close();
		}
	}

}
