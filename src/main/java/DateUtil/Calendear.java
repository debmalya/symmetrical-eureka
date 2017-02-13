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
	 * @return 201701 for January 2017 201702 for February 2017
	 */
	public static long convertTimeStampToYearMonth(long timeStamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeStamp);
		return cal.get(Calendar.YEAR) * 100 + cal.get(Calendar.MONTH) + 1;
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

	/**
	 * Return specific field value from calendar instance.
	 * 
	 * @param typeOfField
	 *            - type of calendar field.
	 * @return value of the field
	 */
	public static int getCalendarFactor(int typeOfField) {
		switch (typeOfField) {
		case Calendar.DAY_OF_WEEK:
			return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		case Calendar.DAY_OF_MONTH:
			return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		case Calendar.HOUR_OF_DAY:
			return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		case Calendar.MONTH:
			return Calendar.getInstance().get(Calendar.MONTH);
		case Calendar.DAY_OF_YEAR:
			return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		case Calendar.YEAR:
			return Calendar.getInstance().get(Calendar.YEAR);
		default:
			return -99;
		}

	}

	/**
	 * 
	 * @param timeIn12HourFormat
	 *            time in 12 hour format.
	 * @return time in 24 hour format.
	 */
	public static String convertTo24HourFormat(String timeIn12HourFormat) {
		if (timeIn12HourFormat != null) {
			int hour = 0;
			boolean isAM = false;
			timeIn12HourFormat = timeIn12HourFormat.toUpperCase();
			if (timeIn12HourFormat.endsWith("PM")) {
				hour += 12;

			} else {
				isAM = true;
			}

			timeIn12HourFormat = timeIn12HourFormat.replace("PM", "");
			timeIn12HourFormat = timeIn12HourFormat.replace("AM", "");

			String[] timeComponents = timeIn12HourFormat.split(":");
			hour += Integer.parseInt(timeComponents[0]);
			StringBuilder timeIn24HourFormat = new StringBuilder("");
			if (isAM && hour > 11) {
				hour -= 12;
			} else if (hour == 24) {
				hour = 0;
			}
			if (hour < 10) {
				timeIn24HourFormat.append("0");
			}
			timeIn24HourFormat.append(hour);
			timeIn24HourFormat.append(":");
			timeIn24HourFormat.append(timeComponents[1]);
			timeIn24HourFormat.append(":");
			timeIn24HourFormat.append(timeComponents[2]);

			return timeIn24HourFormat.toString();
		}
		return null;
	}

}
