/**
 * 
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author debmalyajash
 *
 */
public class BeatOrBit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
				String eachLine = "";

				while ((eachLine = br.readLine()) != null) {

				}

			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} finally {

			}
		} else {
			System.out.println(Integer.toString(1111, 10));
		}

	}

	public static String processEachLine(String eachLine) {
		return null;
	}
}
