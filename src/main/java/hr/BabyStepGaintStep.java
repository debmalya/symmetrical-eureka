package hr;

import java.util.Scanner;

public class BabyStepGaintStep {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int q = in.nextInt();
			int[] ans = new int[q];
			for (int i = 0; i < q; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int d = in.nextInt();
				ans[i] = getAnswer(a, b, d);
			}

			for (int i = 0; i < q; i++) {
				System.out.println(ans[i]);
			}
		}

	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param d
	 *            distance needs to be covered.
	 * @return
	 */
	public static int getAnswer(int a, int b, int d) {
		if (d == 0)
			return 0;
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int diff = max - min;
		if (d % max == 0) {
			return d / max;
		} else if ((d % max) % min == 0) {
			if (d % max > max / 2) {
				return d / max + (d % max) / min;
			} else {
				
			}
		} else if (d < max && d < min && d % diff == 0) {
			return (d / diff) * 2;
		} else if (d < max && d > min && d % min == 0) {
			return d / min;
		} else if (d < max && d > min && d % min == 0) {
			return d / min;
		}
		return 0;
	}

}
