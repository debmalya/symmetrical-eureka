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
		for (int i = 0; i < leftString.length(); i++){
			l.add(leftString.charAt(i));
		}
		
		for (int i = 0; i < rightString.length(); i++){
			l.add(rightString.charAt(i));
		}
		
		return l.equals(r);
	}

	boolean IsPermutationOf1(String leftString, String rightString) {
		SortedMap<Character,Integer> l = new TreeMap<>();
		SortedMap<Character,Integer> r = new TreeMap<>();
		
		for (int i = 0; i < leftString.length(); i++){
			char c = leftString.charAt(i);
			Integer co = l.get(c);
			if (co == null){
				co =0;
			}
			co++;
			l.put(c, co);
		}
		
		for (int i = 0; i < rightString.length(); i++){
			char c = rightString.charAt(i);
			Integer co = l.get(c);
			if (co == null){
				co =0;
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
		for (int i = 0; i < l.length; i++){
			System.out.println(l[i]+" " +(l[i]-'a'));
			lc[l[i]-'a']++;
		}
		
		char[] r = rightString.toLowerCase().toCharArray();
		for (int i = 0; i < r.length; i++){
			System.out.println(r[i]+" " +(r[i]-'a'));
			rc[r[i]-'a']++;
		}
		
		
		return Arrays.equals(lc, rc);
	}
}
