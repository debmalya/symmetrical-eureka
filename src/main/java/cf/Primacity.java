package cf;

import java.util.HashSet;
import java.util.Set;

public class Primacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Primacity of an integer is the number of distinct primes which divide it.
	 * How many integers in the range [l, r] have a primacity of exactly k?
	 * 
	 * @param l
	 *            - lower range.
	 * @param r
	 *            - Upper range.
	 * @param k
	 *            - primacity frequency.
	 * @return - numbers within the range l and r (both inclusive) have exactly
	 *         k number of prime factors.
	 */
	public int luckyandprime2(int l, int r, int k) {
		int c = 0;
		
		for (int a = l; a <= r; a++){
			Set<Integer> p = new HashSet<>();
			
			int d = a;
			for (int i = 2; i <= a; i++) {
				while (d % i == 0) {
					d /= i;
					p.add(i);
				}
			}
			
			if (p.size() == k){
				System.out.println(a+ " " + p);
				c++;
			}
		}
		return c;
	}

	/**
	 * 
	 * @param n
	 *            whose prime factors will be determined.
	 * @return list of prime factors.
	 */
	public Set<Integer> getPrimeFactors(int n) {
		Set<Integer> primeFactorSet = new HashSet<>();
		int l = n / 2;
		for (int i = 2; i <= l; i++) {
			while (n % i == 0) {
				n /= i;
				primeFactorSet.add(i);
			}
		}
		return primeFactorSet;
	}
}
