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

	private int destination = Integer.MAX_VALUE;

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
		path = new StringBuilder();
		addPath(source);
	}

	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}

	/**
	 * @param newDestination
	 *            the destination to set
	 */
	public void setDestination(int newDestination) {
		if (newDestination < destination) {
			this.destination = newDestination;
			addPath(newDestination);
		}
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
	 * Append to existing path.
	 * 
	 * @param value
	 *            elevation of current shell.
	 */
	private void addPath(int value) {
		path.append(value);
	}

	public int compareTo(RedMartPath o) {
		if (path.length() == o.getPath().length()) {
			return (getSource() - getDestination())
					- (o.getSource() - o.getDestination());
		} else {
			return path.length() - o.getPath().length();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RedMartPath [path=" + path + ", source=" + source
				+ ", destination=" + destination + "]";
	}

}
