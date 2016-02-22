/**
 * 
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class StringNMusk {



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
	public static String processEachLine(String eachLine) {
		

		String[] values = eachLine.split(" ");
		char[] converted = values[0].toCharArray();

		for (int i = 0; i < values[0].length(); i++) {
			if (values[1].charAt(i) == '1'){
				converted[i] = (char) ('A'+converted[i]);
			}
		}

		return String.valueOf(converted);
	}


}
