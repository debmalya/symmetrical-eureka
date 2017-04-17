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
 * @author debmalyajash
 *
 */
public class DrawingBook {
	
	public static int solve(int n, int p) {
		
		
		if (p % 2 == 1) {
			p--;
		} 
		int fromFront =  p/2;
		if (n % 2 == 1) {
			n--;
		}
		int fromBack = (n - p)/2;
		
		int result = (fromBack < fromFront) ? fromBack : fromFront;
		return result;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int p = in.nextInt();
			int result = solve(n, p);
			System.out.println(result);
		}
	}

}
