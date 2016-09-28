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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

			System.out.println(getLongestAlternateLength());

		}
	}
	
	public static int makeString(char a,char b){
		int len = str.length();
		String temp = "";
		
		
		
		return 0;
	}

	public static int getLongestAlternateLength() {
		char a = 'a';
		int maxLength = 0;
		Set<String> alreadyProcessedString = new HashSet<>();
		for (int i = 0; i < 26; i++) {
			String s = str;
			s = s.replace("" + a, "");
			if (!alreadyProcessedString.contains(s) && altering(s)) {
				maxLength = Math.max(maxLength, s.length());
			}
			a++;
			alreadyProcessedString.add(s);
		}
		
		
		return maxLength;
	}

	/**
	 * @param s
	 * @return
	 */
	public static boolean altering(String s) {
		char[] v = s.toCharArray();
		if (s.length() < 2){
			return false;
		}
		for (int i = 2; i < s.length(); i++) {
			if (v[i -2] != v[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param s
	 * @return
	 */
	public static int removeTwoSimilarAdjacentCharacters() {
		char prev = ' ';
		List<Character> charactersToBeRemoved = new ArrayList<>();
		typeOfCharacters = 0;
		int count = 0;
		
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

	
	public static String getStr() {
		return str;
	}

	public static void setStr(String str1) {
		str = str1;
	}

}
