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
package hr.cracking.coding.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class FindTheRunningMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			
			List<Integer> values = new ArrayList<>();
			for (int i = 0; i < n ; i ++) {
				values.add(in.nextInt());
				Collections.sort(values);
				int mid = i/2;
				if (values.size() % 2 == 1){
					System.out.println(String.format("%.1f", (double)values.get(mid)));
				} else {
					
					System.out.println(String.format("%.1f", (double)(values.get(mid)+values.get(mid+1))/2.0));
				}
			}
		}

	}

}
