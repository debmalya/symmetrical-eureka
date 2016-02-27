/**
 * 
 */
package math.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class MathUtil {

	public static int[] getGoodNumbers0(String[] requests) {

		int[] indexes = new int[requests.length];
		int maxIndex = 0;

		for (int i = 0; i < requests.length; i++) {
			indexes[i] = Integer.parseInt(requests[i]);
			maxIndex = Math.max(maxIndex, indexes[i]);
		}

		int c = 1;
		List<Integer> values = new ArrayList<>();
		int i = 1;
		int index = 0;
		while (c <= maxIndex) {
			int f = 5 * (int) (Math.pow(i, 2)) - 4;
			int e = 5 * (int) (Math.pow(i, 2)) + 4;
			if (isPerfectSquare(e) || isPerfectSquare(f)) {
				if (indexes[index] == c) {
					values.add(i);
					index++;
				}
				c++;

			}
			i++;

		}

		int[] r = new int[values.size()];
		for (i = 0; i < values.size(); i++) {
			r[i] = values.get(i);
		}

		return r;
	}

	/**
	 * We will call an integer N good if either 5 * N**2 - 4 or 5 * N**2 + 4 is an
	 * exact square of an integer. You are given an array of requests, where
	 * each request is an integer given as a string.
	 * 
	 * Return an array of responses, such that for each i the ith element of the
	 * answer is the requestith good integer.
	 * 
	 * Example:
	 * 
	 * good_numbers(["1", "2", "3"]) = [1, 2, 3]. The first good number is 1,
	 * the second is 2, and the third is 3. good_numbers(["4"]) = [5]. The
	 * fourth good number is 5. [input] array.string requests
	 * 
	 * 1 ≤ requests.size() ≤ 100 1 ≤ requests[i] ≤ 1018 [output] array.integer
	 * 
	 * Array of integers, such that its ith element is the requestith good
	 * integer.
	 * 
	 * @param requests
	 * @return
	 */
	public static int[] getGoodNumbers(String[] requests) {

		BigInteger[] indexes = new BigInteger[requests.length];

		for (int i = 0; i < requests.length; i++) {
			indexes[i] = new BigInteger(requests[i]);
		}

		BigInteger c = BigInteger.ONE.add(BigInteger.ONE);
		List<BigInteger> values = new ArrayList<>();
		int i = 1;
		int index = 2;
		BigInteger f = BigInteger.ONE;
		BigInteger s = f.add(BigInteger.ONE);
		BigInteger temp = f;
		values.add(f);
		values.add(s);

		while (index < requests.length) {

			c = c.add(BigInteger.ONE);
			temp = s;
			s = s.add(f);
			f = temp;
			if (c.intValue() == indexes[index].intValue()) {
				values.add(s);
				index++;
			}
		}

		int[] r = new int[values.size()];
		for (i = 0; i < values.size(); i++) {
			r[i] = values.get(i).intValue();
		}

		return r;
	}

	public static boolean isPerfectSquare(int n) {
		int h = n & 0xF; // last hexadecimal "digit"
		if (h > 9)
			return false; // return immediately in 6 cases out of 16.

		// Take advantage of Boolean short-circuit evaluation
		if (h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8) {
			// take square root if you must
			int t = (int) Math.floor(Math.sqrt((double) n) + 0.5);
			return t * t == n;
		}
		return false;
	}
}
