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
package he;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class OldKeypadInAForeignLandTest {

	/**
	 * Test method for
	 * {@link he.OldKeypadInAForeignLand#getKeyStrokeCount(int, int[], int, int[])}
	 * .
	 */
	@Test
	public void testGetKeyStrokeCount() {

		int K = 4;
		int[] key = new int[] { 1, 1, 1, 1 };
		int[] frequencies = new int[] { 7, 3, 4, 1 };
		int actual = OldKeypadInAForeignLand.getKeyStrokeCount(4, frequencies, K, key);
		Assert.assertEquals(15, actual);

		K = 2;
		key = new int[] { 2, 2 };
		actual = OldKeypadInAForeignLand.getKeyStrokeCount(4, frequencies, K, key);
		Assert.assertEquals(19, actual);

		K = 3;
		key = new int[] { 1, 2, 1 };
		actual = OldKeypadInAForeignLand.getKeyStrokeCount(4, frequencies, K, key);
		Assert.assertEquals(16, actual);
		
		K = 1;
		key = new int[] { 4 };
		actual = OldKeypadInAForeignLand.getKeyStrokeCount(4, frequencies, K, key);
		Assert.assertEquals(28, actual);
	}

}
