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
package hr.cracking.coding.interview;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class DFSConnectedCellInAGridTest {

	/**
	 * Test method for {@link hr.cracking.coding.interview.DFSConnectedCellInAGrid#getMaxSize(int[][])}.
	 */
	@Test
	public void testGetMaxSize() {
		int[][] matrix = new int[][]{{1, 1, 1, 0, 1},
			{0, 0, 1, 0, 0},
			{1, 1, 0, 1, 0},
			{0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0}};
			
			int actual = DFSConnectedCellInAGrid.getMaxSize(matrix);
			assertEquals(9, actual);
	}

}
