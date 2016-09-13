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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
				value = value.toLowerCase().replace(".", "").replace(",", "");
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

			for (int i = 0; i < M; i++) {
				int max = Integer.MIN_VALUE;
				int maxIndex = -1;
				for (int j = 0; j < M; j++) {
					if (values[j] > max) {
						max = values[j];
						maxIndex = j;
					}
				}

				if (values[maxIndex] > 0) {
					System.out.print(maxIndex + " ");
					values[maxIndex] = Integer.MIN_VALUE;
				}
			}
		}

	}

}
/**
 * breakfast beach citycenter location metro view staff price 5 1 This hotel has
 * a nice view of the citycenter. The location is perfect. 2 The breakfast is
 * ok. Regarding location, it is quite far from citycenter but price is cheap so
 * it is worth. 1 Location is excellent, 5 minutes from citycenter. There is
 * also a metro station very close to the hotel. 1 They said I couldn't take my
 * dog and there were other guests with dogs! That is not fair. 2 Very friendly
 * staff and good cost-benefit ratio. Its location is a bit far from citycenter.
 */