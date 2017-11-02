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
package cf.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class LinkNodeOperator {
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		ListNode<Integer> result = new ListNode<>(0);
		ListNode<Integer> current = result;
		Stack<Integer> first = new Stack<>();
		Stack<Integer> second = new Stack<>();
		Stack<Integer> finalStack = new Stack<>();
		int carryForward = 0;
		int c = 0;
		int d = 0;

		while (a != null) {
			first.push(a.value);
			a = a.next;
		}

		while (b != null) {
			second.push(b.value);
			b = b.next;
		}

		while (!first.isEmpty() || !second.isEmpty()) {
			c = 0;
			d = 0;
			if (!first.isEmpty()) {
				c = first.pop();
			}

			if (!second.isEmpty()) {
				d = second.pop();
			}
			int e = c + d + carryForward;
			finalStack.push(e % 10000);
			carryForward = e / 10000;
		}

		if (carryForward > 0) {
			finalStack.push(carryForward);
		}

		while (!finalStack.isEmpty()) {
			current.value = finalStack.pop();
			if (!finalStack.isEmpty()) {
				current.next = new ListNode<Integer>(0);
				current = current.next;
			}
		}

		return result;
	}

	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> result = null;
		ListNode<Integer> current = null;
		List<Integer> sortedList = new ArrayList<>();
		
		while (l1 != null) {
			sortedList.add(l1.value);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			sortedList.add(l2.value);
			l2 = l2.next;
		}
		Collections.sort(sortedList);

		for (int i = 0; i < sortedList.size(); i++) {
			if (i == 0){
				result = new ListNode<Integer>(0);
				current = result;
			}
			current.value = sortedList.get(i);
			if (i + 1 < sortedList.size()) {
				current.next = new ListNode<Integer>(0);
				current = current.next;
			}
		}
		
		return result;
	}
}
