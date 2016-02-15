/**
 * 
 */
package cf;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author debmalyajash
 *
 */
public class Instabot {
	/**
	 * Understand the requirements of the algorithm and implement the given
	 * function. When you run your code it only runs against some of the test
	 * cases but when you submit, we run it against all tests. So even if the
	 * run is successful, the submit might not be. After recently joining
	 * Instacart's beta testing developer group, you decide to experiment with
	 * their new API. You know that the API returns item-specific display-ready
	 * strings like 10.0% higher than in-store or 5.0% lower than in-store that
	 * inform users when the price of an item is different from the one
	 * in-store. But you want to extend this functionality by giving people a
	 * better sense of how much more they will be paying for their entire
	 * shopping cart.
	 * 
	 * Your app lets a user decide the total amount x they are willing to pay
	 * via Instacart over in-store prices. This you call their price
	 * sensitivity.
	 * 
	 * Your job is to determine whether a given customer will be willing to pay
	 * for the given items in their cart based on their stated price sensitivity
	 * x.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * prices = [110, 95, 70] notes = ["10.0% higher than in-store",
	 * "5.0% lower than in-store", "Same as in-store"] x = 5 We have
	 * 
	 * isAdmissibleOverpayment(price, notes, x) = true
	 * 
	 * In-store prices of the first and the second items are 100, and the price
	 * of the third item is 70, which means the customer is overpaying 10 - 5 +
	 * 0 = 5, which they are willing to do based on their price sensitivity.
	 * 
	 * For
	 * 
	 * prices = [48, 165] notes = ["20.00% lower than in-store",
	 * "10.00% higher than in-store"] x = 2 isAdmissibleOverpayment(price,
	 * notes, x) = false
	 * 
	 * The in-store price of the first item is 60, and the second item is 150.
	 * The overpayment equals 15 - 12 = 3, which is too much for the customer to
	 * be willing to pay.
	 * 
	 * [input] array.float prices
	 * 
	 * Positive numbers, representing prices of the items in the shopping cart.
	 * [input] array.string notes
	 * 
	 * Array of the same length as prices. For each valid i notes[i] has one of
	 * the following forms: "x% higher than in-store", which means that
	 * Instacart price of the ith item is x% higher than the local one;
	 * "x% lower than in-store", which means that Instacart price of the ith
	 * item is x% lower than the local one; "Same as in-store", which means that
	 * the ith item costs the same in Instacart and in the local store, where x
	 * is a positive float number with the decimal point and at least one digit
	 * after it.
	 * 
	 * [input] float x
	 * 
	 * A non-negative integer, the maximum amount of money the customer is
	 * willing to overpay. [output] boolean
	 * 
	 * true if the overpayment is admissible, false otherwise. TIME'S UP! CODE
	 * 
	 * 1 boolean isAdmissibleOverpayment(double[] prices, String[] notes, double
	 * x) { 2 double v = 0.00d; 3 for (int i = 0; i < notes.length; i++) { 4
	 * String[] d = notes[i].split(" "); 5 d[0] = d[0].replace("%",""); 6 if
	 * (d[1].equals("higher")) { 7 v += prices[i] -
	 * (prices[i]*100)/(100+Double.parseDouble(d[0])); 8 } else if
	 * (d[1].equals("lower")) { 9 double m =
	 * prices[i]*100/(100-Double.parseDouble(d[0])); 10 v -= m; 11 } 12 } 13
	 * System.out.println(v+" "+x); 14 return v <= x; 15 } 16 ​ 56 seconds NEXT
	 * EDITOR
	 * 
	 * Code completion Auto-brackets Editor type Sublime THEME
	 * 
	 * Dark
	 * 
	 * @param prices
	 * @param notes
	 * @param x
	 * @return
	 */
	static boolean isAdmissibleOverpayment(double[] prices, String[] notes,
			double x) {
		double v = 0.00d;
		for (int i = 0; i < notes.length; i++) {
			String[] d = notes[i].split(" ");
			d[0] = d[0].replace("%", "");
			if (d[1].equals("higher")) {
				v += prices[i] - (prices[i] * 100)
						/ (100 + Double.parseDouble(d[0]));
			} else if (d[1].equals("lower")) {
				v -= prices[i] * Double.parseDouble(d[0]) / 100 - prices[i];
			}
		}
		return v <= x;
	}

	/**
	 * To make sure that groceries can always be delivered, Instacart tries to
	 * equally distribute delivery requests throughout the day by including an
	 * additional delivery fee during busy periods.
	 * 
	 * Each day is divided into several intervals that do not overlap and cover
	 * the whole day from 00:00 to 23:59. For each i the delivery fee in the
	 * intervals[i] equals fees[i].
	 * 
	 * Given the list of delivery requests deliveries, your task is to check
	 * whether the delivery fee is directly correlated to the order volume in
	 * each interval i.e. the interval_fee / interval_deliveries value is
	 * constant for each interval throughout the day.
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * intervals = [0, 10, 22], fees = [1, 3, 1], deliveries = [[8, 15], [12,
	 * 21], [15, 48], [20, 17], [23, 43]] the answer is deliveryFee(intervals,
	 * fees, deliveries) = true.
	 * 
	 * The day is divided into 3 intervals:
	 * 
	 * from 00:00 to 09:59, the first delivery was made, fees[0] / 1 = 1; from
	 * 10:00 to 21:59, the 2nd, 3rd and 4th deliveries were made, fees[1] / 3 =
	 * 1; from 22:00 to 23:59, the last delivery was made, fees[2] / 1 = 1.
	 * interval_fee / interval_deliveries = 1 for each interval, so the answer
	 * is true.
	 * 
	 * [input] array.integer intervals
	 * 
	 * Each interval starts at xx:00 and ends at yy:59, where xx equals
	 * intervals[i] and yy equals intervals[i + 1] - 1, or 23 if intervals[i +
	 * 1] doesn't exist. intervals[i] represents the hour at which the ith
	 * interval starts. It is guaranteed that intervals[0] = 0. 0 ≤ intervals[i]
	 * ≤ 23.
	 * 
	 * [input] array.integer fees
	 * 
	 * Array of positive integers of the same length as intervals. fees[i] is
	 * the delivery fee in the ith interval. [input] array.array.integer
	 * deliveries
	 * 
	 * Deliveries in the order they were made. Each delivery is represented as
	 * the [h, m] array, h is the hour and m is the minute it was done. [output]
	 * boolean
	 * 
	 * true if the delivery fee is directly correlated to the order volume in
	 * each interval, false otherwise.
	 * 
	 * @param intervals
	 * @param fees
	 * @param deliveries
	 * @return
	 */
	boolean deliveryFee(int[] intervals, int[] fees, int[][] deliveries) {
		double dc = 0.00d;
		int sm = 0;
		int eh = 23;
		int em = 59;

		for (int i = 0; i < fees.length; i++) {
			int sh = intervals[i];
			if (i + 1 < fees.length) {
				eh = intervals[i + 1];
			} else {
				eh = 23;
			}

			// in this interval number of deliveries
			int d = 0;
			for (int j = 0; j < deliveries.length; j++) {
				if (deliveries[j][0] >= sh && deliveries[j][0] <= eh) {
					d++;
				}
			}
			System.out.println(d + " " + dc);
			double r = 0.00d;
			if (d > 0) {
				r = fees[i] / d;
			}
			if (i == 0) {
				dc = r;
			} else if (dc != r) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 0 : 195
	 * 
	 * CodeFights IDE CODEWRITING CODEWRITING TASK
	 * 
	 * 
	 * Understand the requirements of the algorithm and implement the given
	 * function. When you run your code it only runs against some of the test
	 * cases but when you submit, we run it against all tests. So even if the
	 * run is successful, the submit might not be. To celebrate Cyber Monday,
	 * Instacart has decided to give its shoppers (employees that shop at
	 * grocery stores and deliver orders to customers) a break. For a 24h
	 * period, every shopper only has to make 1 delivery, after which his/her
	 * workday is over. However, since providing customers with a reliable
	 * shopping experience is Instacart's #1 priority, it is important to ensure
	 * that each order is fulfilled and delivered as promised.
	 * 
	 * You are given a list of orders with the time periods when they should be
	 * completed, and the time it takes to fulfill each order. Knowing the time
	 * period each shopper is available, find out whether the current number of
	 * shoppers is enough to fulfill all orders.
	 * 
	 * Example
	 * 
	 * For shoppers = [["15:10", "16:00"], ["17:40", "22:30"]], orders =
	 * [["17:30", "18:00"], ["15:00", "15:45"]], leadTime = [15, 30] the answer
	 * is busyHolidays(shoppers, orders, leadTime) = true.
	 * 
	 * The first shopper can take the second order, and the second shopper can
	 * take the first one.
	 * 
	 * For shoppers = [["15:10", "16:00"], ["17:50", "22:30"], ["13:00",
	 * "14:40"]]`, orders = [["14:30", "15:00"]], leadTime = [15] the answer is
	 * busyHolidays(shoppers, orders, leadTime) = false, since none of the
	 * shoppers can fulfill the given order.
	 * 
	 * [input] array.array.string shoppers
	 * 
	 * Available time for each shopper is given as an array of two strings
	 * [from, to], where each string represents time in "hh:mm" format. The
	 * shopper is available in the interval from from to to inclusive.
	 * shoppers.length ≤ 40
	 * 
	 * [input] array.array.string orders
	 * 
	 * For each order the period in which it should be fulfilled is given in the
	 * same format as the availability of each shopper. orders.length ≤ 40
	 * 
	 * [input] array.integer leadTime
	 * 
	 * Array of positive integers of the same length as orders. leadTime[i] is
	 * the number of minutes required to fulfill the ith order. [output] boolean
	 * 
	 * true if the shoppers can fulfill each order, false otherwise.
	 * 
	 * @param shoppers
	 * @param orders
	 * @param leadTime
	 * @return
	 */
	boolean busyHolidays(String[][] shoppers, String[][] orders, int[] leadTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		long[][] sl = new long[shoppers.length][2];
		boolean[] sa = new boolean[shoppers.length];
		for (int i = 0; i < shoppers.length; i++) {
			try {
				sl[i][0] = sdf.parse(shoppers[i][0]).getTime();
				sl[i][1] = sdf.parse(shoppers[i][1]).getTime();
			} catch (Throwable th) {

			}

		}

		long[][] o = new long[orders.length][2];
		for (int i = 0; i < orders.length; i++) {
			try {
				o[i][0] = sdf.parse(orders[i][0]).getTime();
				o[i][1] = sdf.parse(orders[i][1]).getTime();
			} catch (Throwable th) {

			}

		}
		return true;
	}
}
