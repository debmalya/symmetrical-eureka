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
package hr.linkedin;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class LongestCommonSubsequenceTest {
	
	@Test
	public void testGetLongestCommonSubsequence() {
		Assert.assertEquals("2 3",
				LongestCommonSubsequence.find(new int[] { 1, 2, 3 }, new int[] { 4, 2, 3 }).trim());
		
		System.out.println("----------------------------------");
		Assert.assertEquals("1 2 3", LongestCommonSubsequence.find(new int[] { 1, 2, 3, 4, 1 },
				new int[] { 3, 4, 1, 2, 1, 3 }).trim());
		System.out.println("----------------------------------");
		Assert.assertEquals("1 2",
				LongestCommonSubsequence.find(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).trim());
	}

	/**
	 * Test method for
	 * {@link hr.linkedin.LongestCommonSubsequence#getLongestCommonSubsequence(int[], int[])}
	 * .
	 */
//	@Test
	public void testGetLongestCommonSubsequence0() {
		Assert.assertEquals("2 3",
				LongestCommonSubsequence.getLongestCommonSubsequence0(new int[] { 1, 2, 3 }, new int[] { 4, 2, 3 }).trim());
		
//		System.out.println("----------------------------------");
		
		Assert.assertEquals("1 2 3", LongestCommonSubsequence.getLongestCommonSubsequence0(new int[] { 1, 2, 3, 4, 1 },
				new int[] { 3, 4, 1, 2, 1, 3 }).trim());
		
//		System.out.println("----------------------------------");

		Assert.assertEquals("1 2",
				LongestCommonSubsequence.getLongestCommonSubsequence0(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }).trim());
	}

//	@Test
	public void testGetLongestCommonSubsequenceString() {
		Assert.assertEquals("AANA",
				LongestCommonSubsequence.getLongestCommonSubsequence("BANANA".toCharArray(), "ATANA".toCharArray()));
	}

}
