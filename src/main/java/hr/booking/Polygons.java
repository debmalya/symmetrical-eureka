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
package hr.booking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Polygons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int squares = 0;
			int rectangles = 0;
			int others = 0;

			while (in.hasNextLine()) {
				String s = in.nextLine();
				if (s != null && s.trim().length() > 0) {
					int[] a = new int[4];
					String[] inputs = s.split(" ");
					for (int i = 0; i < 4; i++) {
						a[i] = Integer.parseInt(inputs[i]);
					}

					Arrays.sort(a);

					if ((a[0] > 0) && (a[0] == a[1]) && (a[1] == a[2]) && (a[2] == a[3])) {
						squares++;
					} else if ((a[0] > 0)  && (a[0] == a[1])  && (a[2] == a[3])) {
						rectangles++;
					} else {
						others++;
					}

				} else {
					break;
				}
			}

			System.out.println(squares + " " + rectangles + " " + others);
		}

	}

}
