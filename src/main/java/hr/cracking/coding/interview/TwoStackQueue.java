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

	/**
	 * once you have populated your dequeue stack for performing either a pop or
	 * front operation, your dequeue stack is still in the right state for
	 * subsequent pop or top operations, until it's empty.
	 * 
	 * @author debmalyajash
	 *
	 * @param <T>
	 */
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
		}

		public T peek() {
			if (stackOldestOnTop.isEmpty() && !stackNewestOnTop.isEmpty()) {
				while (!stackNewestOnTop.isEmpty()) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}
			return stackOldestOnTop.peek();
		}

		public T dequeue() {
			if (stackOldestOnTop.isEmpty() && !stackNewestOnTop.isEmpty()) {
				while (!stackNewestOnTop.isEmpty()) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}
			return stackOldestOnTop.pop();
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
