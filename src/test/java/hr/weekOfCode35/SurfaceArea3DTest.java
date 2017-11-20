/**
 * Copyright 2015-2017 Debmalya Jash
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
package hr.weekOfCode35;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class SurfaceArea3DTest {

	/**
	 * Test method for
	 * {@link hr.weekOfCode35.SurfaceArea3D#surfaceArea(int[][])}.
	 */
	@Test
	public void testSurfaceArea() {

		int[ ][ ] areas = new int[][] { { 1, 1 }, { 0, 0 } };
		SurfaceArea3D.H = 2;
		SurfaceArea3D.W = 2;
		Assert.assertEquals( 10, SurfaceArea3D.surfaceArea( areas ) );

		areas = new int[][] { { 1, 1 }, { 1, 0 } };
		Assert.assertEquals( 14, SurfaceArea3D.surfaceArea( areas ) );

		areas = new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } };
		SurfaceArea3D.H = 3;
		SurfaceArea3D.W = 3;
		Assert.assertEquals( 60, SurfaceArea3D.surfaceArea( areas ) );
	}

}
