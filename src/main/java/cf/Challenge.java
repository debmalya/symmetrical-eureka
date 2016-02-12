/**
 * 
 */
package cf;

import java.util.Arrays;

/**
 * @author debmalyajash
 *
 */
public class Challenge {
	/**
	 * Bernoulli has a string that consists of numbers only. He wants to divide
	 * this string into 3 numbers without leading zeros, so that no number is
	 * greater than 106, and their total sum is maximum.
	 * 
	 * Find the maximum sum he can obtain this way, or return -1 if there is no
	 * solution.
	 * 
	 * Example:
	 * 
	 * For Number = "2345" the possible sums are:
	 * 
	 * 2 + 3 + 45 = 50; 2 + 34 + 5 = 41; 23 + 4 + 5 = 32. The maximum sum is 50,
	 * so the answer is MaximumString("2345") = 50. For Number = "0007" there is
	 * no answer, because after splitting the string into 3 numbers number 00 or
	 * 07 will be obtained. The numbers cannot have leading zeroes, so the
	 * answer is MaximumString("0007") = -1.
	 * 
	 * [input] string Number
	 * 
	 * 3 ≤ Number.length ≤ 30. [output] integer
	 * 
	 * 
	 * @param Number
	 * @return
	 */
	int MaximumString(String Number) {
		char[] c = Number.toCharArray();
		Arrays.sort(c);
		return -1;
	}
}
