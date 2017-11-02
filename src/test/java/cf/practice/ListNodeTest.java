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

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class ListNodeTest {

	/**
	 * Test method for
	 * {@link cf.practice.ListNode#addTwoHugeNumbers(cf.practice.ListNode, cf.practice.ListNode)}.
	 */
	@Test
	public final void testAddTwoHugeNumbers() {
		ListNode<Integer> first = new ListNode<>(0);
		first.value = 9876;
		first.next = new ListNode<>(0);
		
		first.next.value = 5432;
		first.next.next = new ListNode<>(0);
		first.next.next.value = 1999;

		ListNode<Integer> second = new ListNode<>(0);
		second.value = 1;
		second.next = new ListNode<>(0);
		second.next.value = 8001;
		
		LinkNodeOperator op = new LinkNodeOperator();
		ListNode<Integer> result = op.addTwoHugeNumbers(first, second);
		Assert.assertNotNull(result);
		
		Assert.assertEquals((long)9876, (long)result.value);
		Assert.assertNotNull(result.next);
		Assert.assertTrue(5434 == result.next.value);
		Assert.assertEquals((long)0, (long)result.next.next.value);

	}

}
