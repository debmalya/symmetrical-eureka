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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class TwoStackQueueTest {

	@Test
	public final void testEnQueue() {
		
		TwoStackQueue.MyQueue<Integer> newQueue = new TwoStackQueue.MyQueue<>();
		newQueue.enqueue(42);
		Assert.assertEquals(42,newQueue.stackNewestOnTop.peek().intValue());
		newQueue.enqueue(14);
		Assert.assertEquals(14,newQueue.stackOldestOnTop.peek().intValue());
		newQueue.enqueue(28);
		Assert.assertEquals(28,newQueue.stackNewestOnTop.peek().intValue());
		newQueue.enqueue(60);
		Assert.assertEquals(60,newQueue.stackOldestOnTop.peek().intValue());
		newQueue.enqueue(78);
		Assert.assertEquals(78,newQueue.stackNewestOnTop.peek().intValue());
	}
	
	@Test
	public final void testPeek() {
		
		TwoStackQueue.MyQueue<Integer> newQueue = new TwoStackQueue.MyQueue<>();
		newQueue.enqueue(42);
		Assert.assertEquals(42,newQueue.stackNewestOnTop.peek().intValue());
		Assert.assertEquals(42,newQueue.peek().intValue());
		newQueue.enqueue(14);
		Assert.assertEquals(14,newQueue.stackOldestOnTop.peek().intValue());
		Assert.assertEquals(42,newQueue.peek().intValue());
		newQueue.enqueue(28);
		Assert.assertEquals(28,newQueue.stackNewestOnTop.peek().intValue());
		Assert.assertEquals(42,newQueue.peek().intValue());
		newQueue.enqueue(60);
		Assert.assertEquals(60,newQueue.stackOldestOnTop.peek().intValue());
		Assert.assertEquals(42,newQueue.peek().intValue());
		newQueue.enqueue(78);
		Assert.assertEquals(78,newQueue.stackNewestOnTop.peek().intValue());
		Assert.assertEquals(42,newQueue.peek().intValue());
	}

}
