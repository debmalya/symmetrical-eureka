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
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			scanner.nextLine();
			for (int i = 0; i < t; i++) {
				String[] students = scanner.nextLine().split(" ");
				int n = Integer.parseInt(students[0]);
				int k = Integer.parseInt(students[1]);
				
				String[] arrivals = scanner.nextLine().split(" ");
				for (int j = 0; j < arrivals.length; j++) {
					
				}
			}

		} catch (Throwable th) {

		}

	}

}
