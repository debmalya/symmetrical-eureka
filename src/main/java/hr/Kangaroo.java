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
package hr;

import java.util.Scanner;

/**
 * There are two kangaroos on an x-axis ready to jump in the positive direction
 * (i.e, toward positive infinity). The first kangaroo starts at location x1 and
 * moves at a rate of v1 meters per jump. The second kangaroo starts at location x2
 * and moves at a rate of v2 meters per jump. Given the starting locations and
 * movement rates for each kangaroo, can you determine if they'll ever land at
 * the same location at the same time?
 * 
 * @author debmalyajash
 *
 */
public class Kangaroo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int x1 = in.nextInt();
	        int v1 = in.nextInt();
	        int x2 = in.nextInt();
	        int v2 = in.nextInt();
			
			if (x2 > x1  && v1 > v2){
				if ((x2 - x1) % (v2 - v1) == 0){
					System.out.println("YES");
					return;
				}
			}else if (x1 > x2  && v2 > v1){
				if ((x1 - x2) % (v1 - v2) == 0){
					System.out.println("YES");
					return;
				}
			}
			
			System.out.println("NO");
			
		}

	}

}
