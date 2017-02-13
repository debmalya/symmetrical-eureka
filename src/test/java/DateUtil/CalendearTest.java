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
package DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class CalendearTest {

	/**
	 * Test method for {@link DateUtil.Calendear#convertTimeStampToYearMonth(long)}.
	 */
	@Test
	public void testConvertTimeStampToYearMonth() {
		long actual = Calendear.convertTimeStampToYearMonth(1485873191000L);
		Assert.assertEquals(201701,actual);
	}
	
	@Test
	public void testGetFirstDayOfMonthEpochTime() {
		long actual = Calendear.getFirstDayOfMonthEpochTime(System.currentTimeMillis());
		
	}
	
	@Test
	public void testGetCalendarFactor() {
		StringBuilder today = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int dayOfMonth = Calendear.getCalendarFactor(Calendar.DAY_OF_MONTH);
		if (dayOfMonth < 10) {
			today.append("0");
		}
		today.append(dayOfMonth);
		today.append("/");
		
		int monthNumber = Calendear.getCalendarFactor(Calendar.MONTH) + 1;
		if (monthNumber < 10) {
			today.append("0");
		}
		today.append(monthNumber);
		today.append("/");
		
		int yearNumber = Calendear.getCalendarFactor(Calendar.YEAR);
		today.append(yearNumber);
		
		Assert.assertEquals(today.toString(), sdf.format(new Date()));	
	}
	
	@Test
	public void test24HourFormat() {
		Assert.assertEquals("12:00:00",Calendear.convertTo24HourFormat("00:00:00PM"));
		Assert.assertEquals("00:00:00",Calendear.convertTo24HourFormat("00:00:00AM"));
		Assert.assertEquals("19:05:45",Calendear.convertTo24HourFormat("07:05:45PM"));
		Assert.assertEquals("00:00:00",Calendear.convertTo24HourFormat("12:00:00AM"));
		Assert.assertEquals("00:59:59",Calendear.convertTo24HourFormat("12:59:59AM"));
		Assert.assertEquals("12:45:54",Calendear.convertTo24HourFormat("12:45:54PM"));
	}

}
