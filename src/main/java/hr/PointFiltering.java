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
package hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class PointFiltering {
	
	/**
	 * @param args
	 */
	public static void main0(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int b = in.nextInt();

			List<Point> mainList = new ArrayList<>(n);

			for (int i = 0; i < n; i++) {
				int k = in.nextInt();
				double x = in.nextDouble();
				double y = in.nextDouble();
				double z = in.nextDouble();

				mainList.add(new Point(k, x, y, z));
			}

			Collections.sort(mainList);

			Bucket bucket = new Bucket(b);
			for (int i = mainList.size() - 1, j = 0; j < b; i--, j++) {
				bucket.points[j] = mainList.get(i);
				bucket.idMap.put(mainList.get(i).ID, j);
			}

			// Process Queries
			in.nextLine();
			String eachQuery = in.nextLine();
			while (in.hasNextLine()) {
				String[] queryDetails = eachQuery.split(" ");
				int fID = Integer.parseInt(queryDetails[1]);
				Integer index = bucket.idMap.get(fID);
				if (index == null) {
					System.out.println("Point doesn't exist in the bucket.");
				}
				if (queryDetails[0].equals("F")) {
					// Find

					if (index != null) {
						System.out.println(bucket.points[index]);
					}
				} else if (queryDetails[0].equals("R")) {
					// Remove
					if (index != null) {

						if (mainList.size() > b) {
							System.out.println("Point id " + bucket.points[index].ID + " removed.");
							boolean isRemoved = mainList.remove(bucket.points[index]);
							if (isRemoved) {

								Collections.sort(mainList);
								//

								for (int i = mainList.size() - 1, j = 0; j < b; i--, j++) {
									bucket.points[j] = mainList.get(i);
									bucket.idMap.put(mainList.get(i).ID, j);
								}
							}

						} else {
							System.out.println("No more points can be deleted.");
						}
					}
				}
				eachQuery = in.nextLine();
				if (eachQuery.trim().length() == 0) {
					break;
				}
			}
		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String[] values = in.nextLine().split(" ");
			int n = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);

			List<Point> mainList = new ArrayList<>(n);

			for (int i = 0; i < n; i++) {
				values = in.nextLine().split(" ");
				int k = Integer.parseInt(values[0]);
				double x = Double.parseDouble(values[1]);
				double y = Double.parseDouble(values[2]);
				double z = Double.parseDouble(values[3]);

				mainList.add(new Point(k, x, y, z));
			}

			Collections.sort(mainList);

			Bucket bucket = new Bucket(b);
			for (int i = mainList.size() - 1, j = 0; j < b; i--, j++) {
				bucket.points[j] = mainList.get(i);
				bucket.idMap.put(mainList.get(i).ID, j);
			}

			// Process Queries
			String eachQuery = in.nextLine();
			while (in.hasNextLine()) {
				String[] queryDetails = eachQuery.split(" ");
				int fID = Integer.parseInt(queryDetails[1]);
				Integer index = bucket.idMap.get(fID);
				if (index == null) {
					System.out.println("Point doesn't exist in the bucket.");
				}
				if (queryDetails[0].equals("F")) {
					// Find

					if (index != null) {
						System.out.println(bucket.points[index]);
					}
				} else if (queryDetails[0].equals("R")) {
					// Remove
					if (index != null) {

						if (mainList.size() > b) {
							System.out.println("Point id " + bucket.points[index].ID + " removed.");
							boolean isRemoved = mainList.remove(bucket.points[index]);
							if (isRemoved) {

								Collections.sort(mainList);
								for (int i = mainList.size() - 1, j = 0; j < b; i--, j++) {
									bucket.points[j] = mainList.get(i);
									bucket.idMap.put(mainList.get(i).ID, j);
								}

							}

						} else {
							System.out.println("No more points can be deleted.");
						}
					}
				}
				eachQuery = in.nextLine();
				if (eachQuery.trim().length() == 0) {
					break;
				}
			}
		}

	}

	public static class Bucket {
		int size;
		Point[] points;
		Map<Integer, Integer> idMap = new HashMap<>();

		public Bucket(int size) {
			this.size = size;
			points = new Point[size];
		}
	}

	public static class Point implements Comparable<Point> {
		int ID;
		double x;
		double y;
		double z;

		public Point(int ID, double x, double y, double z) {
			this.ID = ID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Point o) {
			if (z < o.z) {
				return -1;
			} else if (z > o.z) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			String aboutMe = String.format("%d = (%.3f,%.3f,%.3f)", ID, x, y, z);
			return aboutMe;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ID;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (ID != other.ID)
				return false;
			return true;
		}

	}
}
