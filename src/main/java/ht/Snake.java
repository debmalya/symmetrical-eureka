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
package ht;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Snake {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int t = in.nextInt();
			String cases = "";
			String[] answers = new String[t];
			for ( int i = 0; i < t; i++) {
				cases = in.nextLine();
				answers[i] = getAnswer(cases);
			}
			
			for ( int i = 0; i < t; i++) {
				System.out.println(answers[i]);
			}
		}

	}

	/**
	 * @param cases
	 * @return
	 */
	public static String getAnswer(String cases) {
		String movements = cases.substring(1);
		int l = 1;
		char f = ' ';
		char s = ' ';
		char t = ' ';
		for (int i = 0; i < movements.length(); i++) {
			char c = movements.charAt(i);
			if (c=='E') {
				l++;
			}
			// 3 L or 3 R.
			if (f != ' ') {
				s = f;
			}
			if ( s != ' ') {
				t = s;
			}
			if (c != 'F' && c != 'E') {
				if (c==f && f==s && s == t && l >4) {
					return ""+(i+1);
				}
			}
			f = c;
		}
		return "YES";
	}

}
