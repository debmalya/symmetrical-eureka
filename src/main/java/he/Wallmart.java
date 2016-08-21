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
package he;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author debmalyajash
 *
 */
public class Wallmart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains the number of junctions 'n'
			int n = in.nextInt();
			// The second line contains the number of queues 'e'(<200).
			int q = in.nextInt();

			Queue[] b = new Queue[q];
			SortedMap<Integer, Queue> startM = new TreeMap<>();
			Map<Integer, Queue> endM = new HashMap<>();
			Map<Integer, Junction> jMap = new HashMap<>();
			int minP = Integer.MAX_VALUE;

			for (int a = 0; a < q; a++) {
				// The next 'e' lines contains three values: the start junction,
				// the end junction and the number of people on this queue(This
				// is also the max. number of people that can stand in this
				// queue)
				int s = in.nextInt();
				int e = in.nextInt();
				int p = in.nextInt();
				b[a] = new Queue(s, e, p);
				endM.put(e, b[a]);

				Junction j = jMap.get(e);
				if (j == null) {
					j = new Junction();
					j.sources[0] = b[a];
				} else {
					j.sources[1] = b[a];
				}
				jMap.put(e, j);

				// each end point is a junction.

				startM.put(s, b[a]);
				j = jMap.get(s);
				if (j != null) {
					j.capacity = b[a].p;
				}
				if (b[a].p < minP) {
					minP = b[a].p;
				}

			}

			Arrays.sort(b);

			StringBuilder path = new StringBuilder();
			List<String> allPaths = new ArrayList<>();

			List<Integer> shortestTime = new ArrayList<>();

			for (int i = 0; i < q; i++) {
				if (b[i].p > minP) {
					break;
				}

				int each = b[i].s;
				Stack<Integer> shortestPath = new Stack<Integer>();
				shortestPath.push(each);
				path.append(each);
				Integer start = each;
				Queue end = startM.get(start);
				while (end != null) {
					path.append(" -> ");
					start = end.e;
					shortestPath.push(start);
					path.append(start);
					end = startM.get(start);
				}
				// Calculate time taken.

				// Minimum path for
				int time = minP * 2;

				while (!shortestPath.isEmpty()) {
					Integer junction = shortestPath.pop();
					Junction j = jMap.get(junction);
					if (j != null && j.sources[0].s != b[i].s
							&& j.sources[1].s != b[i].s) {
						time += j.sources[0].p;
						time += j.sources[1].p;
						if (!shortestPath.contains(j.sources[0].s)) {
							// In other branch
							// Check whether connecting two leaves
							Junction jBranch = jMap.get(j.sources[0].s);
							if (jBranch != null) {
								time += getTime(jMap, j.sources[0].s, minP);
							}
						}
						if (!shortestPath.contains(j.sources[1].s)) {
							// In other branch
							Junction jBranch = jMap.get(j.sources[1].s);
							if (jBranch != null) {
								time += getTime(jMap, j.sources[1].s, minP);
							}
						}
					}
				}
				allPaths.add(path.toString());
				path.delete(0, path.length());
				shortestTime.add(time);

			}

			Collections.sort(shortestTime);
			System.out.println(shortestTime.get(0));
			for (String each : allPaths)
				System.out.println(each);
		}

	}

	/**
	 * @param jMap
	 * @param s
	 * @param minP
	 * @return
	 */
	private static int getTime(Map<Integer, Junction> jMap, int s, int minP) {
		Junction j = jMap.get(s);
		if (j == null) {
			return minP;
		} else {
			if (j.sources[0] != null && j.sources[1] != null) {
				return  getTime(jMap, j.sources[0].s, minP)
						+ getTime(jMap, j.sources[1].s, minP);
			} else if (j.sources[0] != null) {
				return  getTime(jMap, j.sources[0].s, minP);
			} else if (j.sources[1] != null) {
				return getTime(jMap, j.sources[1].s, minP);
			} else {
				return minP;
			}

		}

	}

	static class Junction {
		Queue[] sources = new Queue[2];
		Queue destination;
		int capacity;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Junction [sources=" + Arrays.toString(sources)
					+ ", destination=" + destination + ", capacity=" + capacity
					+ "]";
		}

	}

	static class Queue implements Comparable<Queue> {
		/**
		 * @param s2
		 * @param e2
		 * @param p2
		 */
		public Queue(int s2, int e2, int p2) {
			// TODO Auto-generated constructor stub
			s = s2;
			e = e2;
			p = p2;
		}

		int s;
		int e;
		int p;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Queue o) {
			if (p > o.p) {
				return 1;
			} else if (p < o.p) {
				return -1;
			}
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "State [s=" + s + ", e=" + e + ", p=" + p + "]";
		}

	}

}
