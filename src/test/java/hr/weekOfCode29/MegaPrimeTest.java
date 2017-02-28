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
package hr.weekOfCode29;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MegaPrimeTest {

	/**
	 * Test method for {@link hr.weekOfCode29.MegaPrime#getNumberOfMegaPrimes(long, long)}.
	 */
	@Test
	public void testGetNumberOfMegaPrimes() {
		Assert.assertEquals(8, MegaPrime.getNumberOfMegaPrimes(1, 100));
	}

	/**
	 * Test method for {@link hr.weekOfCode29.MegaPrime#isAllDigitsPrime(long)}.
	 */
	@Test
	public void testIsAllDigitsPrime() {
		Assert.assertFalse(MegaPrime.isAllDigitsPrime(1));
		Assert.assertFalse(MegaPrime.isAllDigitsPrime(11));
		Assert.assertFalse(MegaPrime.isAllDigitsPrime(45));
		
		Assert.assertTrue(MegaPrime.isAllDigitsPrime(2));
		Assert.assertTrue(MegaPrime.isAllDigitsPrime(5));
		Assert.assertTrue(MegaPrime.isAllDigitsPrime(7));
		Assert.assertTrue(MegaPrime.isAllDigitsPrime(75));
		Assert.assertTrue(MegaPrime.isAllDigitsPrime(23));
	}

}
