/**
 * 
 */
package math.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class MathUtil {

	public static int[] getGoodNumbers(String[] requests) {

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
