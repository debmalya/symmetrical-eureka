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
public class PickingNumberTest {

	PickingNumber pickingNumber = new PickingNumber();

	/**
	 * Test method for {@link hr.PickingNumber#pickedNumbers(int[])}.
	 */
	@Test
	public void testPickedNumbers() {
		Assert.assertEquals(3, PickingNumber.pickedNumbers(new int[] { 4, 6, 5, 3, 3, 1 }));
		Assert.assertEquals(15,
				PickingNumber.pickedNumbers(new int[] { 14, 18, 17, 10, 9, 20, 4, 13, 19, 19, 8, 15, 15, 17, 6, 5, 15,
						12, 18, 2, 18, 7, 20, 8, 2, 8, 11, 2, 16, 2, 12, 9, 3, 6, 9, 9, 13, 7, 4, 6, 19, 7, 2, 4, 3, 4,
						14, 3, 4, 9, 17, 9, 4, 20, 10, 16, 12, 1, 16, 4, 15, 15, 9, 13, 6, 3, 8, 4, 7, 14, 16, 18, 20,
						11, 20, 14, 20, 12, 15, 4, 5, 10, 10, 20, 11, 18, 5, 20, 13, 4, 18, 1, 14, 3, 20, 19, 14, 2, 5,
						13 }));
	}

	@Test
	public void testFirstUsageOfTheDay() {
		long recordTimeStamp = System.currentTimeMillis();
		long firstUsageOfTheDay = PickingNumber.getFirstUsageOfDay(0, recordTimeStamp);
		Assert.assertEquals(firstUsageOfTheDay, recordTimeStamp);

		firstUsageOfTheDay = PickingNumber.getFirstUsageOfDay(firstUsageOfTheDay, System.currentTimeMillis());
		Assert.assertEquals(firstUsageOfTheDay, recordTimeStamp);
	}

}
