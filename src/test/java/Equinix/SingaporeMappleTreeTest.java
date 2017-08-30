/**
 * Copyright 2015-2017 Debmalya Jash
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
package Equinix;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author debmalyajash
 *
 */
public class SingaporeMappleTreeTest {
	
	SingaporeMappleTree mappleTree = new SingaporeMappleTree();

	/**
	 * Test method for {@link Equinix.SingaporeMappleTree#getFirstRepeatingWord(java.lang.String)}.
	 */
	@Test
	public void testGetFirstRepeatingWord() {
		String sentence = "This interview is conducted at mapple tree business city, Singapore. There are two interviewers. Interview started at 1:09 pm";
		String firstRepeatingWord = mappleTree.getFirstRepeatingWord( sentence );
		Assert.assertEquals( "Interview", firstRepeatingWord );
		
	    sentence = null;
		firstRepeatingWord = mappleTree.getFirstRepeatingWord( sentence );
		Assert.assertEquals( "", firstRepeatingWord );
		
		sentence = "They asked me to code the first repeating word and test it";
		firstRepeatingWord = mappleTree.getFirstRepeatingWord( sentence );
		Assert.assertEquals( "", firstRepeatingWord );
		
		sentence = "They asked me to test white box";
		firstRepeatingWord = mappleTree.getFirstRepeatingWord( sentence );
		Assert.assertEquals( "", firstRepeatingWord );
		
		sentence = "They talked about space and  more    space and          more space";
		firstRepeatingWord = mappleTree.getFirstRepeatingWord( sentence );
		Assert.assertEquals( "space", firstRepeatingWord );
	}

}
