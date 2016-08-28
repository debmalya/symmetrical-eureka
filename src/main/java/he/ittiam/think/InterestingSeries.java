package he.ittiam.think;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Little Monk found an interesting series which he stuck on for a while on how
 * the series is constructed. He initially observes that the series is strictly
 * in increasing order. After a lot of efforts he found that all the numbers of
 * series are product of 3 different prime numbers. Now he wants to find what
 * Nth number of this series would be.
 * 
 * n=1, 2*3*5 = 30
 * n=2, 2*3*7 = 42
 * n=3, 2*5*7 = 70
 * 
 * @author debmalyajash
 *
 */
public class InterestingSeries {

	static SortedSet<BigInteger> va = new TreeSet<>();

	static SortedSet<BigInteger> pl = new TreeSet<>();

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			int[] n = new int[t];
			String[] r = new String[t];
			for (int i = 0; i < t; i++) {
				n[i] = in.nextInt();
				r[i] = goldenNumber(n[i]);
			}

			for (int i = 0; i < t; i++) {
				System.out.println(r[i]);
			}
		}

	}

	public static String goldenNumber(int n) {

		BigInteger bi = BigInteger.ONE;
		if (pl.size() < 3) {
			BigInteger f = bi.nextProbablePrime();
			pl.add(f);
			BigInteger s = f.nextProbablePrime();
			pl.add(s);
			BigInteger t = s.nextProbablePrime();
			pl.add(t);
		}

		int i = 0;
		int j = 1;
		int k = 2;
		while (va.size() < n) {
			BigInteger[] p = pl.toArray(new BigInteger[0]);
			for (; i < p.length - 1; i += 2) {
				va.add(p[i].multiply(p[i + 1]).multiply(p[k]));
				if (va.size() == n) {
					break;
				}
			}
			if (va.size() < n) {
				pl.add(p[p.length - 1].nextProbablePrime());
				k++;
				if (k % 2 == 0) {
					i++;
				}
			}
		}
		BigInteger[] l = va.toArray(new BigInteger[0]);

		return l[0].toString();
	}

}
