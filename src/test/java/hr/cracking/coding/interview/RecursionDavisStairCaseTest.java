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
public class RecursionDavisStairCaseTest {

	/**
	 * Test method for
	 * {@link hr.cracking.coding.interview.RecursionDavisStairCase#getNumberOfWays(int)}
	 * .
	 */
	@Test
	public void testGetNumberOfWays() {
		Assert.assertEquals(1, RecursionDavisStairCase.getNumberOfWays(1));
		Assert.assertEquals(2, RecursionDavisStairCase.getNumberOfWays(2));
		Assert.assertEquals(4, RecursionDavisStairCase.getNumberOfWays(3));
		Assert.assertEquals(7, RecursionDavisStairCase.getNumberOfWays(4));
		Assert.assertEquals(13, RecursionDavisStairCase.getNumberOfWays(5));
		Assert.assertEquals(24, RecursionDavisStairCase.getNumberOfWays(6));
		Assert.assertEquals(44, RecursionDavisStairCase.getNumberOfWays(7));
	}

}
