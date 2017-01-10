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
package hr.weekofcode28;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class GreatXORTest {

	/**
	 * Test method for {@link hr.weekofcode28.GreatXOR#getHigherXOR(long)}.
	 */
	@Test
	public void testGetHigherXOR() {
	
		long actual = GreatXOR.getHigherXOR(1);
		Assert.assertEquals(0, actual);
		
		actual = GreatXOR.getHigherXOR(4);
		Assert.assertEquals(3, actual);
		
		actual = GreatXOR.getHigherXOR(8);
		Assert.assertEquals(7, actual);
		
		actual = GreatXOR.getHigherXOR(16);
		Assert.assertEquals(15, actual);
		
		actual = GreatXOR.getHigherXOR(2);
		Assert.assertEquals(1, actual);
		
		actual = GreatXOR.getHigherXOR(3);
		Assert.assertEquals(0, actual);
		
		actual = GreatXOR.getHigherXOR(5);
		Assert.assertEquals(2, actual);
		
		actual = GreatXOR.getHigherXOR(10);
		Assert.assertEquals(5, actual);
		
		actual = GreatXOR.getHigherXOR(6);
		Assert.assertEquals(1, actual);
		
		
	}
	
	@Test
	public void testIsPowerOfTwo(){
		boolean isPowerOfTwo = GreatXOR.isPowerOfTwo(1);
		Assert.assertTrue(isPowerOfTwo);
		
		isPowerOfTwo = GreatXOR.isPowerOfTwo(2);
		Assert.assertTrue(isPowerOfTwo);
		
		isPowerOfTwo = GreatXOR.isPowerOfTwo(3);
		Assert.assertFalse(isPowerOfTwo);
	}
	
	@Test
	public void testNextPowerOfTwo(){
		GreatXOR.nextPowerOfTwo(2);
		GreatXOR.nextPowerOfTwo(3);
		GreatXOR.nextPowerOfTwo(4);
	}

}
