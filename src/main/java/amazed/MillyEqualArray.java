/**
 * 
 */
package amazed;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
		try (Scanner scanner = new Scanner(System.in)){
			int t = scanner.nextInt();
			String[] answers = new String[t];
			for (int i = 0; i < t; i++){
				int n = scanner.nextInt();
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				
				int[] ar = new int[n];
				Map<Integer,Set<Integer>> factors = new HashMap<>();
				
				for (int j = 0; j < n; j++) {
					ar[j] = scanner.nextInt();
				}
				factors.clear();
			}
			
			for (int i = 0; i < t; i++){
				System.out.println(answers[i]);
			}
		}

	}

}
