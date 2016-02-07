/**
 * 
 */
package redmart.approach2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import redmart.Map;

/**
 * @author debmalyajash
 *
 */
public class MapImpl implements Map {

	/**
	 * To log error and debug message.
	 */
	private static final Logger LOGGER = Logger.getLogger(MapImpl.class);

	/**
	 * To go towards north.
	 */
	private int[] NORTH = new int[] { 0, -1 };

	/**
	 * To go towards south.
	 */
	private int[] SOUTH = new int[] { 0, 1 };

	/**
	 * To go towards east.
	 */
	private int[] EAST = new int[] { -1, -0 };

	/**
	 * To go towards west.
	 */
	private int[] WEST = new int[] { 1, 0 };

	private int height = 0;

	private int width = 0;

	private int[] dx = new int[] { NORTH[0], EAST[0], SOUTH[0], WEST[0] };

	private int[] dy = new int[] { NORTH[1], EAST[1], SOUTH[1], WEST[1] };

	/**
	 * Possible path list.
	 */
	private List<RedMartPath> pathList = new ArrayList<RedMartPath>();

	boolean[][] visited;

	/*
	 * (non-Javadoc)
	 * 
	 * @see redmart.Map#getEmailAddress(int[][])
	 */
	public String getEmailAddress(int[][] map) {
		width = map.length;
		height = map[0].length;

		visited = new boolean[width][height];

		getSkiPath(map, 0, 0, null);

		Collections.sort(pathList);

		if (LOGGER.isDebugEnabled()) {
			for (int i = 0; i < pathList.size(); i++) {
				LOGGER.debug((i+1)+") :" + pathList.get(i));
			}
		}

		if (!pathList.isEmpty()) {
			RedMartPath maxPath = pathList.get(pathList.size() - 1);
			return maxPath.getPath().length() + ""
					+ (maxPath.getSource() - maxPath.getDestination());
		} else {
			return "";
		}
	}

	/**
	 * @param map
	 *            elevation map.
	 * @param x
	 *            coordinate.
	 * @param y
	 *            coordinate.
	 * @param dx
	 *            neighbor coordinate.
	 * @param dy
	 *            neighbor coordinate.
	 * @return
	 */
	private void getSkiPath(int[][] map, int x, int y, RedMartPath path) {

		if (visited[x][y]) {
			return;
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("x :" + x + " y :" + y);
		}

		for (int i = 0; i < dx.length; i++) {
			int modX = x + dx[i];
			int modY = y + dy[i];
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("modX :" + modX + " modY :" + modY);
			}
			boolean validCoordinate = modX > -1 && modX < width && modY > -1
					&& modY < height;
			if (validCoordinate) {
				visited[x][y] = true;
				if (map[modX][modY] < map[x][y]) {
					// there is down hill
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Can ski from " + map[x][y] + " to "
								+ map[modX][modY] + " path :" + path);

					}
					if (path == null) {
						path = new RedMartPath();
						path.setSource(map[x][y]);
					}
					path.setDestination(map[modX][modY]);
					getSkiPath(map, modX, modY, path);
				} else {
					// no down hill.
					if (path != null) {
						// can not continue existing path.
						// end of path, adding into the list.
						if (!pathList.contains(path)) {
							pathList.add(path);
							if (LOGGER.isDebugEnabled()) {
								LOGGER.debug("Added in path list :" + path);
							}
						}
						getSkiPath(map, modX, modY, null);
						// return;
					}
					// getSkiPath(map, x + dx[i], y + dy[i], null);
				}

			}
		}

	}

}
