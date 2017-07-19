/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hr.weekOfCode34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumGCD {

	static class Number implements Comparable<Number> {

		List<Integer> primeFactors = new ArrayList<>();

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Number o) {
			return primeFactors.size() - o.primeFactors.size();
		}

	}

	/**
	 * You are given two arrays A and B containing n elements each. Choose a
	 * pair of elements (x,y) such that: x belongs to array A. y belongs to
	 * array B. gcd(x,y) is the maximum of all pairs (x,y).
	 * 
	 * If there is more than one such pair having maximum gcd, then choose the
	 * one with maximum sum. Print the sum of elements of this maximum-sum pair.
	 * 
	 * Constraints 1 <= n <= 500000 1 <= A[i] <= 1000000 1 <= B[i] <= 1000000
	 * 
	 * @param A
	 *            an array of integer.
	 * @param B
	 *            an array of integer.
	 * @return maximum-sum pair.
	 */
	
	public static int maximumGcdAndSum(int[] A, int[] B) {
		// Complete this function
		Arrays.sort(A);
		Arrays.sort(B);

		int maxA = 0;
		int maxB = 0;
		int maxGCD = 0;
		int n = B.length;

		for (int i = n - 1; i > -1; i--) {
			if (!(maxGCD >= A[i])) {
				for (int j = n - 1; j > -1; j--) {
					if (!(maxGCD >= B[j])) {
						int gcd = gcd(A[i], B[j]);
						if (gcd > maxGCD) {
							maxGCD = gcd;
							maxA = A[i];
							maxB = B[j];
						}
//						if (gcd == 1 && (isPrime(B[j]) || isPrime(A[i])) || Arrays.binarySearch(A, B[j]) < 0) {
//							break;
//						}
					} else {
//						System.out.println("2 " + B[j]+ " maxGCD " + maxGCD);
						return maxA + maxB;
					}
					
				}
			} else {
//				System.out.println("1 maxGCD :" + maxGCD);
				return maxA + maxB;
			}
		}

//		System.out.println("Here maxGCD :" + maxGCD);
		return maxA + maxB;
	}
	
	/**
	 * @param i
	 * @param j
	 * @return
	 */
	public static int gcd(int i, int j) {
		while (j != 0) {
			int m = i % j;
			i = j;
			j = m;
		}
		return i;
	}
	
	public static boolean isPrime(int i) {
		for (int j = 2; j < Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] A = new int[n];
			for (int A_i = 0; A_i < n; A_i++) {
				A[A_i] = in.nextInt();
			}
			int[] B = new int[n];
			for (int B_i = 0; B_i < n; B_i++) {
				B[B_i] = in.nextInt();
			}
			int res = maximumGcdAndSum(A, B);
			System.out.println(res);
		}
	}
}
