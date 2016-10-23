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
package cf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class StringUtilTest {

	/**
	 * Test method for
	 * {@link cf.StringUtil#IsPermutationOf(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testIsPermutationOf() {
		Assert.assertTrue(StringUtil.IsPermutationOf("abc", "bca"));
		Assert.assertFalse(StringUtil.IsPermutationOf("abc", "def"));
		Assert.assertTrue(StringUtil.IsPermutationOf("alphabet", "tpaealhb"));
		Assert.assertFalse(StringUtil.IsPermutationOf("abccbab", "aabbcc"));
		Assert.assertFalse(StringUtil.IsPermutationOf("bCbD", "BEac"));
		Assert.assertFalse(StringUtil.IsPermutationOf("abc", "abcd"));
		Assert.assertTrue(StringUtil.IsPermutationOf("pineapple", "enpielapp"));
	}

	@Test
	public void testtruncateOnlyText() {
		String actual = StringUtil.truncateOnlyText( "Lorem ipsum <i>dolor</i> <span>sit</span> amet, <b>eu nonumes facilis</b> reprimique vel, mutat persequeris pri ex.", 38);
		Assert.assertEquals("Lorem ipsum <i>dolor</i> <span>sit</span> amet, eu nonumes", actual);
		
		actual = StringUtil.truncateOnlyText( "You ordered <b>two</b> pizzas with <i>mushrooms</i> and vanilla <i>milkshake</i>.", 50);
		Assert.assertEquals("You ordered <b>two</b> pizzas with <i>mushrooms</i> and vanilla ", actual);
		
		actual = StringUtil.truncateOnlyText(  "Welcome to the <a href=\"/hotels\">hotel</a> California.", 20);
		Assert.assertEquals("Welcome to the <a href=\"/hotels\">hotel</a>", actual);
		
	}

}
