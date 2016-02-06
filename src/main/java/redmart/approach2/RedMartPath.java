/**
 * 
 */
package redmart.approach2;

/**
 * @author debmalyajash
 *
 */
public class RedMartPath implements Comparable<RedMartPath> {
	private StringBuilder path;

	private int source;

	private int destination;

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
	 * @param path
	 *            the path to set
	 */
	public void setPath(StringBuilder path) {
		this.path = path;
	}

	public int compareTo(RedMartPath o) {
		if (path.length() == o.getPath().length()) {
			if (getSource() - getDestination() > o.getSource()
					- o.getDestination()) {
				return 1;
			} else if (getSource() - getDestination() < o.getSource()
					- o.getDestination()) {
				return -1;
			}
			return 0;
		} else if (path.length() > o.getPath().length()) {
			return 1;
		}
		return -1;
	}

}
