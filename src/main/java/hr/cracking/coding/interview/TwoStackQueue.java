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

	        public void enqueue(T value) { // Push onto newest stack
	        	stackNewestOnTop.push(value);
	            T top = value;
	            stackOldestOnTop.clear();
	            Stack<T> temp = new Stack<T>();
	            while (!stackNewestOnTop.isEmpty()){
	            	top = stackNewestOnTop.pop();
	                temp.push(top);
	                stackOldestOnTop.push(top);
	            }
	            
	            while (!temp.isEmpty()){
	            	stackNewestOnTop.push(temp.pop());
	            }
	        }

	        public T peek() {
	        	if (!stackOldestOnTop.isEmpty()) {
	             return stackOldestOnTop.peek();
	        	} else {
	        		return null;
	        	}
	        }

	        public T dequeue() {
	        	T value = null;
	        	Stack<T> temp = new Stack<T>();
	            if (stackOldestOnTop != null && !stackOldestOnTop.isEmpty()){
	                value = stackOldestOnTop.pop();
	            }
	            stackNewestOnTop.clear();
	            
	            while (!stackOldestOnTop.isEmpty()){
	            	T top = stackOldestOnTop.pop();
	                stackNewestOnTop.push(top);
	                temp.push(top);
	            }
	            
	            while (!temp.isEmpty()){
	            	T top = temp.pop();
	            	stackOldestOnTop.push(top);
	            }
	            return value;
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
