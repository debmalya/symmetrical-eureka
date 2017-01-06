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
package hr.cracking.coding.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class BalanceBracketTest {

	/**
	 * Test method for
	 * {@link hr.cracking.coding.interview.BalanceBracket#isBalanced(java.lang.String)}
	 * .
	 */
	@Test
	public void testIsBalanced() {
		Assert.assertTrue(BalanceBracket.isBalanced("()"));
		Assert.assertFalse(BalanceBracket.isBalanced("("));
		Assert.assertTrue(BalanceBracket.isBalanced("{()}"));
		Assert.assertTrue(BalanceBracket.isBalanced("{[()]}"));
		Assert.assertFalse(BalanceBracket.isBalanced("{[(])}"));
		Assert.assertTrue(BalanceBracket.isBalanced("{{[[(())]]}}"));
		Assert.assertFalse(BalanceBracket.isBalanced("{{[[(("));
	}

	@Test
	public void testSystem() {
		List<String> inputList = readFile("./src/main/resources/BalanceBracket_Input.rtf");
		Assert.assertEquals(1001, inputList.size());

	}

	/**
	 * 
	 */
	private List<String> readFile(final String fileName) {
		List<String> inputList = new ArrayList<>();
		try (BufferedReader fis = new BufferedReader(new FileReader(fileName))) {
			String eachLine = null;
			while ((eachLine = fis.readLine()) != null) {
				inputList.add(eachLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputList;
	}

}
