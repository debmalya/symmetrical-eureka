package cf;

import java.time.LocalDate;

public class DateUtility {

	public static void main(String[] args) {

	}

	/**
	 * Calculate the number of days between two given dates, where each date is
	 * represented with three integers: day, year and month.
	 * 
	 * It is guaranteed that the given time interval is valid, i.e. the second
	 * date is after the first date in the calendar or coincides with it.
	 * 
	 * @param day1
	 * @param month1
	 * @param year1
	 * @param day2
	 * @param month2
	 * @param year2
	 * @return
	 */
	int uShouldDate(int day1, int month1, int year1, int day2, int month2, int year2) {
		
		return (int)Math.abs(toEpochDay(year1, month1, day1) - toEpochDay(year2,month2,day2));
	}
	
	 public long toEpochDay(long y,long m,long day) {
		    int DAYS_PER_CYCLE = 146097;
			long DAYS_0000_TO_1970 = (DAYS_PER_CYCLE * 5L) - (30L * 365L + 7L);
	        long total = 0;
	        total += 365 * y;
	        if (y >= 0) {
	            total += (y + 3) / 4 - (y + 99) / 100 + (y + 399) / 400;
	        } else {
	            total -= y / -4 - y / -100 + y / -400;
	        }
	        total += ((367 * m - 362) / 12);
	        total += day - 1;
	        if (m > 2) {
	            total--;
	            if (isLeapYear(y) == false) {
	                total--;
	            }
	        }
	        return total - DAYS_0000_TO_1970;
	    }
	
	public boolean isLeapYear(long prolepticYear) {
        return ((prolepticYear & 3) == 0) && ((prolepticYear % 100) != 0 || (prolepticYear % 400) == 0);
    }
	
	int uShouldDate0(int day1, int month1, int year1, int day2, int month2, int year2) {
		LocalDate date1 = LocalDate.of(year1, month1, day1);
		LocalDate date2 = LocalDate.of(year2, month2, day2);
		long l1 = date1.toEpochDay();
		long l2 = date2.toEpochDay();
		
		return (int) Math.abs(l1 - l2);
	}

}
