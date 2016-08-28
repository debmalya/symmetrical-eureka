package he.ittiam.think;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer array A of size N and an integer K, you need to find the
 * number of increasing subsequences with sum less than K.
 * 
 * @author debmalyajash
 *
 */
public class JPnSubSequence {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// First line will contain two space separated numbers n and k
			int n = in.nextInt();
			int k = in.nextInt();

			// Second line will contain N space separated integers denoting the
			// elements of array A.
			long c = 0;
			int[] a = new int[n];
			int[] ps = new int[n];
			int[] rs = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (a[i] < k) {
					c++;
				}
			}

			Arrays.sort(a);
			for (int i = 0; i < n; i++) {
				ps[i] += a[i];
				rs[n - 1 - i] += a[n - 1 - i];
				if (i > 0) {
					ps[i] += ps[i - 1];
					rs[n - 1 - i] += rs[n - i];
					if (ps[i] < k) {
						c++;
					} 
				}

			}

			
			for (int i = 0; i < n; i++){
				if (ps[i] + rs[n - 1 - i] < k) {
					c++;
				} else {
					break;
				}
			}

			System.out.println(c % 1000000007);

		}

	}

}
