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



import org.bouncycastle.util.Arrays;
import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class CandyReplenshingRobotTest {

	/**
	 * Test method for {@link hr.weekOfCode30.CandyReplenshingRobot#getCandiesToAdd(int, int, int[])}.
	 */
	@Test
	public void testGetCandiesToAdd() {
		int refillCount = CandyReplenshingRobot.getCandiesToAdd(8, 4, new int[] {3,1,7,5});
		Assert.assertEquals(11, refillCount);
		
		refillCount = CandyReplenshingRobot.getCandiesToAdd(8, 3, new int[] {5,2,4});
		Assert.assertEquals(5, refillCount);
	}

	@Test
	public void testBoundaryConditions() {
		int n = 100;
		int t = 100;
		int[] c = new int[100];
		Arrays.fill(c, n);
		int refillCount = CandyReplenshingRobot.getCandiesToAdd(n, t, c);
		Assert.assertEquals(9900, refillCount);
		
		n = 1;
		t = 1;
		c = new int[100];
		Arrays.fill(c, n);
		refillCount = CandyReplenshingRobot.getCandiesToAdd(n, t, c);
		Assert.assertEquals(0, refillCount);
	}
}
