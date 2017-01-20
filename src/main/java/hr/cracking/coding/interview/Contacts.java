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
package hr.cracking.coding.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Contacts {

	// As all letters in lower case, so there can be maximum 26 entries.
	static TrieNode[] _dictionary = new TrieNode[26];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			in.nextLine();
			for (int i = 0; i < n; i++) {
				String[] commands = in.nextLine().split(" ");
				if ("add".equals(commands[0])) {
					add(commands[1]);
				} else if ("find".equals(commands[0])) {
					System.out.println(find(commands[1]));
				}
			}
		}

	}

	/**
	 * @param contact
	 *            to be searched.
	 */
	public static int find(String contact) {
		int occurrences = 0;
		TrieNode[] head = _dictionary;
		for (int i = 0; i < contact.length(); i++) {
			if (head[contact.charAt(i) - 'a'] == null) {
				// contact does not exist
				occurrences = 0;
				break;
			} else {
				occurrences = head[contact.charAt(i) - 'a'].count;
				head = head[contact.charAt(i) - 'a'].children;
			}
		}
		return occurrences;

	}

	/**
	 * Adds a contact.
	 * 
	 * @param contact
	 *            to be added.
	 */
	public static void add(String contact) {
		TrieNode[] head = _dictionary;
		for (int i = 0; i < contact.length(); i++) {
			int charIndex = contact.charAt(i) - 'a';
			if (head[charIndex] == null) {
				head[charIndex] = new TrieNode();
			}
			head[charIndex].count++;
			head = head[charIndex].children;

		}
	}

	/**
	 * 
	 */
	private static void print() {
		TrieNode[] head = _dictionary;
		for (int i = 0; i < 26; i++) {
			while (head[i] != null) {
				char c = (char) ('a' + i);
				System.out.println(c + " occurs " + head[i].count);
				head = head[i].children;
			}
		}

	}

	static class TrieNode {
		int count = 0;
		// As all letters in lower case, so there can be maximum 26 entries.
		TrieNode[] children = new TrieNode[26];

	}

}
