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
public class TwoStackQueue {

	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		private boolean newestPop = true;
		private boolean newestPush = true;

		public void enqueue(T value) { // Push onto newest stack
			if (newestPush) {
				stackNewestOnTop.push(value);
				newestPush = false;
			} else {
				stackOldestOnTop.push(value);
				newestPush = true;
			}
		}

		public T peek() {
			T value = null;
			T peekValue = null;

			int popCount = 0;
			if (newestPop) {
				while (!stackNewestOnTop.isEmpty()) {
					popCount++;
					value = stackNewestOnTop.pop();
					stackOldestOnTop.push(value);
				}
//				newestPop = false;
				peekValue = value;

				while (popCount > 0) {
					stackNewestOnTop.push(stackOldestOnTop.pop());
					popCount--;
				}

			} else {
				while (!stackOldestOnTop.isEmpty()) {
					popCount++;
					value = stackOldestOnTop.pop();
					stackNewestOnTop.push(value);
				}
//				newestPop = true;
				peekValue = value;

				while (popCount > 0) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
					popCount--;
				}
			}
			return peekValue;
		}

		public T dequeue() {
			T value = null;
			T peekValue = null;

			int popCount = 0;
			if (newestPop) {
				while (!stackNewestOnTop.isEmpty()) {
					popCount++;
					value = stackNewestOnTop.pop();
					stackOldestOnTop.push(value);
				}
				newestPop = false;
				peekValue = value;

				stackOldestOnTop.pop();
				while (popCount > 1) {
					stackNewestOnTop.push(stackOldestOnTop.pop());
					popCount--;
				}

			} else {
				while (!stackOldestOnTop.isEmpty()) {
					popCount++;
					value = stackOldestOnTop.pop();
					stackNewestOnTop.push(value);
				}
				newestPop = true;
				peekValue = value;

				stackNewestOnTop.pop();
				while (popCount > 1) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
					popCount--;
				}
			}
			return peekValue;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();

	}

}
