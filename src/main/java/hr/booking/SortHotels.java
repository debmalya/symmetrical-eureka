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
package hr.booking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author debmalyajash
 *
 */
public class SortHotels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String[] words = in.nextLine().split(" ");
			int M = Integer.parseInt(in.nextLine());
			int[] values = new int[M];

			Map<Integer, Integer> rMap = new HashMap<>();
			for (int i = 0; i < M; i++) {

				int id = Integer.parseInt(in.nextLine());
				String value = in.nextLine();
				value = value.toLowerCase().replace(".", "");
				List<String> rd = Arrays.asList(value.split(" "));
				int count = 0;
				for (String eachWord : words) {
					if (rd.contains(eachWord)) {
						count++;
					}
				}
				Integer matchCount = rMap.get(id);
				if (matchCount == null) {
					matchCount = 0;
				}
				matchCount += count;
				rMap.put(id, matchCount);
				values[id] = matchCount;
			}

			Arrays.sort(values);
			SortedMap<Integer, Integer> sorted = new TreeMap<>();
			Iterator<Entry<Integer, Integer>> rIterator = rMap.entrySet().iterator();
			while (rIterator.hasNext()) {
				Entry<Integer, Integer> nextEntry = rIterator.next();
				sorted.put(nextEntry.getValue(), nextEntry.getKey());
			}

			Integer[] a = sorted.values().toArray(new Integer[0]);
			for (int i = a.length - 1; i > -1; i--) {
				System.out.print(a[i]+" ");
			}
		}

	}

}
/**
breakfast beach citycenter location metro view staff price
5
1
This hotel has a nice view of the citycenter. The location is perfect.
2
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
1
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
1
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
2
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.
*/