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
public class FindTheMinimumNumberTest {

	/**
	 * Test method for {@link hr.weekOfCode30.FindTheMinimumNumber#getComparisonString(int)}.
	 */
	@Test
	public void testGetComparisonString() {
		Assert.assertEquals("min(int, int)", FindTheMinimumNumber.getComparisonString(2));
		Assert.assertEquals("min(int, min(int, int))", FindTheMinimumNumber.getComparisonString(3));
		Assert.assertEquals("min(int, min(int, min(int, int)))", FindTheMinimumNumber.getComparisonString(4));
		String result = FindTheMinimumNumber.getComparisonString(50);
		int original = result.length();
		int modified = result.replace("min", "").length();
		int minCount = (original - modified ) / 3;
		Assert.assertEquals(49, minCount);
	}

}
