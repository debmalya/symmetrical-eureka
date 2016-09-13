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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class HoneyWell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line contains 3 space separated integers denoting the
			// number of days (n), the number of users ( and the number of
			// objects on
			// sale
			int N = in.nextInt();
			int X = in.nextInt();
			int K = in.nextInt();

			// Key is object id, value integer array first element is rating,
			// second
			// element is how many times rated.
			Map<Integer, int[]> objectRatingMap = new HashMap<>();
			double maxRating = Double.MIN_VALUE;
			int maxCount = Integer.MIN_VALUE;
			int objectHighestRated = 0;
			int objectMaxTimesRated = 0;

			// Key is object id,value is a map with day / total count pair.
			Map<Integer, Map<Integer, Integer>> objectMaxDayCount = new LinkedHashMap<>();
			// Key is object, value is a map with object id key, integer array
			// value, first element is the day when the object has max count,
			// second element is the count
			Map<Integer, int[]> objectDayCount = new LinkedHashMap<>();

			// Then follow N data-sets, one for each of the days, The
			// description of each data-set is as follows:
			// The first line contains a single integer M denoting the number of
			// pieces of info, Each of the next M 3 integers,
			// x,y,a, indicating that user with ID x rates object with ID y with
			// a rating of a.
			for (int i = 0; i < N; i++) {
				int M = in.nextInt();
				for (int j = 0; j < M; j++) {
					int x = in.nextInt();
					int y = in.nextInt();
					int a = in.nextInt();

					int[] rating = objectRatingMap.get(y);
					if (rating == null) {
						rating = new int[2];
					}
					// sum of rating.
					rating[0] += a;
					// number of times rated.
					rating[1]++;
					double currentRating = (double) rating[0] / rating[1];
					if (currentRating >= maxRating) {
						maxRating = currentRating;
						objectHighestRated = y;
					}

					if (rating[1] > maxCount) {
						maxCount = rating[1];
						objectMaxTimesRated = y;
					}
					objectRatingMap.put(y, rating);

					Map<Integer, Integer> dayCount = objectMaxDayCount.get(y);
					int[] dayWise = objectDayCount.get(y);
					if (dayWise == null) {
						dayWise = new int[2];
					}
					Integer count = 0;
					if (dayCount == null) {
						dayCount = new HashMap<>();
						count = 1;
						dayWise[0] = i + 1;
						dayWise[1] = 1;
					} else {
						count = dayCount.get(i);
						if (count == null) {
							count = 0;
						}
						count++;
						if (count > dayWise[1]) {
							dayWise[1] = count;
							dayWise[0] = i + 1;
						}
					}
					dayCount.put(i, count);
					objectMaxDayCount.put(y, dayCount);
					objectDayCount.put(y, dayWise);

				}
			}
			// Output Format: On the first line, print 2 space separated
			// integers, denoting the object index with highest average rating,
			// and the object index rated most number of times. On the next
			// line, print K space separated integers, where the i th integer
			// denotes the day index when the ith object was rated most number
			// of times.
			System.out.println(objectHighestRated + " " + objectMaxTimesRated);

			StringBuilder sb = new StringBuilder();
			objectDayCount.entrySet().forEach(e -> {
				sb.append(e.getValue()[0]);
				sb.append(" ");
			});
			System.out.println(sb.toString().trim());
		}

	}

}
