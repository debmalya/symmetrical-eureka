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
package hr.weekOfCode30;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class AGraphProblemTest {

	/**
	 * Test method for
	 * {@link hr.weekOfCode30.AGraphProblem#getTraingle(int[][])}.
	 */
	@Test
	public void testGetTraingle() {
		int[][] graph = new int[][] { { 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 } };
		Integer[] traingles = AGraphProblem.getTraingle(graph);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, traingles);
		

		graph = new int[][] { { 0, 1, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0, 0 }, { 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 1, 0 } };
		traingles = AGraphProblem.getTraingle(graph);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, traingles);
	}

}
