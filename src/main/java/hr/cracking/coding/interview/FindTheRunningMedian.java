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
	
//	Learnt from https://www.hackerrank.com/lahouari
	 public static double median(List<Integer> data) {
		  if ((data.size() & 1) == 1) {
		    return data.get(data.size()/2);
		  } else {
		    int midSize = data.size()/2;
		    return (data.get(midSize-1) + data.get(midSize)) / 2.0;
		  }
		}

		public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
		  int n = in.nextInt();
		  List<Integer> data = new ArrayList<>();
		  for (int i = 0; i < n; i++) {
		    int a_i = in.nextInt();
		    int pos = Collections.binarySearch(data, a_i);
		    if (pos < 0) pos = Math.abs(pos)-1;
		    data.add(pos, a_i);
		    System.out.format("%1$.1f\n", median(data));
		  }
		}

}
