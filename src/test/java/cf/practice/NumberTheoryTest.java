/**
 * Copyright 2015-2017 Debmalya Jash
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
public class NumberTheoryTest {

	NumberTheory numberTheory = new NumberTheory();

	/**
	 * Test method for {@link cf.practice.NumberTheory#missingNumber(int[])}.
	 */
	@Test
	public void testMissingNumber() {
		Assert.assertEquals( 2, numberTheory.missingNumber( new int[] { 3, 1, 0 } ) );
		Assert.assertEquals( 1, numberTheory.missingNumber( new int[] { 0 } ) );
		Assert.assertEquals( 0, numberTheory.missingNumber( new int[] { 1, 2 } ) );
	}

	@Test
	public void testSimplifiedRational() {
		Assert.assertArrayEquals( new int[] { 1, 2 }, numberTheory.simplifyRational( 1, 2 ) );
		Assert.assertArrayEquals( new int[] { 1, 2 }, numberTheory.simplifyRational( 3, 6 ) );
		Assert.assertArrayEquals( new int[] { 0, 6 }, numberTheory.simplifyRational( 0, 6 ) );
		Assert.assertArrayEquals( new int[] { -8, 5 }, numberTheory.simplifyRational( 8, -5 ) );
		Assert.assertArrayEquals( new int[] { 1047, 299 }, numberTheory.simplifyRational( 5235, 1495 ) );
		Assert.assertArrayEquals( new int[] { 1, 1 }, numberTheory.simplifyRational( -239, -239 ) );
//		Assert.assertArrayEquals( new int[] { 0, 1 }, numberTheory.simplifyRational( 0, -239 ) );
//		Assert.assertArrayEquals( new int[] { 0, 1 }, numberTheory.simplifyRational( 0, 239 ) );

	}

}
