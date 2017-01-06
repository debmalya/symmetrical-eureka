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

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class HappyLadyBugsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hr.HappyLadyBugs#isLadyBugHappy(java.lang.String)}.
	 */
	@Test
	public void testIsLadyBugHappy() {
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("RBY_YBR"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("X_Y__X"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("B_RRBR"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("BBBBBB"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("BBBBBC"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("A"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("AA"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("AACDCD"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("AA_CDCD"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("__"));
		Assert.assertFalse(HappyLadyBugs.isLadyBugHappy("ZZYZZYZZ"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("ZZYZZ_YZZ"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("ZZYZZ_YZZY"));
		Assert.assertTrue(HappyLadyBugs.isLadyBugHappy("ZXZYZZ_YZZX"));
	}

}
