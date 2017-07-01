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

		Assert.assertEquals(3, arrayUtil.firstDuplicate(new int[] { 2, 3, 3, 1, 5, 2 }));
		Assert.assertEquals(-1, arrayUtil.firstDuplicate(new int[] { 2, 4, 3, 5, 1 }));
		Assert.assertEquals(6, arrayUtil.firstDuplicate(new int[] { 8, 4, 6, 2, 6, 4, 7, 9, 5, 8 }));
		Assert.assertEquals(3, arrayUtil.firstDuplicate(new int[] { 3, 3, 3 }));
	}

	@Test
	public void testFirstNonRepeatingCharacter() {
		Assert.assertEquals('c', arrayUtil.firstNotRepeatingCharacter("abacabad"));
		Assert.assertEquals('_', arrayUtil.firstNotRepeatingCharacter("abacabaabacaba"));
	}

	@Test
	public void testRotateImage() {
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] e = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		Assert.assertArrayEquals(e, arrayUtil.rotateImage(a));

		a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		e = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < 4; i++) {
			arrayUtil.rotateImage(a);
		}
		Assert.assertArrayEquals(e, a);
		
	}

	@Test
	public void testRotateImage1() {
		int[][] a = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] e = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		arrayUtil.rotateImage(a);
	}

	@Test
	public void testShapeArea() {
		Assert.assertEquals(5, arrayUtil.shapeArea(2));
	}

	@Test
	public void testAlmostIncreasingSequence() {
		Assert.assertFalse(arrayUtil.almostIncreasingSequence(new int[] { 1, 2, 1, 2 }));
		Assert.assertFalse(arrayUtil.almostIncreasingSequence(new int[] { 1, 3, 1, 3 }));
		Assert.assertFalse(arrayUtil.almostIncreasingSequence(new int[] { 1, 2, 3, 3, 3, 6 }));
		Assert.assertTrue(arrayUtil.almostIncreasingSequence(new int[] { 1, 2, 3, 4, 3, 6 }));
		Assert.assertTrue(arrayUtil.almostIncreasingSequence(new int[] { 1, 2, 3, 4, 4, 6 }));
		Assert.assertTrue(arrayUtil.almostIncreasingSequence(new int[] { 10, 1, 2, 3, 4, 5 }));
		Assert.assertTrue(arrayUtil.almostIncreasingSequence(new int[] {1, 2, 3, 4, 99, 5, 6}));
		Assert.assertFalse(arrayUtil.almostIncreasingSequence(new int[] { 1, 2, 3, 4, 3, 2 }));
		Assert.assertTrue(arrayUtil.almostIncreasingSequence(new int[] { 123, -17, -5, 1, 2, 3, 12, 43, 45 }));
		Assert.assertFalse(arrayUtil.almostIncreasingSequence(new int[] { 40, 50, 60, 10, 20, 30 }));
	}
	
	@Test
	public void testMatrixElementsSum() {
		int[][] arr = new int[][] {{0,1,1,2},{0,5,0,0},{2,0,3,3}};
		Assert.assertEquals(9, arrayUtil.matrixElementsSum(arr));
	}
}
