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
public class DrawingBookTest {

	/**
	 * Test method for {@link hr.DrawingBook#solve(int, int)}.
	 */
	@Test
	public void testSolve() {
		Assert.assertEquals(0, DrawingBook.solve(6, 1));
		Assert.assertEquals(1, DrawingBook.solve(6, 4));
		Assert.assertEquals(1, DrawingBook.solve(6, 3));
		Assert.assertEquals(1, DrawingBook.solve(6, 2));
		Assert.assertEquals(0, DrawingBook.solve(6, 1));
		Assert.assertEquals(0, DrawingBook.solve(6, 6));
		Assert.assertEquals(1, DrawingBook.solve(6, 5));
		
		Assert.assertEquals(0, DrawingBook.solve(5, 4));
		Assert.assertEquals(0, DrawingBook.solve(5, 5));
		Assert.assertEquals(1, DrawingBook.solve(5, 3));
		Assert.assertEquals(1, DrawingBook.solve(5, 2));
		Assert.assertEquals(0, DrawingBook.solve(5, 1));
		
		Assert.assertEquals(0, DrawingBook.solve(1, 1));
		Assert.assertEquals(0, DrawingBook.solve(100000, 1));
		Assert.assertEquals(0, DrawingBook.solve(100000, 100000));
		Assert.assertEquals(1, DrawingBook.solve(100000, 2));
		Assert.assertEquals(25000, DrawingBook.solve(100000, 100000/2));
		
		
		
	}

}
