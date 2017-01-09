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
package he.capillary;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class StringQueriesTest {

	/**
	 * Test method for {@link he.capillary.StringQueries#numberOfReduction(java.lang.String)}.
	 */
	@Test
	public void testNumberOfReduction() {
		int actual = StringQueries.numberOfReduction("abcdab");
		Assert.assertEquals(2, actual);
		actual = StringQueries.numberOfReduction("bcdabc");
		Assert.assertEquals(2, actual);
		actual = StringQueries.numberOfReduction("abbcc");
		Assert.assertEquals(1, actual);
		actual = StringQueries.numberOfReduction("abbccdd");
		Assert.assertEquals(1, actual);
		actual = StringQueries.numberOfReduction("abbccddd");
		Assert.assertEquals(2, actual);
	}

}
