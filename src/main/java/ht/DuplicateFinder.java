/**
 * 
 */
package ht;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class DuplicateFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			scanner.nextLine();
			String[] values = scanner.nextLine().split(" ");
			System.out.println(getDuplicate(N, values));
		}

	}

	/**
	 * @param n
	 * @param values
	 * @return
	 */
	public static String getDuplicate(int n, String[] values) {
		Set<String> uniquea = new HashSet<>();
		String dup = "";
		int size = values.length - 1;
		for (int i = 0; i < values.length; i++) {
			if (!uniquea.add(values[i])) {
				dup = values[i];
				if (Integer.parseInt(dup) <= n) {
					break;
				}
			} else if (!uniquea.add(values[ size - i])){
				dup = values[size - i];
				if (Integer.parseInt(dup) <= n) {
					break;
				}
			}
	
		}
		return dup;
	}

}
