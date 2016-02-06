/**
 * 
 */
package redmart.approach1;

/**
 * @author debmalyajash
 *
 */
public class RedMartDot {
	/**
	 * Elevation of that area in mountain.
	 */
	private int elevation;
	
	/**
	 * If you can go to  north from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartDot north;
	
	/**
	 * If you can go to  south from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartDot south;
	
	/**
	 * If you can go to  east from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartDot east;
	
	/**
	 * If you can go to the west from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartDot west;

	/**
	 * @return the elevation
	 */
	public int getElevation() {
		return elevation;
	}

	/**
	 * @param elevation the elevation to set
	 */
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	/**
	 * @return the north
	 */
	public RedMartDot getNorth() {
		return north;
	}

	/**
	 * @param north the north to set
	 */
	public void setNorth(RedMartDot north) {
		this.north = north;
	}

	/**
	 * @return the south
	 */
	public RedMartDot getSouth() {
		return south;
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(RedMartDot south) {
		this.south = south;
	}

	/**
	 * @return the east
	 */
	public RedMartDot getEast() {
		return east;
	}

	/**
	 * @param east the east to set
	 */
	public void setEast(RedMartDot east) {
		this.east = east;
	}

	/**
	 * @return the west
	 */
	public RedMartDot getWest() {
		return west;
	}

	/**
	 * @param west the west to set
	 */
	public void setWest(RedMartDot west) {
		this.west = west;
	}
	
}
