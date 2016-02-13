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
public class ColumnNames {

	/**
	 * Letters
	 */
	private static final char[] LETTERS = new char[] { 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// first argument is a path to file.
		List<String> resultList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String eachLine = "";
			
			while ((eachLine = br.readLine()) != null){
				resultList.add(getColumnName(eachLine));
			}
				
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}finally{
			for (String each:resultList) {
				System.out.println(each);
			}
		}
	}

	/**
	 * Get column name for the passed value.
	 * 
	 * @param columnNumber
	 * @return columnName.
	 */
	public static String getColumnName(String columnNumber) {
		int n = Integer.parseInt(columnNumber) - 1;

		StringBuilder columnValue = new StringBuilder();
		while (n >= 0) {

			columnValue.append(LETTERS[n % 26]);
			n /= 26;
			if (n == 0) {
				break;
			}
			n--;
		}

		return columnValue.reverse().toString();
	}

}
