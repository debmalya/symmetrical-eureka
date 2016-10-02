package he;

import java.util.Scanner;

public class VyasavsRhezo {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
			int[] A = new int[N];
			int[] B = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = in.nextInt();
			}

			for (int i = 0; i < N; i++) {
				B[i] = in.nextInt();
			}

			int Q = in.nextInt();
			int[] L = new int[Q];
			int[] R = new int[Q];

			int[] answer = new int[Q];
			
			for (int i = 0; i < Q; i++) {
				L[i] = in.nextInt() - 1;
				R[i] = in.nextInt() - 1;
				
				int aMax = Integer.MIN_VALUE;
				int index = -1;
				
				for (int j = L[i]; j <= R[i]; j++) {
					if (A[j] > aMax) {
						aMax = A[j];
						index = j;
					} else if (A[j] == aMax) {
						if (B[j] < B[index]) {
							index = j;
						}
					}
				}
				
				answer[i] = index + 1;
			}
			
			for (int i = 0; i < Q; i++){
				System.out.println(answer[i]);
			}
			
		}

	}

}
