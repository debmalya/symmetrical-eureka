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
package cf.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class CryptoMathicTest {

	CryptoMathic cry = new CryptoMathic();

	/**
	 * Test method for
	 * {@link cf.practice.CryptoMathic#isCryptSolution(java.lang.String[], char[][])}
	 * .
	 */
	@Test
	public void testIsCryptSolution() {
		String[ ] crypt = new String[] { "SEND", "MORE", "MONEY" };
		char[ ][ ] solution = new char[][] { { 'O', '0' }, { 'M', '1' }, { 'Y', '2' }, { 'E', '5' }, { 'N', '6' },
				{ 'D', '7' }, { 'R', '8' }, { 'S', '9' } };
		Assert.assertTrue( cry.isCryptSolution( crypt, solution ) );

		crypt = new String[] { "ONE", "ONE", "TWO" };
		solution = new char[][] { { 'O', '2' }, { 'T', '4' }, { 'W', '6' }, { 'E', '1' }, { 'N', '3' } };
		Assert.assertTrue( cry.isCryptSolution( crypt, solution ) );

		crypt = new String[] { "TEN", "TWO", "ONE" };
		solution = new char[][] { { 'O', '1' }, { 'T', '0' }, { 'W', '9' }, { 'E', '5' }, { 'N', '4' } };
		Assert.assertFalse( cry.isCryptSolution( crypt, solution ) );
	}

}
