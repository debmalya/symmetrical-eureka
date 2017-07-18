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
package hr.weekOfCode34;

import org.junit.Assert;
import org.junit.Test;

import hr.weekOfCode34.OnceInATram;

/**
 * @author debmalyajash
 *
 */
public class OnceInATramTest {

	/**
	 * Test method for {@link hr.weekOfCode34.OnceInATram#onceInATram(int)}.
	 */
	@Test
	public void testOnceInATram() {
		Assert.assertEquals("100001", OnceInATram.onceInATram(100000));
		Assert.assertEquals("100010", OnceInATram.onceInATram(100001));
		Assert.assertEquals("100100", OnceInATram.onceInATram(100010));
		Assert.assertEquals("101002", OnceInATram.onceInATram(100100));
		Assert.assertEquals("101011", OnceInATram.onceInATram(101002));
		Assert.assertEquals("101020", OnceInATram.onceInATram(101011));
		Assert.assertEquals("999999", OnceInATram.onceInATram(998998));
		Assert.assertEquals("999999", OnceInATram.onceInATram(999998));
	}

	@Test
	public void testSum() {
		Assert.assertEquals(27, OnceInATram.sum(999));
	}

	@Test
	public void testIsMagic() {
		Assert.assertTrue(OnceInATram.isMagic(999999));
		int c = 0;
		int[] magicNumbers = new int[50412];
		for (int i = 100000; i < 1000000; i++) {
			if (OnceInATram.isMagic(i)) {
				magicNumbers[c] = i;
				c++;
			}
			
		}
		for (int i = 0; i < c -1; i++) {
			Assert.assertEquals(""+magicNumbers[i+1], OnceInATram.onceInATram(magicNumbers[i]));
		}
	}
}
