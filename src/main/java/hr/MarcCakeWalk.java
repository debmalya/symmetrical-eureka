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
public class MarcCakeWalk {

	/**
	 * @param args
	 */
	public static void main( String[ ] args ) {
		try( Scanner in = new Scanner( System.in ) ) {
			int n = in.nextInt();
			int[ ] calories = new int[ n ];
			for( int calories_i = 0; calories_i < n; calories_i++ ) {
				calories[ calories_i ] = in.nextInt();
			}
			// your code goes here
			Arrays.sort( calories );
			long totalCalories = 0;
			for( int i = calories.length - 1; i > -1; i-- ) {
				totalCalories += calories[ i ] * Math.pow( 2 , calories.length - 1 - i);
			}
			System.out.println( totalCalories );
		}
	}

}
