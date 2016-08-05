package cf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {

	}

	/**
	 * Given an integer n, your task is to write all the numbers from 0 to 2**n
	 * - 1.so that for each two successive values their binary form differ in
	 * only one bit.
	 * 
	 * @param n
	 *            (Range 1 - 13)
	 * @return Concatenate the values in a string and return this string.
	 * 
	 *         For n = 3, 2**3 - 1 = 8 - 1
	 *         the output should be grayCode(n) = "01326754".
	 * 
	 *         Here's how the string was obtained:
	 * 
	 *         decimal binary 
	 *         0 0000 
	 *         1 0001 
	 *         3 0011 
	 *         2 0010 
	 *         6 0110 
	 *         7 0111 
	 *         5 0101 
	 *         4 0100
	 *         
	 *         Note, that in binary notation each two consecutive values differ only in one digit.
	 */
	public String grayCode(int n) {
		int l = (int) (Math.pow(2, n) - 1);
		String r = Integer.toBinaryString(l);
		List<String> v = new ArrayList<>();
		for (int i = 0; i < l; i++) {
			v.add(Integer.toBinaryString(i));
		}
		Collections.sort(v);
		System.out.println(v);
		return "";
	}
}
