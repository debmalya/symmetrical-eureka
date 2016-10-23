package hr;

import java.util.Scanner;

/**
 * Tree with each node has a distinct integer (1 to n). Each node has a color.
 * 
 * @author debmalyajash
 *
 */
public class DistinclyColouredNodesInATree {

	/**
	 * if the value is true means connected
	 */
	private static boolean[][] connections;
	
	private static int[] c;
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			c = new int[n];
			for (int i = 0; i < n; i++) {
				c[i] = in.nextInt();
			}

			for (int i = 0; i < n - 1; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				connect(u,v);
			}
		}

	}

	private static void connect(int u, int v) {
		// TODO Auto-generated method stub
		
	}

}
