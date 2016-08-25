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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Names identify ourselves.
 * 
 * @author debmalyajash
 *
 */
public class Names {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Names self = new Names();
		String[] names = new String[] { "Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban" };
		System.out.println(Arrays.toString(self.chainNames(names)));

	}

	/**
	 * You're given an array of names, where each name is given as a string.
	 * Your task is to link these names into a chain, so that the ith name
	 * starts with the same letter the (i - th)th name ends, and return this
	 * chain as a list.
	 * 
	 * All names should be used. It is guaranteed that each name starts with a
	 * unique letter. It is also guaranteed that there is only one solution.
	 * 
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * names = ["Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"] the
	 * output should be
	 * 
	 * chainNames(names) = ["Peter", "Raymond", "Daniel", "Louie", "Esteban",
	 * "Nora"]
	 * 
	 * @param names
	 * @return
	 */
	String[] chainNames(String[] names) {

		// Find the first name to put in the chain.
		// Whose first letter of name is not end letter of anybody's name.
		Map<Character, String> f = new HashMap<>();
		Map<Character, String> l = new HashMap<>();
		List<String> nl = new ArrayList<>();

		for (String e : names) {
			f.put(Character.toLowerCase(e.charAt(0)), e);
			l.put(e.charAt(e.length() - 1), e);
		}

		String a = "";
		 Iterator<Character> i = f.keySet().iterator();
		while (i.hasNext()) {
			Character n = i.next();
			String p = l.get(n);
			if (p == null) {
				// this will be the first name.
				a = f.get(n);
				nl.add(a);
				String b = f.get(a.charAt(a.length() - 1));
				while (b != null) {
					nl.add(b);
					a = b;
					b = f.get(a.charAt(a.length() - 1));
					if (nl.size() == names.length){
						break;
					}
				}

				break;
			}
		}

		return nl.toArray(new String[0]);

	}

	String[] chainNames0(String[] names) {

		// Find the first name to put in the chain.
		// Whose first letter of name is not end letter of anybody's name.
		Map<Character, String> f = new HashMap<>();
		Map<Character, String> l = new HashMap<>();
		List<String> nl = new ArrayList<>();

		for (String e : names) {
			f.put(Character.toLowerCase(e.charAt(0)), e);
			l.put(e.charAt(e.length() - 1), e);
		}

		String a = "";
		Iterator<Entry<Character, String>> i = f.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Character, String> n = i.next();
			String p = l.get(n.getKey());
			if (p == null) {
				// this will be the first name.
				a = n.getValue();
				nl.add(a);
				String b = f.get(a.charAt(a.length() - 1));
				while (b != null) {
					nl.add(b);
					a = b;
					b = f.get(a.charAt(a.length() - 1));
				}

				break;
			}
		}

		return nl.toArray(new String[0]);

	}

}
