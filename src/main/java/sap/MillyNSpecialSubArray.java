package sap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Milly is playing with an array A of size N. She is trying to find those
 * non-empty subarrays (sequence of consecutive elements) whose maximum and
 * minimum values are identical. Milly got confused while counting. Your task is
 * to help her in this problem.
 * 
 * @author debmalyajash
 *
 */
public class MillyNSpecialSubArray {

	public static void main(String[] args) {
		// First line of the input will contain T denoting the number of
		// test-cases.
		try (Scanner scanner = new Scanner(System.in)){
			int t = scanner.nextInt();
			int[] answers = new int[t];
			for (int i = 0; i < t; i++){
				int n = scanner.nextInt();
				int[] a = new int[n];
				for (int j = 0; j < n; j++){
					a[j] = scanner.nextInt();
				}
				answers[i] = getNumberOfSubArrays(a);
			}
			
			for (int i = 0; i < t; i++){
				System.out.println(answers[i]);
			}
		}

	}

	public static int getNumberOfSubArrays(int[] a) {
		Arrays.sort(a);
		int r = a.length;
		int[] c = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i -1]){
				c[i] = c[i - 1] + 1;
				r += c[i];
				
			}
		}
		return r;
	}

}
