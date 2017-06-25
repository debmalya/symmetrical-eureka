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
package cf;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author debmalyajash
 *
 */
public class StringUtil {

	boolean IsPermutationOf0(String leftString, String rightString) {
		SortedSet<Character> l = new TreeSet<>();
		SortedSet<Character> r = new TreeSet<>();
		for (int i = 0; i < leftString.length(); i++) {
			l.add(leftString.charAt(i));
		}

		for (int i = 0; i < rightString.length(); i++) {
			l.add(rightString.charAt(i));
		}

		return l.equals(r);
	}

	boolean IsPermutationOf1(String leftString, String rightString) {
		SortedMap<Character, Integer> l = new TreeMap<>();
		SortedMap<Character, Integer> r = new TreeMap<>();

		for (int i = 0; i < leftString.length(); i++) {
			char c = leftString.charAt(i);
			Integer co = l.get(c);
			if (co == null) {
				co = 0;
			}
			co++;
			l.put(c, co);
		}

		for (int i = 0; i < rightString.length(); i++) {
			char c = rightString.charAt(i);
			Integer co = l.get(c);
			if (co == null) {
				co = 0;
			}
			co++;
			r.put(c, co);
		}

		return l.equals(r);
	}

	public static boolean IsPermutationOf(String leftString, String rightString) {
		int[] lc = new int[26];
		int[] rc = new int[26];
		char[] l = leftString.toLowerCase().toCharArray();
		for (int i = 0; i < l.length; i++) {
			lc[l[i] - 'a']++;
		}

		char[] r = rightString.toLowerCase().toCharArray();
		for (int i = 0; i < r.length; i++) {
			rc[r[i] - 'a']++;
		}

		return Arrays.equals(lc, rc);
	}

	/**
	 * Truncate a text with HTML tags up to the given position. The trick is,
	 * the string must be truncated only by the plain text, ignoring tags. For
	 * each opening tag there is a closing tag, and there are no nested tags.It
	 * is also guaranteed that symbols < and > appear only in HTML tags.
	 * 
	 * @param text
	 *            containing HTML tags.
	 * @param position
	 *            given position.
	 * @return The returned text should also contain only valid HTML tags. If
	 *         the text should be truncated in the middle of some text wrapped
	 *         into the tags, the resulting string should not contain this tag.
	 * 
	 *         Example: For text =
	 *         "You ordered <b>two</b> pizzas with <i>mushrooms</i> and vanilla <i>milkshake</i>."
	 *         and position = 50, the output should be
	 * 
	 *         truncateOnlyText(text, position) =
	 *         "You ordered <b>two</b> pizzas with <i>mushrooms</i> and vanilla "
	 */
	public static String truncateOnlyText(String text, int position) {
		StringBuilder t = new StringBuilder();
		int start = 0;
		int end = 0;
		int s = 0;
		int i = 0, l = 0;
		int e = 0;
		char p = ' ';
		for (; i < text.length(); i++) {
			char c = text.charAt((i));
			if (c == '<') {
				s = 1;
				start = i;
			}
			if (s == 0) {
				l++;
			}
			if (l == position) {
				break;
			}
			if (s == 1) {
				t.append(c);
			}
			if (c == '>') {
				s = 0;
				end = i;
				if (e == 1) {
					t.delete(0, t.length());
					e = 0;
				}

			}
			if (p == '/' && s == 1) {
				// Beginning of end
				e = 1;
			}
			p = c;
		}

		// What next, any HTML tag?
		String a = "";
		if (i < text.length() - 1) {
			if (text.charAt(i + 1) == '<' && text.charAt(i) != ' ') {
				int j = i + 1;
				p = text.charAt(j);
				while (p != '>') {
					a += p;
					j++;
					p = text.charAt(j);
				}
				a += ">";
			}
		}
		if (t.length() == 0) {
			return text.substring(0, i + 1) + a;
		} else {
			return text.substring(0, start) + text.substring(end + 1, i + 1) + a;
		}
	}

	/**
	 * Convert upper case letter to lower and lower case letter to upper.
	 * 
	 * @param input
	 *            string
	 * @return toggled string
	 */
	public static String toggle(final String input) {
		char[] inputArr = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				// convert to lower case
				inputArr[i] = (char) (ch + 'a' - 'A');
			} else if (ch >= 'a' && ch <= 'z') {
				// convert to upper case
				inputArr[i] = (char) (ch + 'A' - 'a');
				;
			}

		}
		return String.valueOf(inputArr);
	}

	/**
	 * You have been given a string s, which is supposed to be a sentence.
	 * However, someone forgot to put spaces between the different words, and
	 * for some reason they capitalized the first letter of every word. Return
	 * the sentence after making the following amendments:
	 * 
	 * Put a single space between the words. Convert the uppercase letters to
	 * lowercase. Example
	 * 
	 * For s = "CodefightsIsAwesome", the output should be amendTheSentence(s) =
	 * "codefights is awesome"; For s = "Hello", the output should be
	 * amendTheSentence(s) = "hello". Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] string s
	 * 
	 * A string containing uppercase and lowercase English letters.
	 * 
	 * Guaranteed constraints:
	 * 
	 * 3 ≤ s.length ≤ 100.
	 * 
	 * [output] string
	 * 
	 * The amended sentence.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public String amendTheSentence(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'A' && ch <= 'Z' && i > 0) {
				sb.append(" ");
			}
			sb.append(ch);
		}
		return sb.toString().toLowerCase();
	}

	/**
	 * Avoid using built-in functions to solve this challenge. Implement them
	 * yourself, since this is what you would be asked to do during a real
	 * interview.
	 * 
	 * Implement a function that takes two strings, s and x, as arguments and
	 * finds the first occurrence of the string x in s. The function should
	 * return an integer indicating the index in s of the first occurrence of x.
	 * If there are no occurrences of x in s, return -1.
	 * 
	 * Example
	 * 
	 * For s = "CodefightsIsAwesome" and x = "IA", the output should be
	 * strstr(s, x) = -1; For s = "CodefightsIsAwesome" and x = "IsA", the
	 * output should be strstr(s, x) = 10. Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] string s
	 * 
	 * A string containing only uppercase or lowercase English letters.
	 * 
	 * Guaranteed constraints: 1 ≤ s.length ≤ 106.
	 * 
	 * [input] string x
	 * 
	 * String, containing only uppercase or lowercase English letters.
	 * 
	 * Guaranteed constraints: 1 ≤ x.length ≤ 106.
	 * 
	 * [output] integer
	 * 
	 * An integer indicating the index of the first occurrence of the string x
	 * in s, or -1 if s does not contain x.
	 * 
	 * 
	 * @param s
	 * @param x
	 * @return
	 */
	public static int findFirstSubstringOccurrence(String s, String x) {
		int firstIndex = -1;
		char[] source = s.toCharArray();
		char[] target = x.toCharArray();

		int xl = x.length();
		int sl = s.length();

		int i = 0;
		int j = 0;

		while (true) {
			while (source[j] != target[i]) {
				j++;
				if (j == sl) {
					return -1;
				}
			}

			// match found
			firstIndex = j;
			while (target[i] == source[j]) {
				i++;
				j++;
				if (i == xl) {
					return firstIndex;
				}
				if (j == sl) {
					return -1;
				}
			}
			firstIndex = -1;
			i = 0;
			
		}

		

	}

}
