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
}
