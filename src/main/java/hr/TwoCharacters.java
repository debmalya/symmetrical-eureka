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
package hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class TwoCharacters {

	private static int[] characterCount = new int[26];
	private static int typeOfCharacters = 0;
	private static String str;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int len = in.nextInt();
			String s = in.next();

			// remove two same adjacent characters
			int numberOfSameAdjacentCharacters = 1;
			str = s;
			while (numberOfSameAdjacentCharacters > 0) {
				numberOfSameAdjacentCharacters = removeTwoSimilarAdjacentCharacters();
			}

			// maximum length with two alternating characters
			while (typeOfCharacters != 2) {

			}

			System.out.println();

		}
	}

	/**
	 * @param s
	 * @return
	 */
	private static int removeTwoSimilarAdjacentCharacters() {
		char prev = ' ';
		List<Character> charactersToBeRemoved = new ArrayList<>();
		typeOfCharacters = 0;
		int count = 0;
		;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == prev) {
				charactersToBeRemoved.add(c);
				characterCount[c - 'a'] = 0;
				count++;
			}

			if (!charactersToBeRemoved.contains(c)) {
				characterCount[c - 'a']++;
				if (characterCount[c - 'a'] == 1) {
					typeOfCharacters++;
				}
			}

			prev = c;
		}

		for (Character c : charactersToBeRemoved) {
			str = str.replace("" + c, "");
			typeOfCharacters--;
		}
		return count - 1;
	}

	/**
	 * @param s
	 * @param charactersToBeRemoved
	 * @param characterCount
	 */
	public static void createStringWithAllternateSameCharacter(String s, List<Character> charactersToBeRemoved,
			int[] characterCount) {

		// Remove those single occurrence characters.
		int typeOfCharacters = 0;
		if (s.length() > 2) {
			for (int i = 0; i < 26; i++) {
				if (characterCount[i] == 1) {
					s = s.replace("" + (char) ('a' + i), "");
				} else if (characterCount[i] > 0) {
					typeOfCharacters++;
				}
			}
		}

		while (typeOfCharacters == 2) {

		}

		System.out.println(s.length());
	}

}
