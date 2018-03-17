package vaadin;

import java.util.Arrays;

public class Minimal {

	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return lowest common minimum number, if no such number return -1.
	 */
	int solution(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		for (int k = 0; k < n; k++) {
			while (i < m - 1 && B[i] < A[k])
				i += 1;
			if (A[k] == B[i])
				return A[k];
		}
		return -1;
	}

}
