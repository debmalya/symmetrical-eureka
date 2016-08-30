package he.ittiam.think;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer array A of size N and an integer K, you need to find the
 * number of increasing subsequences with sum less than K.
 * 
 * Example 
 * A={1,2,3} K=5
 * 
 * {1}
 * {2}
 * {3}
 * {1,2}
 * {1,3}
 * 
 * Result = 5
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

			for (int i = 0; i < n; i++) {
				if (ps[i] + rs[n - 1 - i] < k) {
					c++;
				} else {
					break;
				}
			}

			System.out.println(c % 1000000007);

		}

	}

	/**
	 * To get maximum sum of a subsequent array.
	 * 
	 * @param a
	 * @return
	 */
	public static int maxSubsequenceSum(int[] a) {
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			maxSum = Math.max(maxSum, maxSum + a[i]);
		}
		return maxSum;
	}

	/**
	 * To get maximum sum of a subsequent array.
	 * 
	 * @param a
	 *            - array of integers
	 * @param threshold
	 *            - threshold to be tested for
	 * @return int array, first element is maximum sum and second element is
	 *         count where increasing subsequence less than threshold value.
	 */
	public static int[] maxSubsequenceSum(int[] a, int threshold) {
		int maxSum = 0;
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < threshold) {
				c++;
			}
			if (maxSum + a[i] < threshold) {
				c++;
			}
			maxSum = Math.max(maxSum, maxSum + a[i]);
		}
		return new int[] { maxSum, c };
	}

	/**
	 * To get maximum sum of a subsequent array.
	 * 
	 * @param a
	 *            - array of integers
	 * @param threshold
	 *            - threshold to be tested for
	 * @return integer array, first element is maximum sum and second element is
	 *         count where increasing subsequence less than threshold value.
	 */
	public static int maxSubsequence(int[] a, int threshold) {
		int count = 0;

		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			int sum = a[i];
			if (a[i] < threshold) {
				count++;
				for (int j = 0; j < a.length; j++) {
					if (i != j) {
						if (sum + a[j] < threshold) {
							sum += a[j];
							count++;
						} else {
//							TODO
							if (a[i] + a[j] < threshold){
								count++;
								sum = a[i] + a[j];
							}
							
						}
					}
				}
			}
		}
		return count;
	}
}
