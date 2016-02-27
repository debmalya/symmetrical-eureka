/**
 * 
 */
package cf;

import java.util.Arrays;

/**
 * @author debmalyajash
 *
 */
public class PayingUp {

	/**
	 * In the mysterious country of Byteland, everything is quite different from
	 * what you'd normally expect. In most places, if you were approached by two
	 * mobsters in a dark alley, they would probably tell you to give them all
	 * the money that you have. If you refused, or didn't have any - they might
	 * even beat you up.
	 * 
	 * In Byteland the government decided that even the slightest chance of
	 * someone getting injured has to be ruled out. So, they introduced a strict
	 * policy. When a mobster approaches you in a dark alley, he asks you for a
	 * specific amount of money. You are obliged to show him all the money that
	 * you have, but you only need to pay up if he can find a subset of your
	 * banknotes whose total value matches his demand. Since banknotes in
	 * Byteland can have any positive integer value not greater than one
	 * thousand you are quite likely to get off without paying.
	 * 
	 * Given the array of integers n which contains banknotes in your wallet,
	 * and m, the amount of money the muggers asked of you, calculate if there
	 * is a subset of your banknotes that sums to m.
	 * 
	 * Example:
	 * 
	 * PayingUp([1, 1, 1], 3) = "Yes" 3 is exactly the amount of money you have.
	 * PayingUp([1,2,4,8,16], 11) = "Yes" 8 + 2 + 1 = 11 PayingUp([1,5,5,10,10],
	 * 13) = "No" [input] array.integer n
	 * 
	 * The banknotes in your wallet. Your wallet does not hold more than 20
	 * banknotes, and the value of a single banknote is never more than 1000 and
	 * not less than 1. [input] integer m
	 * 
	 * A positive integer, the amount of money the muggers asked of you.
	 * [output] string
	 * 
	 * "Yes" if there is a subset of your banknotes that sums to m, and "No"
	 * otherwise. CODE
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public String paidUp1(final int[] n, final int m) {
		Arrays.sort(n);
		int[] p = new int[n.length];
		int[] c = new int[n.length];
		
		int bi = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] < m) {
				p[i] = n[i];
				c[i] = m - n[i];
				bi = i;
			} else {
				break;
			}
		}

		

		return "No";
	}
	public String paidUp(final int[] n, final int m) {
		Arrays.sort(n);
		int[] p = new int[n.length];
		int bi = 0;

		for (int i = 0; i < n.length; i++) {
			p[i] += n[i];

			if (i > 0) {
				p[i] += p[i - 1];
			}

			if (p[i] == m) {
				return "Yes";
			}
			if (p[i] > m) {
				bi = i;
				break;
			}
		}

		for (int j = bi; j > -1; j--) {
			for (int i = 0; i < bi + 1; i++) {
				if (n[j] + p[i] == m) {
					return "Yes";
				}
			}
		}

		return "No";
	}
}
