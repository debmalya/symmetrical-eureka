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
public class ElectronicShopTest {

	/**
	 * Test method for {@link hr.ElectronicShop#getPrice(int, int[], int[])}.
	 */
	@Test
	public final void testGetPrice() {
		int actual = ElectronicShop.getPrice(10, new int[]{3,1}, new int[]{5,2,8});
		Assert.assertEquals(9, actual);
		
		actual = ElectronicShop.getPrice(5, new int[]{4}, new int[]{5});
		Assert.assertEquals(-1, actual);
	}

}
