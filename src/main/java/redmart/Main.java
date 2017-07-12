/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package redmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



/**
 * @author debmalyajash
 *
 */
public class Main {

	// four possible directions.
	private static final int[] NORTH = new int[] { -1, 0 };
	private static final int[] SOUTH = new int[] { 1, 0 };
	private static final int[] EAST = new int[] { 0, 1 };
	private static final int[] WEST = new int[] { 0, 1 };

	// check elevation with changing x and y vaue in this way
	// (NORTH->EAST->SOUTH->WEST)
	private static final int[] dx = new int[] { NORTH[0], EAST[0], SOUTH[0], WEST[0] };
	private static final int[] dy = new int[] { NORTH[1], EAST[1], SOUTH[1], WEST[1] };

	static boolean[][] visited;
	
	/**
	 * Possible path list.
	 */
	private static List<RedMartPath> pathList = new ArrayList<RedMartPath>();

	static class RedMartPath implements Comparable<RedMartPath> {
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
				return (getSource() - getDestination()) - (o.getSource() - o.getDestination());
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
			return "RedMartPath [path=" + path + ", source=" + source + ", destination=" + destination + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int x = in.nextInt();
			int y = in.nextInt();
			int[][] map = new int[x][y];

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					map[i][j] = in.nextInt();
				}
			}

			int[] answer = getLongestPathAndDepth(map);
			System.out.println(answer[0]);
			System.out.println(answer[1]);
		}
	}

	/**
	 * 
	 * @param map
	 *            - each number represents the elevation of that area of the
	 *            mountain. From each area we can go north,south,east,west. But
	 *            only the elevation area you are going into is less than the
	 *            one you are in (i.e. you can ski down hill).You can start
	 *            anywhere in the map and you are looking for a starting point
	 *            with the longest possible path down as measured by the number
	 *            of boxes (area) you visited. And if there are several paths
	 *            down the same length, you want to take the one with the
	 *            steepest vertical drop, i.e. the largest distance between your
	 *            starting elevation and ending elevation.
	 * @return an integer array consisting two elements 1. length of the longest
	 *         path with the largest drop. 2. the size of the drop.
	 */
	public static int[] getLongestPathAndDepth(int[][] map) {
		int[] answers = new int[2];
		
		int width = map.length;
		int height = map[0].length;
		visited = new boolean[width][height];
		
		getSkiPath(map, 0, 0, null);
		Collections.sort(pathList);
		
		RedMartPath maxPath = pathList.get(pathList.size() - 1);
		answers[0] = maxPath.getPath().length();
		answers[1] = maxPath.getSource() - maxPath.getDestination();
		return answers;
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
	private static void getSkiPath(int[][] map, int x, int y, RedMartPath path) {
       
		if (visited[x][y]) {
			return;
		}

		int width = map.length;
		int height = map[0].length;
		
		for (int i = 0; i < dx.length; i++) {
			int modX = x + dx[i];
			int modY = y + dy[i];

			boolean validCoordinate = modX > -1 && modX < width && modY > -1 && modY < height;
			if (validCoordinate) {
				visited[x][y] = true;
				if (map[modX][modY] < map[x][y]) {
					// there is down hill
					
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
