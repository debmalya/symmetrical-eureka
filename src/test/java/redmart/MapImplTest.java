/**
 * 
 */
package redmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import redmart.approach2.MapImpl;

/**
 * @author debmalyajash
 *
 */
public class MapImplTest {
	/**
	 * To log error and debug messages.
	 */
	private static final Logger LOGGER = Logger.getLogger(MapImplTest.class);

	/**
	 * Location of test files.
	 */
	public static final String DIR = System.getProperty("user.dir")
			+ "/src/test/resources/";

	/**
	 * Real input file
	 */
	public static final String REAL_FILE = "redmart_input.txt";

	/**
	 * Sample input file
	 */
	public static final String SAMPLE_INPUT_FILE = "RedMart_SampleInput.txt";

	/**
	 * Test method for {@link redmart.approach2.MapImpl#getEmailAddress(int[][])}.
	 */
//	@Test
	public final void testGetEmailAddress() {
		int[][] map = readFromFile(SAMPLE_INPUT_FILE);
		MapImpl mapImpl = new MapImpl();
		String emailAddress = mapImpl.getEmailAddress(map);
		Assert.assertEquals("58", emailAddress);
	}
	
	@Test
	public final void testGetEmailAddressReal() {
		int[][] map = readFromFile(REAL_FILE);
		MapImpl mapImpl = new MapImpl();
		String emailAddress = mapImpl.getEmailAddress(map);
		System.out.println("emailAddress 1:" +emailAddress);
//		Assert.assertEquals("58", emailAddress);
	}

	/**
	 * Read from file. Create two dimensional array of integer.
	 * 
	 * @param sampleFile
	 *            file name with location.
	 */
	private int[][] readFromFile(String sampleFile) {
		int[][] map = null;
		BufferedReader inputFile = null;
		try {
			Path path = FileSystems.getDefault()
					.getPath(DIR, sampleFile);
			inputFile = Files.newBufferedReader(path);
			boolean isFirstLine = true;
			String eachLine = "";
			int x = 0;
			while ((eachLine = inputFile.readLine()) != null) {
				if (isFirstLine) {
					String[] dimension = eachLine.split(" ");
					map = new int[Integer.parseInt(dimension[0])][Integer
							.parseInt(dimension[1])];
					isFirstLine = false;
				} else {
					String[] elevations = eachLine.split(" ");
					for (int y = 0; y < elevations.length; y++) {
						map[x][y] = Integer.parseInt(elevations[y]);
					}
					x++;
				}
			}
		} catch (Throwable th) {
			LOGGER.error(
					"Looking at :" + System.getProperty("user.dir")
							+ th.getMessage(), th);
		} finally {
			if (inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}

		return map;

	}

}
