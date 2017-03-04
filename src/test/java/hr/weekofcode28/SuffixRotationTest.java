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
package hr.weekofcode28;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author debmalyajash
 *
 */
public class SuffixRotationTest {

	/**
	 * Test method for {@link hr.weekofcode28.SuffixRotation#getSuffixRotation(java.lang.String)}.
	 */
	@Test
	public void testGetSuffixRotation() {
		int actual = SuffixRotation.getSuffixRotation("abcdefghij");
		Assert.assertEquals(0, actual);
		
//		actual = SuffixRotation.getSuffixRotation("acab");
//		Assert.assertEquals(1, actual);
		
//		actual = SuffixRotation.getSuffixRotation("baba");
//		Assert.assertEquals(2, actual);
//		
//		actual = SuffixRotation.getSuffixRotation("abcda");
//		Assert.assertEquals(1, actual);
		
//		actual = SuffixRotation.getSuffixRotation("abcad");
//		Assert.assertEquals(1, actual);
		
//		actual = SuffixRotation.getSuffixRotation("acbad");
//		Assert.assertEquals(2, actual);
		
//		actual = SuffixRotation.getSuffixRotation("adcba");
//		Assert.assertEquals(3, actual);
		
//		actual = SuffixRotation.getSuffixRotation("zyx"); // xzy,xyz
//		Assert.assertEquals(2, actual);
		
//		actual = SuffixRotation.getSuffixRotation("abcdefjghi"); // abcdefijgh abcdefhijg abcdefghij
//		Assert.assertEquals(3, actual);
	}
	
	@Test
	public final void testLCS(){
//		int actual = SuffixRotation.lcs("abcdefghij");
//		Assert.assertEquals(0, actual);
		
//		actual = SuffixRotation.lcs("acab");
//		Assert.assertEquals(1, actual);
	}


	/**
	 * Test method for {@link hr.weekofcode28.SuffixRotation#rotate(java.lang.String, int)}.
	 */
	@Test
	public final void testRotate() {
//		int actual = SuffixRotation.rotate("acab", 1);
//		Assert.assertEquals(1,actual);
	}


}
