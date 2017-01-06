package hr;

import java.util.Scanner;

public class BetweenTwoSets {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] a = new int[n];

			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}

			int[] b = new int[m];

			for (int b_i = 0; b_i < m; b_i++) {
				b[b_i] = in.nextInt();
			}

			System.out.println(getNumbersBetweenSets(a, b));
		}

	}

	public static int getNumbersBetweenSets(int[] a, int[] b) {
		int lcm_a = lcm(a);
		int lcm_b = gcd(b);
		if (lcm_a != lcm_b) {
			lcm_a = gcd(lcm_a, lcm_b);
		}
		return (b[0] - a[a.length - 1]) / lcm_a;
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static int gcd(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; i++)
			result = gcd(result, input[i]);
		return result;
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	private static int lcm(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; i++)
			result = lcm(result, input[i]);
		return result;
	}

}
