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
package Adoga;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class Pre2Post {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			String[] prefixes = new String[n];
			String[] result = new String[n];

			for (int i = 0; i < n; i++) {
				prefixes[i] = in.next();
			}

			result = prefixToPostfix(prefixes);
			
			for (int i = 0; i < n; i++) {
				System.out.println(result[i]);
			}
			
		}

	}

	public static String[] prefixToPostfix(String[] prefixes) {
		String[] result = new String[prefixes.length];

		for (int i = 0; i < prefixes.length; i++) {
			result[i] = convertEach(prefixes[i]);
		}

		return result;

	}

	/**
	 * @param string
	 * @return
	 */
	private static String convertEach(String string) {
		Stack<Character> operandStack = new Stack<>();
		Stack<Character> auxiliary = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		int div = 0;
		int mul = 0;

		int in = 0;
		char[] post = new char[string.length()];

		for (int i = 0; i < string.length(); i++) {
			char entry = string.charAt(i);
			if (entry >= '0' && entry <= '9') {
				if (div > 0) {
					post[in++] = entry;
					if (i + 1 < string.length()) {
						post[in++] = string.charAt(++i);
					}
					post[in++] = operatorStack.pop();
					div--;
				} else if (mul > 0) {
					post[in++] = entry;
					if (i + 1 < string.length()) {
						post[in++] = string.charAt(++i);
					}
					post[in++] = operatorStack.pop();
					mul--;
				}else {
					operandStack.push(entry);
				}
			} else if (entry == '+' || entry == '-' || entry == '*' || entry == '/') {
				if (entry == '/') {
					div++;
				} else if (entry == '*') {
					mul++;
				}
				operatorStack.push(entry);
			}
		}

		while (!operandStack.isEmpty()) {
			auxiliary.push(operandStack.pop());
		}

		while (!auxiliary.isEmpty()) {
			post[in++] = auxiliary.pop();
		}

		while (!operatorStack.isEmpty()) {
			post[in++] = operatorStack.pop();
		}

		return String.copyValueOf(post);
	}

}
