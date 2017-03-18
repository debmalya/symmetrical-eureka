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
package hr.weekOfCode30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class MelodiusPassword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Password length
			int n = in.nextInt();
			List<String> passwordList = getAllMelodiusPassword(n);
			for (String eachPassword : passwordList) {
				System.out.println(eachPassword);
			}
		}

	}

	/**
	 * a password consists of exactly passwordLength lower case English letters.
	 * 
	 * the password is melodious, meaning that consonants can only be next to
	 * vowels and vowels can only be next to consonants. Example: bawahaha.
	 * 
	 * the password cannot contain the letter y (because it's both a consonant
	 * and vowel).
	 * 
	 * The first letter of the password can be either a vowel or consonant.
	 * 
	 * @param passwordLength
	 * @return
	 */
	public static List<String> getAllMelodiusPassword(final int passwordLength) {
		List<String>[] passwordList = new ArrayList[passwordLength];
		char c = 'a';
		char[] consonants = new char[] {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
		char[] vowels = new char[] {'a','e','i','o','u'};
		passwordList[0] = new ArrayList<>();
		while (true) {
			if (c != 'x') {
				passwordList[0].add("" + (c++));
			} else {
				passwordList[0].add("x");
				passwordList[0].add("z");
				break;
			}
		}
		for (int i = 1; i < passwordLength; i++) {
			if (passwordList[i] == null) {
				passwordList[i] = new ArrayList<>();
			}
			for (int j = 0; j < passwordList[i - 1].size(); j++) {
				char lastChar = passwordList[i - 1].get(j).charAt(i - 1);
				if (lastChar != 'a' && lastChar != 'e' && lastChar != 'i' && lastChar != 'u' &&  lastChar != 'o') {
					// consonants adding vowel with it.
					for (int k = 0; k < vowels.length; k++) {
						passwordList[i].add(passwordList[i - 1].get(j)+vowels[k]);
					}
				} else {
					// vowel adding consonants with it.
					for (int k = 0; k < consonants.length; k++) {
						passwordList[i].add(passwordList[i - 1].get(j)+consonants[k]);
					}
				}
			}
		}
		return passwordList[passwordLength - 1];
	}
}
