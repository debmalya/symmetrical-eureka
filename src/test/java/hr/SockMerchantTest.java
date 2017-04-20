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
public class SockMerchantTest {

	/**
	 * Test method for {@link hr.SockMerchant#getSockCount(int, int[])}.
	 */
	@Test
	public void testGetSockCount() {
		int actual = SockMerchant.getSockCount(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 });
		Assert.assertEquals(3, actual);

		actual = SockMerchant.getSockCount(10, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20, 20 });
		Assert.assertEquals(4, actual);

		actual = SockMerchant.getSockCount(11, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20, 20, 20 });
		Assert.assertEquals(4, actual);

		actual = SockMerchant.getSockCount(12, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20, 20, 20, 30 });
		Assert.assertEquals(5, actual);
	}

}
