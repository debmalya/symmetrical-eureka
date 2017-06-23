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
package array.util;

import org.junit.Assert;
import org.junit.Test;





/**
 * @author debmalyajash
 *
 */
public class ArrayUtilTest {
	
	ArrayUtil arrayUtil = new ArrayUtil();

	/**
	 * Test method for {@link array.util.ArrayUtil#firstDuplicate(int[])}.
	 */
	@Test
	public void testFirstDuplicate() {
		
		Assert.assertEquals(3, arrayUtil.firstDuplicate(new int[] {2, 3, 3, 1, 5, 2}));
		Assert.assertEquals(-1, arrayUtil.firstDuplicate(new int[] {2, 4, 3, 5, 1}));
		Assert.assertEquals(6, arrayUtil.firstDuplicate(new int[] {8, 4, 6, 2, 6, 4, 7, 9, 5, 8}));
		Assert.assertEquals(3, arrayUtil.firstDuplicate(new int[] {3,3,3}));
	}

	@Test
	public void testFirstNonRepeatingCharacter() {
		Assert.assertEquals('c',arrayUtil.firstNotRepeatingCharacter("abacabad"));
		Assert.assertEquals('_',arrayUtil.firstNotRepeatingCharacter("abacabaabacaba"));
	}
}
