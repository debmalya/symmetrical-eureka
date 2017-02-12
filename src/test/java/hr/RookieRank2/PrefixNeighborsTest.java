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
package hr.RookieRank2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class PrefixNeighborsTest {

	/**
	 * Test method for {@link hr.RookieRank2.PrefixNeighbors#benefitValue(java.lang.String)}.
	 */
	@Test
	public void testBenefitValue() {
		long benefitValue = PrefixNeighbors.benefitValue("B");
		Assert.assertEquals(66, benefitValue);
		Assert.assertEquals(134, PrefixNeighbors.benefitValue("AE"));
	}

	@Test
	public void testPrefixNeighbours() {
		Assert.assertTrue(PrefixNeighbors.isPrefixNeighbour("ABD", "ABDE"));
		Assert.assertFalse(PrefixNeighbors.isPrefixNeighbour("AB", "ABDE"));
		Assert.assertFalse(PrefixNeighbors.isPrefixNeighbour("B", "AE"));
		Assert.assertTrue(PrefixNeighbors.isPrefixNeighbour("A", "AE"));
		Assert.assertTrue(PrefixNeighbors.isPrefixNeighbour("ABC", "ABD"));
	}
	
	@Test
	public void testGetBenefitValues() {
		Assert.assertEquals(221, PrefixNeighbors.getBenefitValues(new String[] {"ABC","ABD","ABZ"}));
		Assert.assertEquals(200, PrefixNeighbors.getBenefitValues(new String[] {"A", "B", "AE"}));
		Assert.assertEquals(399, PrefixNeighbors.getBenefitValues(new String[] {"AA", "AB", "ABD", "ABDE"}));
		
	}
}
