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
package he.capillary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class CoolNumbers {

	private static final int[] coolNumbers = new int[] { 2, 5, 22, 25, 52, 55, 222, 225, 252, 255, 522, 525, 552, 555,
			2222, 2225, 2252, 2255, 2522, 2525, 2552, 2555, 5222, 5225, 5252, 5255, 5522, 5525, 5552, 5555, 22222,
			22225, 22252, 22255, 22522, 22525, 22552, 22555, 25222, 25225, 25252, 25255, 25522, 25525, 25552, 25555,
			52222, 52225, 52252, 52255, 52522, 52525, 52552, 52555, 55222, 55225, 55252, 55255, 55522, 55525, 55552,
			55555, 222222, 222225, 222252, 222255, 222522, 222525, 222552, 222555, 225222, 225225, 225252, 225255,
			225522, 225525, 225552, 225555, 252222, 252225, 252252, 252255, 252522, 252525, 252552, 252555, 255222,
			255225, 255252, 255255, 255522, 255525, 255552, 255555, 522222, 522225, 522252, 522255, 522522, 522525,
			522552, 522555, 525222, 525225, 525252, 525255, 525522, 525525, 525552, 525555, 552222, 552225, 552252,
			552255, 552522, 552525, 552552, 552555, 555222, 555225, 555252, 555255, 555522, 555525, 555552, 555555,
			2225522, 2225525, 2225552, 2225555, 2252222, 2252225, 2252252, 2252255, 2252522, 2252525, 2252552, 2252555,
			2255222, 2255225, 2255252, 2255255, 2255522, 2255525, 2255552, 2255555, 2522222, 2522225, 2522252, 2522255,
			2522522, 2522525, 2522552, 2522555, 2525222, 2525225, 2525252, 2525255, 2525522, 2525525, 2525552, 2525555,
			2552222, 2552225, 2552252, 2552255, 2552522, 2552525, 2552552, 2552555, 2555222, 2555225, 2555252, 2555255,
			2555522, 2555525, 2555552, 2555555, 5225522, 5225525, 5225552, 5225555, 5252222, 5252225, 5252252, 5252255,
			5252522, 5252525, 5252552, 252555, 255222, 5255225, 5255252, 5255255, 5255522, 5255525, 5255552, 5255555,
			5522222, 5522225, 5522252, 5522255, 5522522, 5522525, 5522552, 5522555, 5525222, 5525225, 5525252, 5525255,
			5525522, 5525525, 5525552, 5525555, 5552222, 5552225, 5552252, 5552255, 5552522, 5552525, 5552552, 5552555,
			5555222, 5555225, 5555252, 5555255, 5555522, 5555525, 5555552, 5555555, };

	
	private static List<Integer> coolNumberList = generateCoolNumbers(9);
	// private static final int[] coolNumbers = new int[] { 2, 5};

	/**
	 * f(k) be the smallest cool number (containing only 2 and 5) which is
	 * greater than or equals k.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays.sort(coolNumbers);
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			int[] result = new int[T];
			for (int i = 0; i < T; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				for (int j = l; j <= r; j++) {
					result[i] += getCoolNumber(j);
				}
			}

			for (int i = 0; i < T; i++) {
				System.out.println(result[i]);
			}

		}

	}

	/**
	 * Get cool number just greater than num.
	 * 
	 * @param num
	 *            passed number.
	 * @return next cool number.
	 */
	public static int getCoolNumber(final int num) {
		// get the length of num.
		int result = 0;
		for (int i = 0; i < coolNumbers.length; i++) {
			if (coolNumbers[i] >= num) {
				return coolNumbers[i];
			}
		}
		return result;
	}
	
	/**
	 * Get cool number just greater than num.
	 * 
	 * @param num
	 *            passed number.
	 * @return next cool number.
	 */
	public static int getCoolNumber1(final int num) {
		// get the length of num.
		int result = 0;
		for (int i = 0; i < coolNumberList.size(); i++) {
			if (coolNumberList.get(i) >= num) {
				return coolNumbers[i];
			}
		}
		return result;
	}

	/**
	 * It will generate all the cool numbers up to specified width
	 * 
	 * @param width
	 *            - maximum length of the digit.
	 * @return a list of cool integers.
	 */
	public static List<Integer> generateCoolNumbers(final int width) {
		List<Integer> numberList = new ArrayList<>();
		if (width > 0) {
			numberList.add(2);
			numberList.add(5);
		}

		int i = 1;
		while (i < width) {
			List<Integer> newList = new ArrayList<>();
			for (int j = 0; j < numberList.size(); j++) {
				if (numberList.get(j).toString().length() == i) {
					newList.add(numberList.get(j) * 10 + 2);
					newList.add(numberList.get(j) * 10 + 5);
				}
			}
			numberList.addAll(newList);
			i++;
		}
		Collections.sort(numberList);
		return numberList;
	}

}
