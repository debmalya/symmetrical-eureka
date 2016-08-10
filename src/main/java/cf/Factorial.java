package cf;

/**
 * A factorial number is such a number that can be written as k! and is equal to
 * the product of all integers 1 through k. For example,
 * 
 * 4! = 1 * 2 * 3 * 4 = 24.
 * 
 * @author debmalyajash
 *
 */
public class Factorial {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int FactorialCount(int n) {
		int r = 1;
		int i = 1;
		while (r < n) {
			i++;
			if (r * i <= n){
				r *= i;
			} else {
				break;
			}
		}
		if (n == r) {
			return 1;
		}
		return 1 + FactorialCount(n - r);
	}

}
