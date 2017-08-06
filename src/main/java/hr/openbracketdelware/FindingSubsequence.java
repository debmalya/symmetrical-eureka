/**
 * Copyright 2015-2017 Debmalya Jash
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
package hr.openbracketdelware;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class FindingSubsequence {

	

	/**
	 * You have a string s and an integer k. You have to find another string t which have the following properties:
	 * t must be a subsequence of s.
	 * @param s
	 * @param k
	 * @return
	 */
	static String solve(String s, int k) {
		// Complete this function
		if (s != null) {
			LinkedHashMap<Character, Integer> cMap = new LinkedHashMap<>();
			List<Character> replaceList = new ArrayList<>();
			char f = s.charAt(0);
			s = s.replace(""+f, " ");
			int maxChar='a';
			int maxCharPosition = -1;
			
			for (int i = 1; i < s.length(); i++) {
				char current = s.charAt(i);
				if (current > f) {
					Integer occurence = cMap.get(current);
					if (occurence == null) {
						occurence = 0;
					}
					occurence++;
					cMap.put(current, occurence);
					
					if (current > maxChar) {
						maxChar = current;
						maxCharPosition = i;
					}
				} else {
					replaceList.add(current);
				}
			}
			
			for (Character each:replaceList) {
				s = s.replace(""+each, " ");
			}
			
			Set<Entry<Character, Integer>> entrySet = cMap.entrySet();
			Iterator<Entry<Character, Integer>> entryIterator = entrySet.iterator();
			while (entryIterator.hasNext()) {
				Entry<Character, Integer> nextEntry = entryIterator.next();
				if (nextEntry.getValue() < k) {
					s = s.replace(""+nextEntry.getKey(), "");
				}
			}
			s = s.substring(maxCharPosition).replace(" ", "");
			
			return s;
		}
		return "";
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String s = in.next();
			int k = in.nextInt();
			String result = solve(s, k);
			System.out.println(result);
			in.close();
		}
	}

}
