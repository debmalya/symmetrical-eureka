/**
 * 
 */
package ht;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class WordUnscrumbler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			List<String> wordList = new ArrayList<>();

			Files.lines(Paths.get("words9.txt")).forEach(line -> {
				char[] chArr = line.toCharArray();
				Arrays.sort(chArr);
				wordList.add(String.valueOf(chArr));

			});
			
			
			int N = scanner.nextInt();
			scanner.nextLine();
			int min = Integer.MAX_VALUE;
			int minIndex = Integer.MAX_VALUE;
			String[] entries = new String[N];
			for (int i = 0; i < N; i++) {
				entries[i] = scanner.nextLine();
				char[] entriesChar = entries[i].toCharArray();
				Arrays.sort(entriesChar);
				entries[i] = String.valueOf(entriesChar);
				int currentPosition = wordList.indexOf(entries[i]);
				if (min > currentPosition) {
					min = currentPosition;
					minIndex = i + 1;
				}

			}
			System.out.println(minIndex);

		} catch (Throwable th) {
			System.err.println(th.getMessage());
		}

	}

}
