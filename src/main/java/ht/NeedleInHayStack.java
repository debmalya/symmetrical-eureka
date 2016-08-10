package ht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * write a program that searches for a needle in the hay stack and returns every
 * position within searching line. Put differently, write a program that finds
 * all occurrences of a given pattern in a given input string.
 * 
 * A needle – is a sequence of characters (0-255), the length can be any.
 * 
 * The haystack – is a sequence of characters (big string) to search in.
 * 
 * The program has to detect all occurrences of the needle in the haystack. It
 * should take the needle and the haystack as input, and output the positions of
 * each occurrence, as shown below. The suggested implementation is the KMP
 * algorithm, but this is not a requirement. However, a naive approach will
 * probably exceed the time limit, whereas other algorithms are more
 * complicated... The choice is yours.
 * 
 * Input
 * 
 * The input consists of a number of test cases. Each test case is composed of
 * three lines, containing:
 * 
 * the length of the needle, the needle itself, the haystack. The length of the
 * needle is only limited by the memory available to your program, so do not
 * make any assumptions - instead, read the length and allocate memory as
 * needed. The haystack is not limited in size, which implies that your program
 * should not read the whole haystack at once. The KMP algorithm is
 * stream-based, i.e. it processes the haystack character by character, so this
 * is not a problem.
 * 
 * The test cases come one after another, each occupying three lines, with no
 * additional space or line breaks in between.
 * 
 * 
 * Output
 * 
 * For each test case your program should output all positions of the needle's
 * occurrences within the haystack. If a match is found, the output should
 * contain the position of the first character of the match. Characters in the
 * haystack are numbered starting with zero.
 * 
 * For a given test case, the positions output should be sorted in ascending
 * order, and each of these should be printed in a separate line. For two
 * different test cases, the positions should be separated by an empty line.
 * 
 * @author debmalyajash
 *
 */
public class NeedleInHayStack {

	public static void main(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> answers = new ArrayList<>();
			while (scanner.hasNextLine()) {
				try {
					int lengthOfNeedle = Integer.parseInt(scanner.nextLine());
					String needle = scanner.nextLine();
					String haystack = scanner.nextLine();
					answers.addAll(needleInHayStack(needle, haystack, lengthOfNeedle));
				} catch (Throwable neverMind) {
					break;
				}
			}
			
			for (String each:answers) {
				System.out.println(each);
			}

		}
	}

	/**
	 * Get all the position where needle have been found.
	 * 
	 * @param needle
	 *            - String for the needle.
	 * @param hayStack
	 *            - String for the hayStack.
	 * @return - list of the positions where needle found. Blank list if needle
	 *         not found.
	 */
	public static List<String> needleInHayStack(String needle, String hayStack, int lengthOfNeedle) {
		List<String> positionList = new ArrayList<>();
		
		for (int i = 0; i < hayStack.length() - lengthOfNeedle + 1; i++) {
			if (hayStack.substring(i, i + lengthOfNeedle).equals(needle)){
				positionList.add(String.valueOf(i));
			}
			
		}
		if (positionList.isEmpty()) {
			positionList.add("");
		}
		return positionList;
	}
}
