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
package wizeline;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ArraySumTest {

	ArraySum awesome = new ArraySum();

	/**
	 * Test method for {@link wizeline.ArraySum#sum(int[], int[])}.
	 */
	@Test
	public void testSum() {
		int[] A = new int[] { 1, 0 };
		int[] B = new int[] { 5 };
		int[] expecteds = new int[] { 1, 5 };
		int[] actuals = awesome.sum(A, B);
		Assert.assertArrayEquals(expecteds, actuals);

		A = new int[] { 1, 0 };
		B = new int[] { 5, 0 };
		expecteds = new int[] { 6, 0 };
		actuals = awesome.sum(A, B);
		Assert.assertArrayEquals(expecteds, actuals);

		A = new int[] { 9, 9 };
		B = new int[] { 9, 8 };
		expecteds = new int[] { 1, 9, 7 };
		actuals = awesome.sum(A, B);
		Assert.assertArrayEquals(expecteds, actuals);
		
		A = new int[] { 9, 9 };
		B = new int[] { 9, 9 };
		expecteds = new int[] { 1, 9, 8};
		actuals = awesome.sum(A, B);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
