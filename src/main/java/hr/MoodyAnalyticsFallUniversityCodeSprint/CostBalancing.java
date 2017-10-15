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
package hr.MoodyAnalyticsFallUniversityCodeSprint;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class CostBalancing {

	/**
	 * @param args
	 */
	public static void main( String[ ] args ) {
		try( Scanner in = new Scanner( System.in ) ) {
			int n = in.nextInt();
			int m = in.nextInt();

			int total = 0;
			int[ ] paid = new int[ m ];
			int[ ] balance = new int[ m ];

			for( int i = 0; i < n; i++ ) {
				int id = in.nextInt();
				int amount = in.nextInt();
				paid[ id - 1 ] += amount;
				total += amount;
			}

			int perHeadCost = total / m;
			balance[ 0 ] = paid[ 0 ] - ( perHeadCost + total - ( perHeadCost * m ) );
			for( int i = 1; i < m; i++ ) {
				balance[ i ] = paid[ i ] - perHeadCost;
			}

			for( int i = 0; i < m; i++ ) {
				System.out.println( (i+ 1) + " " + balance[ i ] );
			}
		}

	}

}
