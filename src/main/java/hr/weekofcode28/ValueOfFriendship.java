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
package hr.weekofcode28;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class ValueOfFriendship {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int q = in.nextInt();
			int[] result = new int[q];
			
			for (int i = 0; i < q; i++) {
				int numberOfStudents = in.nextInt();
				int numberOfDirectMemberShip = in.nextInt();
				int[] x = new int[numberOfDirectMemberShip];
				int[] y = new int[numberOfDirectMemberShip];
				
				result[i] = getTotal(numberOfStudents,numberOfDirectMemberShip,x,y);
			}
			
			for (int i = 0; i < q; i++) {
				System.out.println(result[i]);
			}
		}

	}

	/**
	 * @param n
	 * @param m
	 * @param x
	 * @param y
	 * @return
	 */
	private static int getTotal(int n, int m, int[] x, int[] y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
