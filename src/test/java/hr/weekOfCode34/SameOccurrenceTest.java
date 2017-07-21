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
package hr.weekOfCode34;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class SameOccurrenceTest {

	/**
	 * Test method for
	 * {@link hr.weekOfCode34.SameOccurrence#getContiguousArray(int, int, int[])}
	 * .
	 */
	@Test
	public void testGetContiguousArray() {
		Assert.assertEquals(6, SameOccurrence.getContiguousArray(4, 5, new int[] { 1, 2, 1 }));
		Assert.assertEquals(2, SameOccurrence.getContiguousArray(1, 2, new int[] { 1, 2, 1 }));
		Assert.assertEquals(4, SameOccurrence.getContiguousArray(1, 2, new int[] { 1, 3, 2, 1 }));
		Assert.assertEquals(7, SameOccurrence.getContiguousArray(1, 2, new int[] { 1, 4, 5, 2, 1 }));
//		Assert.assertEquals(6, SameOccurrence.getContiguousArray(1, 3, new int[] { 1, 3, 5, 1, 7 }));
	}

}
