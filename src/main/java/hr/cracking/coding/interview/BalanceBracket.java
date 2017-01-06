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
package hr.cracking.coding.interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class BalanceBracket {

	/**
	 * Strings will be passed. Need to check whether the brackets are balanced
	 * or not.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			in.nextLine();

			String[] inputs = new String[n];

			for (int i = 0; i < n; i++) {
				inputs[i] = in.nextLine();
				
			}

			for (int i = 0; i < n; i++) {
				if (isBalanced(inputs[i])) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	/**
	 * @param nextLine - to be checked whether brackets are balanced or not.
	 * @return true if brackets are balanced false otherwise.
	 */
	public static boolean isBalanced(String nextLine) {

		if (nextLine.length() % 2 == 1) {
			return false;
		}
		Stack<Character> brackets = new Stack<Character>();
		char lastEntered = ' ';
		for (int i = 0; i < nextLine.length(); i++) {
			char current = nextLine.charAt(i);

			if (!brackets.isEmpty()) {
				lastEntered = brackets.peek();
			}
			switch (current) {
			case ')':
				if (lastEntered != '(') {
					return false;
				}
				brackets.pop();
				break;

			case '}':
				if (lastEntered != '{') {
					return false;
				}
				brackets.pop();
				break;

			case ']':
				if (lastEntered != '[') {
					return false;
				}
				brackets.pop();
				break;

			default:
				brackets.push(current);
				break;
			}

		}
		if (brackets.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
