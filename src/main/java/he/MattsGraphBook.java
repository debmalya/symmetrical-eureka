package he;

import java.util.Scanner;

public class MattsGraphBook {

	private static boolean[][] connections;

	private static int size;

	private static int totalConnections = 0;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Number of vertices
			int n = in.nextInt();
			connections = new boolean[n][n];
			size = n;
			totalConnections = 0;

			// Number of edges
			int k = in.nextInt();

			for (int i = 0; i < k; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				connect(a, b);
			}

			int x = in.nextInt();
			
			if (isConnected(x)){
				System.out.println("Connected");
			} else {
				System.out.println("Not Connected");
			}

		}

	}

	public static void connect(int a, int b) {
		if (!connections[a][b]) {
			connections[a][b] = true;
			totalConnections++;
			totalConnections = 0;

		}

	}

	public MattsGraphBook(int n) {
		connections = new boolean[n][n];
		totalConnections = 0;
	}

	public static void remove(int x) {
		for (int i = 0; i < size; i++) {
			if (connections[i][x]){
				totalConnections--;
			}
			if (connections[x][i]){
				totalConnections--;
			}
			connections[i][x] = false;
			connections[x][i] = false;
		}
	}

	public static boolean isConnected(int x) {
		
		return totalConnections + 1 >= size;
	}
}
