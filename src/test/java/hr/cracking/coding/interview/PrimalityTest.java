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

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class PrimalityTest {

	/**
	 * Test method for
	 * {@link hr.cracking.coding.interview.Primality#isPrime(int)}.
	 */
	@Test
	public void testIsPrime() {
		Assert.assertFalse(Primality.isPrime(1000000000));
		Assert.assertFalse(Primality.isPrime(1000000001));
		Assert.assertFalse(Primality.isPrime(1000000000));
		Assert.assertFalse(Primality.isPrime(1000000002));
		Assert.assertFalse(Primality.isPrime(1000000003));

		Assert.assertFalse(Primality.isPrime(1000000004));
		Assert.assertFalse(Primality.isPrime(1000000005));
		Assert.assertFalse(Primality.isPrime(1000000006));
		Assert.assertTrue(Primality.isPrime(1000000007));
		Assert.assertFalse(Primality.isPrime(1000000008));
		Assert.assertTrue(Primality.isPrime(1000000009));

		Assert.assertFalse(Primality.isPrime(30));
		Assert.assertFalse(Primality.isPrime(1));
		Assert.assertFalse(Primality.isPrime(4));
		Assert.assertFalse(Primality.isPrime(9));
		Assert.assertFalse(Primality.isPrime(16));
		Assert.assertFalse(Primality.isPrime(25));
		Assert.assertFalse(Primality.isPrime(36));
		Assert.assertFalse(Primality.isPrime(49));
		Assert.assertFalse(Primality.isPrime(64));
		Assert.assertFalse(Primality.isPrime(81));
		Assert.assertFalse(Primality.isPrime(100));
		Assert.assertFalse(Primality.isPrime(121));
		Assert.assertFalse(Primality.isPrime(144));
		Assert.assertFalse(Primality.isPrime(169));
		Assert.assertFalse(Primality.isPrime(196));
		Assert.assertFalse(Primality.isPrime(225));
		Assert.assertFalse(Primality.isPrime(256));
		Assert.assertFalse(Primality.isPrime(289));
		Assert.assertFalse(Primality.isPrime(324));
		Assert.assertFalse(Primality.isPrime(361));
		Assert.assertFalse(Primality.isPrime(400));
		Assert.assertFalse(Primality.isPrime(441));
		Assert.assertFalse(Primality.isPrime(484));
		Assert.assertFalse(Primality.isPrime(529));
		Assert.assertFalse(Primality.isPrime(576));
		Assert.assertFalse(Primality.isPrime(625));
		Assert.assertFalse(Primality.isPrime(676));
		Assert.assertFalse(Primality.isPrime(729));
		Assert.assertFalse(Primality.isPrime(784));
		Assert.assertFalse(Primality.isPrime(841));
		Assert.assertTrue(Primality.isPrime(907));
		
		Assert.assertTrue(Primality.isPrime(89));
		Assert.assertTrue(Primality.isPrime(109));
		Assert.assertTrue(Primality.isPrime(167));

	}

}
