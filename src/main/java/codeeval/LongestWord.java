/**
 * 
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author djash
 */
public class LongestWord {

	/**
	 * Your program should accept as its first argument a path to a filename.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > -1) {
			readFromFile(args[0]);
		}
	}

	/**
	 * find the longest word in a sentence. If the sentence has more than one
	 * word of the same length you should pick the first one.
	 * 
	 * @param arg
	 */
	private static void readFromFile(final String arg) {

		String longestWord = "";
		try (BufferedReader bf = new BufferedReader(new FileReader(arg))) {
			String eachLine;
			while ((eachLine = bf.readLine()) != null) {
				String[] values = eachLine.split(" ");
				for (String each : values) {
					if (each.length() > longestWord.length()) {
						longestWord = each;
					}
				}
				System.out.println(longestWord);
				longestWord = "";
			}
		} catch (IOException ex) {

		}

	}
}
