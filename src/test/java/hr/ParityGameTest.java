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
public class ParityGameTest {

	ParityGame pg = new ParityGame();

	/**
	 * Test method for
	 * {@link hr.ParityGame#smallestSizeSubsequence(int, int[])}.
	 */
	@Test
	public final void testSmallestSizeSubsequence() {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		Assert.assertEquals(1, ParityGame.smallestSizeSubsequence(arr.length, arr));

		arr = new int[] { 2, 4 };
		Assert.assertEquals(0, ParityGame.smallestSizeSubsequence(arr.length, arr));
		
		arr = new int[] { 5, 7 };
		Assert.assertEquals(0, ParityGame.smallestSizeSubsequence(arr.length, arr));
		
		arr = new int[] { 5, 6 };
		Assert.assertEquals(1, ParityGame.smallestSizeSubsequence(arr.length, arr));
		
		arr = new int[] { 5, 6, 7 };
		Assert.assertEquals(0, ParityGame.smallestSizeSubsequence(arr.length, arr));
		
		arr = new int[] { 5 };
		Assert.assertEquals(-1, ParityGame.smallestSizeSubsequence(arr.length, arr));
	}

}
