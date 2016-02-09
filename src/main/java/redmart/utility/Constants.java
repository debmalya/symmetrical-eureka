/**
 * 
 */
package redmart.utility;

/**
 * @author debmalyajash
 *
 */
public class Constants {
	/**
	 * To go towards north.
	 */
	public int[] NORTH = new int[] { 0, -1 };

	/**
	 * To go towards south.
	 */
	public int[] SOUTH = new int[] { 0, 1 };

	/**
	 * To go towards east.
	 */
	public int[] EAST = new int[] { -1, -0 };

	/**
	 * To go towards west.
	 */
	public int[] WEST = new int[] { 1, 0 };
	
	/**
	 * To change x value to move in all four directions.
	 */
	public int[] dx = new int[] { NORTH[0], EAST[0], SOUTH[0], WEST[0] };

	/**
	 * To change y value to move in all four directions.
	 */
	public int[] dy = new int[] { NORTH[1], EAST[1], SOUTH[1], WEST[1] };
	
	/**
	 * Where test files are located.
	 */
	public static final String DIR = System.getProperty("user.dir")
			+ "/src/test/resources/";

}
