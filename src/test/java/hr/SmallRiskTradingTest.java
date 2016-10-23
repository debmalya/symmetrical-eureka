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
public class SmallRiskTradingTest {

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hr.SmallRiskTrading#getMaxProfit(int, int, float[], float[], float[])}.
	 */
	@Test
	public void testGetMaxProfit() {
		float actual = SmallRiskTrading.getMaxProfit(4, 2,  new float[]{4.0f, 1.0f, 2.0f, 3.0f}, new float[]{4.0f, 0.5f, 1.0f, 1.0f},new float[]{0.5f ,0.5f, 0.5f, 0.5f});
		Assert.assertEquals(1.50f, actual,0.00d);
		
		actual = SmallRiskTrading.getMaxProfit(2, 2,  new float[]{1.0f, 0.5f}, new float[]{100.0f, 0.4f},new float[]{0.9f ,0.5f});
		Assert.assertEquals(0.05, actual,0.00d);
	}

}
