/**
 * 
 */
package cf;

/**
 * @author debmalyajash
 *
 */
public class PronicNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * A pronic number (also known as oblong number, rectangular number or
	 * heteromecic number), is a number which is the product of two consecutive
	 * integers, i.e. it can be represented as x * (x + 1) for some integer x.
	 * The first few pronic numbers are:
	 * 
	 * 0, 2, 6, 12, 20, 30, 42...
	 * 
	 * @param n
	 *            number to be tested for pronic.
	 * @return true if pronic, false otherwise.
	 */
	boolean isPronic(int n) {
		if (n == 0 || n == 2) {
			return true;
		}

		int m = n;
		int f = 1;
		int prevF = 1;
		int k = n / 2;
		for (int i = 2; i <= k; i++) {
			f = 1;
			while (n % i == 0) {
				n /= i;
				f *= i;
			}
			if (f * prevF == m && Math.abs(f - prevF) == 1) {
				return true;
			}
			if (f > 1) {
				prevF *= f;
				if (Math.abs(n - prevF) == 1) {
					return true;
				}
				System.out.println(prevF+" , " + n);
			}
		}
		return false;
	}
}
