/**
 * 
 */
package cf;

/**
 * @author debmalyajash
 *
 */
public class HerosNZeros {
	/**
	 * N! is the notation of a factorial, which can be described as the product
	 * of all positive numbers less than or equal to N. We also define 0! to be
	 * equal to 1.
	 * 
	 * Given the number N, your task is to find the number of trailing zeros in
	 * the value of N!.
	 * 
	 * Example:
	 * 
	 * Zeros(4) = 0 4! = 1 * 2 * 3 * 4 = 24, which has 0 trailing zeros.
	 * Zeros(7) = 1 7! = 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040, which has 1 trailing
	 * zero. [input] integer N
	 * 
	 * 0 ≤ N ≤ 2 * 109. [output] integer
	 * 
	 * The number of trailing zeros in N!.
	 * 
	 * @param N
	 * @return
	 */
	public static int Zeros(int N) {

		int f = N / 5;

		int fp = 5 * 5;
		while (true) {
			int v = N / fp;
			if (v >= 1) {
				f += v;
			} else {
				break;
			}
			fp *= 5;
		}

		return f;

	}

}
