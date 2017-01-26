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
package amazed;



import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class LuckyNumbersTest {

	/**
	 * Test method for {@link amazed.LuckyNumbers#isLucky(int)}.
	 */
	@Test
	public void testIsLucky() {
		Assert.assertTrue(LuckyNumbers.isLucky(1102));
		Assert.assertFalse(LuckyNumbers.isLucky(1103));
		Assert.assertFalse(LuckyNumbers.isLucky(11031));
		Assert.assertTrue(LuckyNumbers.isLucky(11011));
	}

	/**
	 * Test method for {@link amazed.LuckyNumbers#getSumOfDigits(int)}.
	 */
	@Test
	public void testGetSumOfDigits() {
		int sum = LuckyNumbers.getSumOfDigits(1);
		Assert.assertEquals(1, sum);
		
		sum = LuckyNumbers.getSumOfDigits(11);
		Assert.assertEquals(2, sum);
		
		sum = LuckyNumbers.getSumOfDigits(1102);
		Assert.assertEquals(4, sum);
	}

}
