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
package ht;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class LetsSkiTest {

	/**
	 * Test method for {@link ht.LetsSki#bestSkiWay(int[][])}.
	 */
	@Test
	public final void testBestSkiWay() {
		int[][] skiCourt = new int[][]{{4,8,7,3},{2,5,9,3},{6,3,2,5},{4,4,1,6}};
		int[] result = LetsSki.bestSkiWay(skiCourt);
//		Assert.assertEquals(5,result[0]);
//		Assert.assertEquals(8,result[1]);
	}

}
