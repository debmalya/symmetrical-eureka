/**
 * 
 */
package redmart.approach1;

/**
 * @author debmalyajash
 *
 */
public class RedMartBranch {
	/**
	 * Elevation of that area in mountain.
	 */
	private int elevation;
	
	/**
	 * If you can go to  north from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartBranch north;
	
	/**
	 * If you can go to  south from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartBranch south;
	
	/**
	 * If you can go to  east from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartBranch east;
	
	/**
	 * If you can go to the west from the current point.
	 * Otherwise it will be null.
	 */
	private RedMartBranch west;

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
	public RedMartBranch getNorth() {
		return north;
	}

	/**
	 * @param north the north to set
	 */
	public void setNorth(RedMartBranch north) {
		this.north = north;
	}

	/**
	 * @return the south
	 */
	public RedMartBranch getSouth() {
		return south;
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(RedMartBranch south) {
		this.south = south;
	}

	/**
	 * @return the east
	 */
	public RedMartBranch getEast() {
		return east;
	}

	/**
	 * @param east the east to set
	 */
	public void setEast(RedMartBranch east) {
		this.east = east;
	}

	/**
	 * @return the west
	 */
	public RedMartBranch getWest() {
		return west;
	}

	/**
	 * @param west the west to set
	 */
	public void setWest(RedMartBranch west) {
		this.west = west;
	}
	
}
