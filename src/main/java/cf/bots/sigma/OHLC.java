package cf.bots.sigma;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * When visualizing market data over a long period of time, it is often helpful
 * to build an Open-high-low-close (OHLC) chart. However, to build an OHLC chart
 * you first need to prepare some data. For each financial instrument consider
 * each day when it was traded, and find the following prices the instrument had
 * that day:
 * 
 * open price: the price of the first trade of the day; high price: the highest
 * trade of the day; low price: the lowest trade of the day; close price: the
 * price of the last trade of the day. Given a stream of trade data ordered by
 * time, write a program to compute the OHLC by day and instrument (see output
 * section for the format details). If two trades happen to have equal
 * timestamps, then their order is determined by the order of their timestamps
 * in the timestamp array.
 * 
 * @author debmalyajash
 *
 */
public class OHLC {

	public static void main(String[] args) {
		OHLC ohlc = new OHLC();
		ohlc.dailyOHLC(new int[] { 1450625399, 1450625400, 1450625500, 1450625550, 1451644200, 1451690100, 1451691000 },
				new String[] { "HPQ", "HPQ", "HPQ", "HPQ", "AAPL", "HPQ", "GOOG" },
				new String[] { "sell", "buy", "buy", "sell", "buy", "buy", "buy" },
				new double[] { 10, 20.3, 35.5, 8.65, 20, 10, 100.35 }, new int[] { 10, 1, 2, 3, 5, 1, 10 });
	}

	/**
	 * 
	 * @param timestamp
	 * @param instrument
	 * @param side
	 * @param price
	 * @param size
	 * @return
	 * 
	 * 		The ith row of the output should contain the following elements:
	 * 
	 *         output[i][0] - local sever date in the YYYY-MM-DD format;
	 *         output[i][1] - a ticker symbol for some instrument; output[i][2]
	 *         - a string corresponding to the open price; output[i][3] - a
	 *         string corresponding to the high price; output[i][4] - a string
	 *         corresponding to the low price; output[i][5] - a string
	 *         corresponding to the close price. Each string corresponding to
	 *         the price should contain exactly two digits after the decimal
	 *         point and at least one digit before.
	 * 
	 *         For each unique pair of a date and an instrument present in the
	 *         inputs, such that there was a trade of that instrument on that
	 *         day, there should be exactly one row in the output.
	 * 
	 *         Output rows should be ordered by dates. Rows corresponding to the
	 *         same date should be ordered in lexicographical order for ticker
	 *         symbols.
	 */
	String[][] dailyOHLC(int[] timestamp, String[] instrument, String[] side, double[] price, int[] size) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat df = new DecimalFormat("####0.00");
		
		List<EachInput> inputList = new ArrayList<>();

		// Key date+instrument, Sorted set of each input
		SortedMap<String, List<EachInput>> inputMap = new TreeMap<>();

		for (int i = 0; i < side.length; i++) {
			Date date = new Date(timestamp[i] * 1000L);
			EachInput each = new EachInput(timestamp[i], sdf.format(date.getTime()), instrument[i], side[i], price[i],
					size[i]);
			inputList.add(each);
			String key = each.displayDate + each.instrument;
			List<EachInput> entries = inputMap.get(key);
			if (entries == null) {
				entries = new ArrayList<>();
			}
			entries.add(each);
			inputMap.put(key, entries);
		}

		
		Collection<List<EachInput>> values = inputMap.values();
		String[][] output = new String[values.size()][6];
		

		Iterator<List<EachInput>> vi = values.iterator();
		int count = 0;
		while (vi.hasNext()) {
			List<EachInput> next = vi.next();
			Collections.sort(next);
			output[count][0] = next.get(0).displayDate;
			output[count][1] = next.get(0).instrument;
			output[count][2] = df.format(next.get(0).price);
			output[count][5] = df.format(next.get(next.size() -1).price);
			
			double lowestPrice = Double.MAX_VALUE;
			double highestPrice = Double.MIN_VALUE;
			
			for (int i = 0; i < next.size(); i++) {
				if (next.get(i).price > highestPrice){
					highestPrice = next.get(i).price;
				}
				
				if (next.get(i).price < lowestPrice){
					lowestPrice = next.get(i).price;
				}
			}
			
			output[count][3] = df.format(highestPrice);
			output[count][4] = df.format(lowestPrice);
			count++;
		}

		return output;
	}

	static class EachInput implements  Comparator<EachInput>,Comparable<EachInput> {
		long timestamp;
		String displayDate;
		String instrument;
		String side;
		double price;
		int size;

		public EachInput(long timestamp, String displayDate, String instrument, String side, double price, int size) {
			this.timestamp = timestamp;

			this.displayDate = displayDate;
			this.instrument = instrument;
			this.side = side;
			this.price = price;
			this.size = size;
		}

		@Override
		public int compareTo(EachInput o) {
			if (timestamp < o.timestamp) {
				return 1;
			} else if (timestamp < o.timestamp) {
				return -1;
			}
			return instrument.compareTo(o.instrument);
		}

		@Override
		public String toString() {
			return "EachInput [timestamp=" + timestamp + ", displayDate=" + displayDate + ", instrument=" + instrument
					+ ", side=" + side + ", price=" + price + ", size=" + size + "]";
		}

		@Override
		public int compare(EachInput o1, EachInput o2) {
			if (o1.price > o2.price){
				return 1;
			} else if (o1.price < o2.price){
				return -1;
			}
			return 0;
		}

	}
}
