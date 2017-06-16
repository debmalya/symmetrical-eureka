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
package hr;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class NonDivisibleSubsetTest {

	/**
	 * Test method for {@link hr.NonDivisibleSubset#getNumberOfNonDivisibleSet(int, int, int[])}.
	 */
	@Test
	public void testGetNumberOfNonDivisibleSet() {
		NonDivisibleSubset nds = new NonDivisibleSubset();
		Assert.assertEquals(3,nds.getNumberOfNonDivisibleSet(4, 3, new int[] {1,7,2,4}));
		Assert.assertEquals(5,nds.getNumberOfNonDivisibleSet(6, 9,  new int[] {422346306, 940894801, 696810740, 862741861, 85835055, 313720373}));
		Assert.assertEquals(5,nds.getNumberOfNonDivisibleSet(5, 5, new int[] {2, 7, 12, 17, 22}));
	}

}
