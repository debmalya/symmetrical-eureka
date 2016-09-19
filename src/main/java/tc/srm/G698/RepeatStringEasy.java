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
package tc.srm.G698;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A string S is called a square if there is some string T such that S = T + T.
 * For example, the strings "", aabaab" and "xxxx" are squares, but "a", "aabb
 * " and "aabbaa" are not.
 * 
 * You are given a s. Find the longest square string that can be obtained from s
 * by erasing some (possibly none, possibly all) of its characters. In other
 * words, we are looking for the longest square that occurs in s as a
 * subsequence. Return the length of that square.
 * 
 * Note that the answer is well-defined, as the square "" (the empty string)
 * will always occur in s as a subsequence.
 * 
 * @author debmalyajash
 *
 */
public class RepeatStringEasy {
	
	public int maximalLength(String s) {
        int maximalLength = 0;
        s = removeCharactersWithOneIncidence(s);
        for (String substring : substringSet(s)) {
            if (substring.length() > maximalLength && isSquare(substring)) {
                maximalLength = Math.max(substring.length(), maximalLength);
            }
        }
        return maximalLength;
    }
	
	/**
	 * Remove character with single occurrence.
	 * @param s - String to be checked.
	 * @return
	 */
	private String removeCharactersWithOneIncidence(String s) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(characterFrequency.get(c) == null) {
                characterFrequency.put(c, 1);
            } else {
                characterFrequency.put(c, characterFrequency.get(c) + 1);
            }
        }
        for(Character c: s.toCharArray()) {
            if(characterFrequency.get(c) == 1) {
                s = s.replace("" + c, "");
            }
        }
        return s;
    }
	
	private boolean isSquare(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() / 2 + i)) {
                return false;
            }
        }
        return true;
    }
	
	private Set<String> substringSet(String s) {
        Set<String> substringSet = new HashSet<>();
        if (s.length() <= 1) {
            substringSet.add(s);
            return substringSet;
        }
        Set<String> s1Set = substringSet(s.substring(0, 1));
        Set<String> s2Set = substringSet(s.substring(1));
        substringSet.addAll(s1Set);
        substringSet.addAll(s2Set);
        for (String s1 : s1Set) {
            for (String s2 : s2Set) {
                substringSet.add(s1 + s2);
            }
        }
        return substringSet;
    }

	
	
	public int maximalLength1(String s) {
		Set<Character> u = new HashSet<>();
		Set<Character> d = new HashSet<>();
		int[] c = new int[26];
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char prev = ' ';
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			c[a- 'a']++;
			if (!u.add(s.charAt(i))) {
				count++;
				d.add(s.charAt(i));
				sb.append(s.charAt(i));
			} else {

			}
			prev = a;
		}
		System.out.println(sb.toString());
		Arrays.sort(c);
		System.out.println(Arrays.toString(c)+ " " + s.length());
		System.out.println("---------------------");
		

		return count*2;
	}
	
	public int maximalLength0(String s) {
		Set<Character> u = new HashSet<>();
		Set<Character> d = new HashSet<>();
		int[] c = new int[26];
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			c[a- 'a']++;
			if (!u.add(s.charAt(i))) {
				count++;
				d.add(s.charAt(i));
				sb.append(s.charAt(i));
			} else {

			}
		}
		System.out.println(sb.toString());
		System.out.println(Arrays.toString(c));
		System.out.println("---------------------");
		

		return count*2;
	}
}
