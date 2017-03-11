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
package hr.weekOfCode29;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class DayOfTheProgrammerTest {

	@Test
	public void test() {
		for (int year = 1700; year < 2701; year++) {
			String programmersDay = DayOfTheProgrammer.getProgrammersDay(year);
			if (year == 1918) {
				Assert.assertEquals("26.09.1918", programmersDay);
			} else if (year < 1918) {
				if (year % 4 == 0) {
					Assert.assertEquals("12.09."+year, programmersDay);
				} else {
					Assert.assertEquals("13.09."+year, programmersDay);
				}
			} else {
				if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
					Assert.assertEquals("12.09."+year, programmersDay);
				} else {
					Assert.assertEquals("13.09."+year, programmersDay);
				}
			}
		}
	}

}
