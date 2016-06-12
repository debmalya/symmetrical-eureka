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
			String[] result = new String[t];
			scanner.nextLine();
			for (int i = 0; i < t; i++) {
				String[] students = scanner.nextLine().split(" ");
				int n = Integer.parseInt(students[0]);
				int k = Integer.parseInt(students[1]);
				
				String[] arrivals = scanner.nextLine().split(" ");
				int count =0;
				for (int j = 0; j < n; j++) {
					int value = Integer.parseInt(arrivals[j]);
					if (value >= 0) {
						count++;
					}
				}
				
				if (count <= k){
					result[i] = "YES";
				} else {
					result[i] = "NO";
				}
			}
			
			for (int i = 0; i < t; i++) {
				System.out.println(result[i]);
			}

		} catch (Throwable th) {

		}

	}

}
