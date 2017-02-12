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
package hr.RookieRank2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class PrefixNeighbors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			String[] s = new String[n];
			for (int s_i = 0; s_i < n; s_i++) {
				s[s_i] = in.next();
			}

			System.out.println(getBenefitValues(s));
		}

	}



	/**
	 * 
	 * @param neighbors
	 * @return
	 */
	public static long getBenefitValues(final String[] neighbors) {
		long result = 0;
		Arrays.sort(neighbors);

		int index = 0;
		int[] neighbourIndex = new int[neighbors.length];
		int[] lengths = new int[neighbors.length];
		lengths[neighbors.length - 1] = neighbors[neighbors.length - 1].length();
		int continuityIndex = 0;

		for (int i = neighbors.length - 2; i > -1; i--) {
			if (!isPrefixNeighbour(neighbors[i], neighbors[i + 1])) {
				++index;
				continuityIndex =0;
			} else {
				++continuityIndex;
			}
			lengths[i] = neighbors[i].length();
			if (continuityIndex > 1 && neighbors[i].length() != neighbors[i+ 1].length()) {
				++index;
			}
			neighbourIndex[i] = index;
		}
		
		

		
		for (int i = 1; i < neighbors.length; i++) {
			if (neighbourIndex[i - 1] != neighbourIndex[i]) {
				result += benefitValue(neighbors[i - 1]);
			} 
		}
		
			
		result += benefitValue(neighbors[neighbors.length - 1]);
		return result;
	}

	/**
	 * The strings AB and ABD are prefix neighbors because AB is a prefix of
	 * ABD. The strings ABD and ABDE are also prefix neighbors.
	 * 
	 * @param word
	 *            first word.
	 * @param word1
	 *            second word.
	 * @return
	 */
	public static boolean isPrefixNeighbour(final String word, final String word1) {
		int len = word.length();
		int len1 = word1.length();
		int diff = Math.abs(len - len1);
		if (diff > 1) {
			return false;
		} else {
			if (len > len1) {
				if (word.substring(0, len1).equals(word1)) {
					return true;
				}
			} else if (word1.substring(0, len).equals(word)) {
				return true;
			} else if (len1 == len) {
				return word.startsWith(word1.substring(0, len1 - 1));
			}
		}

		return false;
	}

	/**
	 * 
	 * @param content
	 *            of the string.
	 * @return the sum of the ASCII values of its characters.
	 * 
	 * 
	 */
	public static long benefitValue(final String content) {
		long result = 0;
		for (int i = 0; i < content.length(); i++) {
			result += (content.charAt(i) - 'A' + 65);
		}
		return result;
	}

}
