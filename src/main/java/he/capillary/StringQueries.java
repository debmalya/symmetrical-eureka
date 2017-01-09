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
package he.capillary;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 * 
 *  
 *  	  Given a 1-indexed String S  of length  N, consisting
 *         of lowercase English alphabets, you need to answer queries based on
 *         the properties of this string.
 * 
 *         You shall be given Q  queries to answer. In each query you shall be
 *         given 2  integers L  and R. Now , you need to report the minimum
 *         number of String elements you need to delete in the substring of
 *         String S S ranging from L to R inclusive, so that each distinct
 *         character occurring in the range occurs equal number of times.
 * 
 *         For example, consider the String "abcdab" . Here, the
 *         characters occurring in this String are ′ a ′,′ b ′, ′ c ′
 *         ′c′ and ′ d ′′. On deleting one occurrence of ′ a ′  as well as
 *         ′ b ′ one of the possible Strings is a b c d abcd. Each character
 *         occuring in the range now occurs equal number of times. So, the
 *         minimum number of deletions is two.
 * 
 *         Note that we need to equalize the count of only characters that occur
 *         in the range, and not of characters that do not. It is allowed to
 *         delete all occurences of a character, so that it no longer occurs in
 *         the range at all
 * 
 *         Can you do it ?
 * 
 *         Input Format :
 * 
 *         The first line contains 2 2 space separated integers N N and Q Q. The
 *         next line contains the String S S. Each of the next Q Q lines
 *         contains 2 2 space separated integers L L and R R, denoting the
 *         parameters of the i t h ith query.
 * 
 *         Output Format :
 * 
 *         Print the answer to each query on a new line.
 * 
 *         Constraints :
 * 
 *         1 ≤ N , Q ≤ 10 5 1≤N,Q≤105
 * 
 *         1 ≤ L ≤ R ≤ N 1≤L≤R≤N
 * 
 *         Sample Input 8 2 abcdabcd 1 6 2 7 Sample Output 2 2 Explanation The
 *         explanation to the 1 s t 1st query in the sample has been provided in
 *         the problem statement. For the 2 n d 2nd query, the substring
 *         required here is " b c d a b c " "bcdabc" . We can delete from this
 *         substring one occurence one occurence of ′ b ′ ′b′ and ′ c ′ ′c′ to
 *         achieve the desired result. Thus, the answer is 2 2.
 */
public class StringQueries {
	
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			int q = in.nextInt();
			int[] result = new int[q];
			in.nextLine();
			String s = in.nextLine();
			
			for (int i = 0; i < q; i++){
				int l = in.nextInt() - 1;
				int r = in.nextInt();
				result[i] = numberOfReduction(s.substring(l, r));
			}
			
			
			
			for (int i = 0; i < q; i++){
				System.out.println(result[i]);
			}
		}

	}

	/**
	 * @param result
	 * @param s string to be checked.
	 */
	public static int numberOfReduction0(String s) {
		int result = 0;
		int[] oc = new int[26];
		for (int j =0; j < s.length(); j++){
			oc[s.charAt(j)-'a']++;
		}
		Arrays.sort(oc);
		int lowest = 0;
		for (int j = 0; j < 26; j++){
			if (lowest == 0 && oc[j] != 0){
				lowest = oc[j];
			} else {
				result += (oc[j] - lowest); 
			}
		}
		return result;
	}
	
	/**
	 * @param result
	 * @param s string to be checked.
	 */
	public static int numberOfReduction(String s) {
		int result = 0;
		int[] oc = new int[26];
		for (int j =0; j < s.length(); j++){
			oc[s.charAt(j)-'a']++;
		}
		
		int[] distribution = new int[26];
		int maxIndex = -1;
		int maxDistribution = 0;
		for (int j = 0; j < 26; j++){
			if (oc[j] != 0) {
				distribution[oc[j]]++;
				if (distribution[j] > maxDistribution){
					maxDistribution = distribution[j];
					maxIndex = j;
				}
			}
		}
		
		for (int j = 0; j < 26; j++){
			if (oc[j] != 0) {
				result += Math.abs(maxDistribution - oc[j]); 
			}
		}
		return result;
	}

}
