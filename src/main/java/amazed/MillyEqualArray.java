/**
 * 
 */
package amazed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MillyEqualArray {

	/**
	 * Milly is playing with a Array A of size N. She wants to make all the
	 * values of A to be equal. She can multiply any value any number of times
	 * by X, Y and Z. Your task is to tell her whether she can do it or not.
	 * Print "She can" if she can do it else print "She can't" without "".
	 * 
	 * Input
	 * 
	 * First line of the input will contain T (No. of test cases). For each test
	 * case, first line will contain four space separated integers denoting N,
	 * X, Y and Z. Then next line will contain N space separated integers of A
	 * Output
	 * 
	 * For every test case, print the required answer in a new line.
	 * 
	 * X, Y, Z ∈ {2, 3, 5, 7}
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			String[] answers = new String[t];
			for (int i = 0; i < t; i++) {
				int n = scanner.nextInt();
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();

				int[] ar = new int[n];

				for (int j = 0; j < n; j++) {
					ar[j] = scanner.nextInt();
				}
				Arrays.sort(ar);
				simplify(x, y, z, ar, 0);
				for (int j = 1; j < ar.length; j++) {
					simplify(x, y, z, ar, j);
					if (ar[j] != ar[0]) {
						answers[i] = "She can't";
						break;
					}
				}
				if (answers[i] == null) {
					answers[i] = "She can";
				}
			}

			for (int i = 0; i < t; i++) {
				System.out.println(answers[i]);
			}
		}

	}

	public static void simplify(int x, int y, int z, int[] ar, int j) {
		while (ar[j] % x == 0) {
			ar[j] /= x;
		}
		while (ar[j] % y == 0) {
			ar[j] /= y;
		}
		while (ar[j] % z == 0) {
			ar[j] /= z;
		}
	}

}
