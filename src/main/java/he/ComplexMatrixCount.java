package he;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComplexMatrixCount {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int x = in.nextInt();

			int[][] ma = new int[n][m];
			
			int totalOccurences = 0;

			int result = 0;
			List<Integer> rows = new ArrayList<>();
			List<Integer> cols = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					ma[i][j] = in.nextInt();
					
					if (ma[i][j] == x) {
						
						totalOccurences++;
						
						

						if (totalOccurences >= k) {
							// Start counting how many sub matrices possible
							// minimum two rows, two columns, at least two
							// corners have equal elements.
							if (rows.contains(i - 1) && cols.contains(j)){
								result += m - 1;
							}
							
							if (rows.contains(i + 1) && cols.contains(j)){
								result += m - 1;
							}
							
							if (cols.contains(j - 1) && rows.contains(i)){
								result += n - 1;
							}
							
							if (cols.contains(j + 1) && rows.contains(i)){
								result += n - 1;
							}
							
							if (rows.contains(i - 1) && cols.contains(j - 1)){
								// diagonal
								result++;
							}
							
							
							
							if (rows.contains(i + 1) && cols.contains(j - 1)){
								// diagonal
								result++;
							}
							
							for (int row = i - 2; row > -1; row-- ){
								if (rows.contains(row)){
									result++;
								}
							}
							
							for (int col = j - 2; col > -1; col-- ){
								if (cols.contains(col)){
									result++;
								}
							}
						}
						
						rows.add(i);
						cols.add(j);
					}
				}
			}
			System.out.println(result);
		}

	}
	
	
}
