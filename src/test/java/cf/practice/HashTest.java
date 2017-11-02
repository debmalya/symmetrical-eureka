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
package cf.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class HashTest {

	/**
	 * Test method for
	 * {@link cf.practice.Hash#areFollowingPatterns(java.lang.String[], java.lang.String[])}
	 * .
	 */
	@Test
	public void testAreFollowingPatterns() {
		Hash hash = new Hash();
		Assert.assertTrue(
				hash.areFollowingPatterns( new String[] { "cat", "dog", "dog" }, new String[] { "a", "b", "b" } ) );
		Assert.assertFalse(
				hash.areFollowingPatterns( new String[] { "a", "b", "b" }, new String[] { "a", "b", "x" } ) );
		Assert.assertFalse(
				hash.areFollowingPatterns( new String[] { "cat", "dog", "doggy" }, new String[] { "a", "b", "b" } ) );
	}

}
