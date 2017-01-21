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
public class MergeSortCountIntversionsTest {

	/**
	 * Test method for {@link hr.cracking.coding.interview.MergeSortCountIntversions#getSwapCount(int[])}.
	 */
	@Test
	public void testGetSwapCount() {
		int actual = MergeSortCountIntversions.getSwapCount(new int[]{2, 1, 3, 1, 2});
		Assert.assertEquals(4, actual);
		
		actual = MergeSortCountIntversions.getSwapCount(new int[]{1, 1, 2,  2});
		Assert.assertEquals(0, actual);
		
		actual = MergeSortCountIntversions.getSwapCount(new int[]{4, 2, 3,  5});
		Assert.assertEquals(2, actual);
	}

}
