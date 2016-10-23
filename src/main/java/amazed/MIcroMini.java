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
package amazed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class MIcroMini {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int noOfTestCases = in.nextInt();
		
			int[] results = new int[noOfTestCases];
			
			for (int i = 0; i < noOfTestCases; i++){
				results[i] = getNumberOfCombinations(in.next());
			}
			
			for (int i = 0; i < noOfTestCases; i++){
				System.out.println(results[i]);
			}
		}

	}
	
	public static int getNumberOfCombinations4(String s){
		Set<String> u = new HashSet<String>();

		char[] t = s.toCharArray();
		for (int i =0; i< s.length(); i++){
			char lastChar = t[t.length - 1];
			for (int j = t.length - 2; j > -1; j--) {
				t[j + 1] = t[j];
			}
			t[0] = lastChar;
			u.add(Arrays.toString(t));
		}
		
		return u.size();
	}
	
	public static int getNumberOfCombinations2(String s){
		Set<Long> u = new HashSet<Long>();
		
		char[] t = s.toCharArray();
		long l = 0;
		
		for (int i =0; i< s.length(); i++){
			char lastChar = t[t.length - 1];
			l = lastChar - 'a';
			long m = (long)Math.pow(10, s.length());
			for (int j = t.length - 2; j > -1; j--) {
				t[j + 1] = t[j];
				long a = t[j + 1] - 'a';
				 l += (m * a);
				 m /= 10;
				 
			}
			t[0] = lastChar;
			u.add(l);
		}
		
		return u.size();
	}
	
	public static int getNumberOfCombinations(String s){
		Set<String> u = new HashSet<String>();
		
		char[] t = s.toCharArray();
		for (int i =0; i< s.length(); i++){
			char lastChar = t[t.length - 1];
			System.arraycopy(t, 0, t, 1, t.length - 1);
			t[0] = lastChar;
			u.add(new String(t));
		}
		
		return u.size();
	}
	
	public static int getNumberOfCombinations1(String s){
		Set<String> u = new HashSet<String>();
		
		char[] t = s.toCharArray();
		for (int i =0; i< s.length(); i++){
			char lastChar = t[t.length - 1];
			for (int j = t.length - 2; j > -1; j--) {
				t[j + 1] = t[j];
			}
			t[0] = lastChar;
			u.add(String.valueOf(t));
		}
		
		return u.size();
	}


	public static int getNumberOfCombinations0(String s){
		Set<String> u = new HashSet<String>();
		
		
		for (int i =0; i< s.length(); i++){
			s = s.substring(s.length() - 1, s.length()) + s.substring(0, s.length()- 1);
			u.add(s);
		}
		
		return u.size();
	}
}
