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
package cf.bots.sigma;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ResourceTest {

	/**
	 * Test method for
	 * {@link cf.bots.sigma.Resource#dataRoute(int, int, int[][])}.
	 */
	@Test
	public void testDataRoute() {
		Resource resource = new Resource();
		int actual = resource.dataRoute(4, 5, new int[][] { { 0, 2, 4, 8, 0, 0 }, { 0, 0, 0, 9, 0, 0 },
				{ 0, 0, 0, 0, 0, 10 }, { 0, 0, 6, 0, 0, 10 }, { 10, 10, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } });
		Assert.assertEquals(19, actual);

		actual = resource.dataRoute(2, 5,
				new int[][] { { 0, 0, 0, 0, 2, 0, 998, 0, 0, 0, 0 }, { 1000, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0 },
						{ 0, 1239, 0, 1111, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 587, 439, 0, 0 },
						{ 0, 0, 0, 0, 0, 1001, 3, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 239 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 890, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 2, 0, 485, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 932 },
						{ 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0 } });
		Assert.assertEquals(2000, actual);
		
		actual = resource.dataRoute(0, 3,
				new int[][]{{0,1000,1000,0}, 
				            {0,0,1000,1}, 
				            {0,1,0,1000}, 
				            {0,0,0,0}});
		Assert.assertEquals(1001, actual);
	}

}
