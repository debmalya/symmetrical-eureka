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
package ht;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class BestCatTest {

	/**
	 * Test method for {@link ht.BestCat#getTheWinner(int, int, int, int)}.
	 */
	@Test
	public void testGetTheWinner() {
		Assert.assertEquals(0, BestCat.getTheWinner(10, 1, 9, 5));
//		Assert.assertEquals(1, BestCat.getTheWinner(9, 2, 5, 4));
	}

}
