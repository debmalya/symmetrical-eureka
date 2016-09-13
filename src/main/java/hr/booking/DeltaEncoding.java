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

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class DeltaEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String[] inputs = in.nextLine().split(" ");
			int[] a = new int[inputs.length];
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < a.length; i++){
				a[i] = Integer.parseInt(inputs[i]);
				if (i == 0){
					sb.append(a[i]);
				} else {
					int diff = a[i] - a[i - 1];
					if (diff >= -127 && diff <= 127){
						sb.append(diff);
					} else {
						sb.append(-128);
						sb.append(" ");
						sb.append(diff);
					}
				}
				sb.append(" ");
			}
			
			System.out.println(sb.toString().trim());
		}

	}

}
