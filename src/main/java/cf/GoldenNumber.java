package cf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Golden numbers are numbers whose only prime factors are 2, 3 or 5. By
 * convention, 1 is also considered to be a golden number.
 * 
 * @author debmalyajash
 *
 */
public class GoldenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * calculates the nth (1-based) golden number.
	 * 
	 * @param n
	 *            Range 1 <= n <= 1500
	 * @return nth golden number.
	 */
	public static int GoldenNumbers(int n) {
		if (n == 1)
			return 1;
		List<Integer> g = new ArrayList<>();
		g.add(2);
		g.add(3);
		int r = 1;
		while (g.size() < n - 1){
			if (g.size()== n -1) {
				Collections.sort(g);
				r = g.get(g.size() - 1);
				break;
			}
		}
		return r;
	}

	/**
	 * calculates the nth (1-based) golden number.
	 * 
	 * @param n
	 *            Range 1 <= n <= 1500
	 * @return nth golden number.
	 */
	public static int GoldenNumbers0(int n) {
		List<Integer> g = new ArrayList<>();
		g.add(1);
		g.add(2);
		g.add(3);
		int i = 2;
		while (g.size() < n) {
			// find next golden number.
			int[] a = new int[] { 2, 3, 5 };
			int b = i;
			for (int j = 0; j < a.length; j++) {
				while (b % a[j] == 0) {
					b /= a[j];
				}
			}
			if (b == 1) {
				g.add(i);
			}
			if (g.size() == n) {
				return i;
			}
			i++;
		}
		return 1;
	}

}
