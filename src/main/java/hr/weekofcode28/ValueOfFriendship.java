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
		try (Scanner in = new Scanner(System.in)) {

			int q = in.nextInt();
			int[] result = new int[q];

			for (int i = 0; i < q; i++) {
				int numberOfStudents = in.nextInt();
				boolean[][] friendShip = new boolean[numberOfStudents][numberOfStudents];
				int[] friendsCount = new int[numberOfStudents];
				int numberOfDirectMemberShip = in.nextInt();

				int total = 0;
				for (int j = 0; j < numberOfDirectMemberShip; j++) {

					int f1 = in.nextInt() - 1;
					int f2 = in.nextInt() - 1;

					if (!friendShip[f1][f2]) {
						// f1 gets a new friend f2
						friendsCount[f1]++;
						friendShip[f1][f2] = true;

						if (!friendShip[f2][f1]) {
							// f2 gets a new friend f1
							friendsCount[f2]++;
							friendShip[f2][f1] = true;

							// all friends of f1 who are not friend with f2
							// becomes f2's friend.
						}

						// now all friends of f2 who are not friend with f1
						// becomes f1's friend.
						friendsCount[f1] = Math.max(friendsCount[f1], friendsCount[f2]);
						friendsCount[f2] = Math.max(friendsCount[f1], friendsCount[f2]);
						

						for (int k = 0; k < numberOfStudents; k++) {
							if (friendShip[f1][k]) {
								if (f2 != k && !friendShip[k][f2]) {
//									System.out.println("A. " + (f1 + 1) + " is friend with " + (k + 1));
//									System.out.println("Then " + (k + 1) + " is friend with " + (f2 + 1));
									friendsCount[k]++;
									friendShip[k][f2] = true;
									friendShip[f2][k] = true;
								}
							}
						}

						for (int k = 0; k < numberOfStudents; k++) {
							if (friendShip[f2][k]) {
								if (f1 != k && !friendShip[k][f1]) {
//									System.out.println("("+f1+","+f2+")"+"B. " + (f2 + 1) + " is friend with " + (k + 1));
//									System.out.println("Then " + (k + 1) + " is friend with " + (f1 + 1));
									friendsCount[k]++;
									friendShip[k][f1] = true;
									friendShip[f1][k] = true;
								}
							}
						}

					} else {
						// Already f1 and f2 are friends no need to change.
					}
					
					for (int a = 0; a < numberOfStudents; a++) {
						total += friendsCount[a];
					}

				}

				result[i] += total;
			}

			for (int i = 0; i < q; i++) {
				System.out.println(result[i]);
			}
		}

	}

	

}
