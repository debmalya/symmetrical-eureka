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
package hr.hourrank23;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class HalloweenTest {

	/**
	 * Test method for
	 * {@link hr.hourrank23.Halloween#howManyGames(int, int, int, int)}.
	 */
	@Test
	public final void testHowManyGames() {
		Assert.assertEquals(7, Halloween.howManyGames(20, 3, 6, 85));
		Assert.assertEquals(6, Halloween.howManyGames(20, 3, 6, 80));
		Assert.assertEquals(0, Halloween.howManyGames(20, 3, 6, 6));
		int i = 0;
		for (; i < 14; i++) {
			Assert.assertEquals(0, Halloween.howManyGames(20, 3, 6, 6 + i));
		}
		Assert.assertEquals(1, Halloween.howManyGames(20, 3, 6, 20));
		Assert.assertEquals(1, Halloween.howManyGames(20, 3, 6, 26));

		i = 0;
		for (; i < 17; i++) {
			Assert.assertEquals("Failed for i = " + i, 1, Halloween.howManyGames(20, 3, 6, 20 + i));
		}
		Assert.assertEquals(2, Halloween.howManyGames(20, 3, 6, 37));
		for (; i < 14; i++) {
			Assert.assertEquals(2, Halloween.howManyGames(20, 3, 6, 37 + i));
		}

	}

}
