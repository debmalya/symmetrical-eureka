package sap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author debmalyajash
 *
 */
public class MicorNInternship {

	/**
	 * The task involves a tree having N nodes.Each node of the tree is having
	 * an integer value assigned to it. The values of all the nodes are given in
	 * array A. There are Q queries. Each query asks the number of distinct
	 * integers in the path from a node U to node V.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// First line of input consists of a single integer denoting N.
			int n = scanner.nextInt();
			int[] a = new int[n];
			// Second line consists of N space separated integer denoting the
			// array A
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			// Following N−1 lines consists of two space separated integers X
			// and Y, denoting there is an edge between X and Y.

			boolean[][] c = new boolean[n][n];
			for (int i = 0; i < n - 1; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				c[x - 1][y - 1] = true;
				c[y - 1][x - 1] = true;
			}

			// The next line consists of a single integer denoting q.
			int q = scanner.nextInt();
			int[] answers = new int[q];
			for (int i = 0; i < q; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				Set<Integer> w = new HashSet<Integer>();
				w.add(a[u - 1]);
				if (c[u - 1][v - 1]) {
					w.add(a[v - 1]);
				} else {
					// what are the common connections ?
					for (int j = 0; j < n; j++) {

						if (c[u - 1][j] == c[v - 1][j] && c[v - 1][j]) {
							w.add(a[j]);
						}
					}
				}

				answers[i] = w.size();
			}

			for (int i = 0; i < q; i++) {
				System.out.println(answers[i]);
			}
		}

	}

}
