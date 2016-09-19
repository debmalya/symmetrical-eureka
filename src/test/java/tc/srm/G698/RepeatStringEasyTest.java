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
package tc.srm.G698;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class RepeatStringEasyTest {

	/**
	 * Test method for {@link tc.srm.G698.RepeatStringEasy#maximalLength(java.lang.String)}.
	 */
	@Test
	public void testMaximalLength() {
		RepeatStringEasy re = new RepeatStringEasy();
		
		Assert.assertEquals(4, re.maximalLength("frankfurt"));
		Assert.assertEquals(0, re.maximalLength("single"));
		Assert.assertEquals(6, re.maximalLength("singleing"));
		Assert.assertEquals(0, re.maximalLength("x"));
		Assert.assertEquals(6, re.maximalLength("singing"));
		Assert.assertEquals(18, re.maximalLength("aababbababbabbbbabbabb"));
		
	}

}
