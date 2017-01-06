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
public class AppendDeleteTest {

	/**
	 * Test method for {@link hr.AppendDelete#isPossible(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testIsPossible() {
		Assert.assertEquals("Yes", AppendDelete.isPossible("Hackerrank", "Hackerhappy", 9));
		Assert.assertEquals("Yes", AppendDelete.isPossible("aba","aba",7));
	}

}
