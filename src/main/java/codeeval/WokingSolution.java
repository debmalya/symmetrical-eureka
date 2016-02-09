/**
 * 
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class WokingSolution {

	private static final long YEAR_IN_MILISECOND = 31556952000L;

	public static void main(String[] args) {
		if (args.length > 0) {
			Integer[] exps = getAcutalWorkExperience(args[0]);
			for (Integer each : exps) {
				System.out.println(each);
			}
		} else {
			System.err.println("Please specify input file name.");
		}
	}

	/**
	 * 
	 * @param fileNameF
	 *            Each line of the file contains a list of time periods
	 *            separated by a semicolon and a single space. Each time period
	 *            is represented as the begin date and the end date. Each date
	 *            consists of a month as an abbreviated name and a year with
	 *            century as a decimal number separated by a single space.
	 * @return
	 */
	public static Integer[] getAcutalWorkExperience(String fileName) {
		List<Integer> expList = new ArrayList<Integer>();
		try (BufferedReader reader = new BufferedReader(
				new FileReader(fileName))) {
			String each = "";
			while ((each = reader.readLine()) != null) {
				String[] values = each.split(";");
				WorkingExperienceList wes = new WorkingExperienceList();
				WorkingExperience we = null;
				for (String eachExperience : values) {
					eachExperience = eachExperience.trim();
					if (eachExperience.trim().length() > 0) {
						we = new WorkingExperience(eachExperience);
						wes.addWorkingExperience(we);
					}

				}

				expList.add(wes.getDuration());
			}

		} catch (Throwable th) {
			System.err.println(th.getMessage());
		}

		return expList.toArray(new Integer[0]);
	}

	static class WorkingExperienceList {
		List<WorkingExperience> workingExperiences = new ArrayList<WorkingExperience>();
		int totalMonths = 0;

		public boolean addWorkingExperience(WorkingExperience workingExperience) {
			if (!workingExperiences.isEmpty()) {
				for (WorkingExperience each : workingExperiences) {
					if (each.addExperience(workingExperience)) {
						return false;
					}
				}

			}

			totalMonths += workingExperience.getDiff();
			workingExperiences.add(workingExperience);
			return true;
		}

		public int getDuration() {

			return totalMonths / 12;
		}
	}

	static class WorkingExperience {
		private Calendar start;
		private Calendar end;
		private int diff;

		public WorkingExperience(String experiencePeriod) {
			Calendar[] period = getStartEndDate(experiencePeriod);
			setExperience(period[0], period[1]);
		}

		private Calendar[] getStartEndDate(String experiencePeriod) {
			String[] dates = experiencePeriod.split("-");
			SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
			Calendar[] period = new Calendar[2];
			try {
				period[0] = Calendar.getInstance();
				period[0].setTime(sdf.parse(dates[0]));
				period[0].set(Calendar.DAY_OF_MONTH, 1);

				period[1] = Calendar.getInstance();
				period[1].setTime(sdf.parse(dates[1]));
				period[1].set(Calendar.DAY_OF_MONTH,
						period[1].getActualMaximum(Calendar.DAY_OF_MONTH));
				period[1].set(Calendar.HOUR, 23);
				period[1].set(Calendar.MINUTE, 59);
				period[1].set(Calendar.SECOND, 59);

			} catch (ParseException e) {
				System.err.println(e.getMessage() + " not able to parse "
						+ experiencePeriod);
			}
			return period;
		}

		/**
		 * @param eachExperience
		 */
		public boolean addExperience(WorkingExperience eachExperience) {
			long st = start.getTimeInMillis();
			long en = end.getTimeInMillis();

			long st1 = eachExperience.start.getTimeInMillis();
			long en1 = eachExperience.end.getTimeInMillis();

			boolean startTimeWithin = false;
			if (st1 >= st && st1 <= en) {
				if (en1 > en) {
					end.setTimeInMillis(en1);
				}
				startTimeWithin = true;
			}

			if (en1 >= st && en1 <= en) {
				if (st1 < st) {
					start.setTimeInMillis(st1);
				}
				if (startTimeWithin) {
					// No need to add this experience.
					return true;
				}
			}
			return false;
		}

		public void setExperience(Calendar startDate, Calendar endDate) {

			if (endDate.after(startDate)) {
				start = startDate;
				end = endDate;

			} else {
				System.err.println(endDate.getTime() + " not after "
						+ startDate.getTime());
			}
		}

		/**
		 * @return the diff
		 */
		public int getDiff() {
			setDiff();
			return diff;
		}

		/**
		 * @param diff
		 *            the diff to set
		 */
		private void setDiff() {
			diff = (int) ((end.getTimeInMillis() - start.getTimeInMillis()) * 12 / YEAR_IN_MILISECOND);

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "WorkingExperience [start=" + start.getTime() + ", end="
					+ end.getTime() + ", diff=" + diff + "]";
		}

	}
}
