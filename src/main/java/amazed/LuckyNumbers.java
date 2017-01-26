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
package amazed;

/**
 * @author debmalyajash
 *
 */
public class LuckyNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * A lucky number has the same sum of digits for the upper and lower part of
	 * the number. (e.g. 1102 - Sum of upper part (1+1) = Sum of the lower part
	 * (0+2).
	 * 
	 * @param number
	 *            to check whether number is lucky or not.
	 * @return true if it is a lucky number, false otherwise.
	 */
	public static boolean isLucky(int number) {
		String str = String.valueOf(number);
		int len = str.length();
		if (len % 2 == 1) {
			return false;
		} else {
			int firstPart = Integer.parseInt(str.substring(0, len /2));
			int secondPart = Integer.parseInt(str.substring(len/2));
			
			return getSumOfDigits(firstPart) == getSumOfDigits(secondPart);

		}
}

	/**
	 * Sum of digits of the number.
	 * @param number whose sum of digits will be checked.
	 * @return sum of the digits.
	 */
	public static int getSumOfDigits(int number) {
		int result = 0;
		while (number > 0) {
			result += number%10;
			number /= 10;
		}
		return result;
	}
}
