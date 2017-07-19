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
package hr.weekOfCode34;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class MaximumSumGCDTest {

	/**
	 * 
	 */
	private static final int MAX_SIZE = 100000;

	/**
	 * Test method for {@link hr.weekOfCode34.MaximumSumGCD#maximumGcdAndSum(int[], int[])}.
	 */
	@Test
	public void testMaximumGcdAndSum() {
		int[] A = new int[] {3, 1, 4, 2, 8};
		int[] B = new int[] {5, 2, 12, 8, 3};
		Assert.assertEquals(16, MaximumSumGCD.maximumGcdAndSum(A, B));
		
		 A = new int[] {3, 1, 5, 2, 7};
		 B = new int[] {5, 2, 11, 7, 3};
		 Assert.assertEquals(14, MaximumSumGCD.maximumGcdAndSum(A, B));
		 
		 A = new int[] {3, 1, 5, 2, 7};
		 B = new int[] {13, 17, 11, 19, 23};
		 Assert.assertEquals(30, MaximumSumGCD.maximumGcdAndSum(A, B));
		 
		 A = new int[] {3, 1, 5, 2, 7};
		 B = new int[] {2, 17, 11, 19, 23};
		 Assert.assertEquals(4, MaximumSumGCD.maximumGcdAndSum(A, B));
		 
		 // max GCD - 11
		 A = new int[] {3, 1, 5, 2, 11};
		 B = new int[] {13, 17, 11, 19, 23};
		 Assert.assertEquals(22, MaximumSumGCD.maximumGcdAndSum(A, B));
		 
		 A = new int[MAX_SIZE];
		 B = new int[MAX_SIZE];
		 for (int i = 0; i < MAX_SIZE; i++) {
			 A[i] = (int)(Math.random()*MAX_SIZE)+1;
			 B[i] = (int)(Math.random()*MAX_SIZE)+1;
		 }
		 long start = System.currentTimeMillis();
		 System.out.println(MaximumSumGCD.maximumGcdAndSum(A, B));
		 System.out.println("time taken :" + (System.currentTimeMillis() - start) + " mili seconds.");
	}

	/**
	 * Test method for {@link hr.weekOfCode34.MaximumSumGCD#gcd(int, int)}.
	 */
	@Test
	public void testGcd() {
		Assert.assertEquals(8, MaximumSumGCD.gcd(8, 8));
		Assert.assertEquals(4, MaximumSumGCD.gcd(12, 8));
	}

}
