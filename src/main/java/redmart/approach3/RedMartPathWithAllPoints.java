/**
 * 
 */
package redmart.approach3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class RedMartPathWithAllPoints implements
		Comparable<RedMartPathWithAllPoints> {
	private StringBuilder path = new StringBuilder();
	private List<Integer> elevationPoints = new ArrayList<Integer>();
	int source;
	int destination;

	/**
	 * @return the source
	 */
	public int getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(int source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	/**
	 * @return the path
	 */
	public StringBuilder getPath() {
		return path;
	}

	/**
	 * @return the elevationPoints
	 */
	public List<Integer> getElevationPoints() {
		return elevationPoints;
	}

	public int compareTo(RedMartPathWithAllPoints o) {
		if (path.length() > o.getPath().length()) {
			return 1;
		} else if (path.length() < o.getPath().length()) {
			return -1;
		} else {

			return (source - destination)
					- (o.getSource() - o.getDestination());
		}
	}
}
