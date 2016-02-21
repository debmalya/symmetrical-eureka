/**
 * 
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author debmalyajash
 *
 */
public class BeatOrBit {

	/**
	 * Key is gray code. Value is decimal number.
	 */
	private static Map<String, String> grayCodeMap = new HashMap<>();

	private static String[] startWith = new String[] { "0", "1" };

	/**
	 * @param args
	 *            The first argument is a path to a file. Each line includes a
	 *            test case with binary numbers encrypted with the Grays code
	 *            algorithm. Numbers are separated by pipelines '|'.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			List<String> resultList = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
				String eachLine = "";

				while ((eachLine = br.readLine()) != null) {
					if (eachLine.trim().length() > 0) {
						resultList.add(processEachLine(eachLine));
					}
				}

			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} finally {
				for (String eachLine : resultList) {
					System.out.println(eachLine);
				}
			}
		} else {
			System.err.println("Plese specify file name");
		}

	}

	/**
	 * @param eachLine
	 * @return
	 */
	private static String processEachLine(String eachLine) {
		StringBuilder sb = new StringBuilder();

		String[] values = eachLine.split("|");

		for (String each : values) {
			
			each = each.trim();
			if (each.length() > 0) {
				if (sb.length() > 0) {
					sb.append(" | ");
				}
				sb.append(grayToDecimal(Integer.parseInt(each)));
			}

		}

		return sb.toString().trim();
	}

	/**
	 * decode the encrypted numbers and print them in a decimal system,
	 * 
	 * @param num
	 *            - numbers encrypted with Gray code.
	 * @return
	 */
	public static int grayToDecimal(final int num) {

		startWith = new String[] { "0", "1" };
		String converted = String.valueOf(num);
		List<String> values = getValues(converted.length());

		return values.indexOf(Integer.toString(num));
	}

	/**
	 * @param length
	 * @return
	 */
	public static List<String> getValues(int length) {
		List<String> grayCodeList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < length) {
			// add 0 with each elements of startWith
			for (int j = 0; j < startWith.length; j++) {
				sb.delete(0, sb.length());
				sb.append("0");
				sb.append(startWith[j]);
				grayCodeList.add(sb.toString());
			}
			// add 1 with each elements of startWith
			for (int j = startWith.length - 1; j > -1; j--) {
				sb.delete(0, sb.length());
				sb.append("1");
				sb.append(startWith[j]);
				i = sb.toString().length();
				grayCodeList.add(sb.toString());
			}

			startWith = grayCodeList.toArray(new String[0]);
			if (i < length) {
				grayCodeList.clear();
			}
		}
		return grayCodeList;
	}

}
