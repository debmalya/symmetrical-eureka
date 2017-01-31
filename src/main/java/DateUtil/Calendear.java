package DateUtil;
import java.util.Calendar;
import java.util.TimeZone;

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

/**
 * @author debmalyajash
 *
 */
public class Calendear {
	
	/**
	 * 
	 * @param timeStamp
	 * @return 201701 for January 2017
	 * 201702 for February 2017
	 */
	public static long convertTimeStampToYearMonth(long timeStamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeStamp);
		return cal.get(Calendar.YEAR)*100+cal.get(Calendar.MONTH)+1;
	}
	
	/**
	 * 
	 * @param timeStamp
	 * @return first day of the month in epoch time.
	 */
	public static long getFirstDayOfMonthEpochTime(long timeStamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeStamp);
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

}
