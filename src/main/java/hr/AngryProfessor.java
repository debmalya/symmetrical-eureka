/**
 * 
 */
package hr;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class AngryProfessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {

			int t = in.nextInt();
			String[] an = new String[t];
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				int k = in.nextInt();
				int a[] = new int[n];
				int c = 0;
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextInt();
					if (a[a_i] < 1) {
						c++;
					}
				}

				an[a0] = "YES";

				if (c >= k) {
					an[a0] = "NO";
				}
			}

			for (int a0 = 0; a0 < t; a0++) {
				System.out.println(an[a0]);
			}
		}

	}

}
