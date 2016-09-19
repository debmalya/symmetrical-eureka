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
 * Sam is a young treasure hunter located at point (0,0) and wants to get to the
 * amazing treasure at point (x,y).
 * 
 * He has a weird machine that can transport him from some point (x,y) to point
 * (x,y) +k(a,b) , where (a,b) is a direction vector, k is a real number called
 * tangent coefficient. Let (a',b') be the vector orthogonal to (a,b). which has
 * the same length and lies counter-clockwise from (a,b); Sam can then also move
 * from point (x,y) to point (x,y)+n(a',b'), where n is a real number called a
 * normal coefficient.
 * 
 * Given a,b,x and y, find the value of k and Sam's journey from point (0,0) to
 * point (x,y) using the weird machine. Then print the value of k on a new line
 * and value of n on the subsequent line.
 * 
 * @author debmalyajash
 *
 */
public class TreasureHunt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// first line contain space separated two integers x and y.
			int x = in.nextInt();
			int y = in.nextInt();

			// Second line contains space separated two integers a and b.
			int a = in.nextInt();
			int b = in.nextInt();
			
//			 k(a,b) + n(a',b') = x,y.

		}

	}

}
