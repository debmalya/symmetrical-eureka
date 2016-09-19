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
package tc.srm.G698;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class InitialsTest {

	/**
	 * Test method for {@link tc.srm.G698.Initials#getInitials(java.lang.String)}.
	 */
	@Test
	public void testGetInitials() {
		Initials in = new Initials();
		String actual = in.getInitials("john fitzgerald kennedy");
		Assert.assertEquals("jfk", actual);
		
		actual = in.getInitials("looks good to me");
		Assert.assertEquals("lgtm", actual);
		
		actual = in.getInitials("single round match");
		Assert.assertEquals("srm", actual);
		
		actual = in.getInitials("a aa aaa aa a bbb bb b bb bbb");
		Assert.assertEquals( "aaaaabbbbb", actual);

	}

}
