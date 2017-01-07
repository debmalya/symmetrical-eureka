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
package hr.stat;




import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class QuartileTest {

	/**
	 * Test method for {@link hr.stat.Quartile#getQuartile(int[])}.
	 */
	@Test
	public void testGetQuartile() {
		double[] values = Quartile.getQuartile(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18});
		Assert.assertEquals(12, values[1], 0);
		Assert.assertEquals(6, values[0], 0);
		Assert.assertEquals(16, values[2], 0);
		
		values = Quartile.getQuartile(new int[]{3, 7, 8, 5, 12, 14, 21, 15, 18, 14});
		
		Assert.assertEquals(13, values[1], 0);
		Assert.assertEquals(7, values[0], 0);
		Assert.assertEquals(15, values[2], 0);
	}

	/**
	 * Test method for {@link hr.stat.Quartile#getMedian(int[])}.
	 */
	@Test
	public void testGetMedian() {
		double actual = Quartile.getMedian(new int[]{18,45,55,70,76,83,88,90,92,92,95,98});
		Assert.assertEquals(85.5, actual,0.00);
		
		actual = Quartile.getMedian(new int[]{18,45,55,70,76,83});
		Assert.assertEquals(62.5, actual,0.00);
		
		actual = Quartile.getMedian(new int[]{90,92,92,95,98});
		Assert.assertEquals(92, actual,0.00);
	}

}
