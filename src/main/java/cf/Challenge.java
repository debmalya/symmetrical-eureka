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

	/**
	 * Your task is to figure out whether the Philippines is at war or not given
	 * a string of English letters. If in this string all letters of word "blue"
	 * in the exact order appear before all letters of string "red" in the exact
	 * order, than the Philippines is "FREE" and doesn't have to fight.
	 * Otherwise it is at "WAR".
	 * 
	 * Example:
	 * 
	 * For letters = "ABAbcvalrDFUEsfeFDFCRddeDXX" the answer is
	 * colorOfOurFlag(letters) = "FREE". Here all letters of blue are italic,
	 * and all letters of red are in bold.
	 * 
	 * For letters = "XCVcRebludcEXBDlXxuECVCD" the answer is
	 * colorOfOurFlag(letters) = "WAR".
	 * 
	 * [input] string words
	 * 
	 * A string of English letters. It is guaranteed that letters of at least
	 * one word mentioned in the description are present in it in the exact
	 * order. Note that letters' case is not important. [output] string
	 * 
	 * The state of the country: either "FREE" or "WAR".
	 * 
	 * @param words
	 * @return
	 */
	String colorOfOurFlag(String words) {
		String bl = "blue";
		String rd = "red";
		int b = 0;
		int r = 0;
		
		words = words.toLowerCase();
		for (int i = 0; i < words.length(); i++) {
			char c = words.charAt(i);
			if (c==bl.charAt(b)){
				b++;
			}
			if (c==rd.charAt(r)){
				r++;
			}
			if (r==3){
				return "WAR";
			}
			if (b==4){
				return "FREE";
			}
		}
		return "FREE";

	}

}
