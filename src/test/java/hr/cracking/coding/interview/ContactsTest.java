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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ContactsTest {

	/**
	 * Test method for {@link hr.cracking.coding.interview.Contacts#add(java.lang.String)}.
	 */
//	@Test
	public void testAdd() {
		Contacts.add("hack");
		Contacts.add("hackerrank");
	}

	/**
	 * Test method for {@link hr.cracking.coding.interview.Contacts#find(java.lang.String)}.
	 */
	@Test
	public void testFind() {
		Contacts.add("hack");
		Contacts.add("hackerrank");
		Assert.assertEquals(0,Contacts.find("jash"));
		Assert.assertEquals(0,Contacts.find("hak"));
		Assert.assertEquals(2,Contacts.find("hack"));
		Assert.assertEquals(1,Contacts.find("hackerrank"));
	}

}
