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
public class BeautfulSetsTest {

	/**
	 * Test method for
	 * {@link hr.BeautfulSets#getNumberOfBeautifulSets(int, int)}.
	 */
	@Test
	public final void testGetNumberOfBeautifulSets() {
		long actual = BeautfulSets.getNumberOfBeautifulSets(6, 4);
		Assert.assertEquals(6, actual);

		actual = BeautfulSets.getNumberOfBeautifulSets(6, 3);
		Assert.assertEquals(3, actual);

		actual = BeautfulSets.getNumberOfBeautifulSets(27, 2);
		Assert.assertEquals(26, actual);

		actual = BeautfulSets.getNumberOfBeautifulSets(7, 4);
		Assert.assertEquals(9, actual);
		
		actual = BeautfulSets.getNumberOfBeautifulSets(7, 3);
		Assert.assertEquals(5, actual);
		
		actual = BeautfulSets.getNumberOfBeautifulSets(7, 5);
		Assert.assertEquals(3, actual);
		
//		actual = BeautfulSets.getNumberOfBeautifulSets(8, 4);
//		Assert.assertEquals(15, actual);


	}

}
