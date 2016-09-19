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
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class KthZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			String[] values = in.nextLine().split(" ");
			int n = Integer.parseInt(values[0]);
			int m = Integer.parseInt(values[1]);
			
			int[] arr = new int[n];
			values = in.nextLine().split(" ");
			for (int i= 0; i < n; i++){
				arr[i] = Integer.parseInt(values[i]);
			}
			
			List<String> result = new ArrayList<>();
			for (int i = 0; i < m; i++){
				String[] query = in.nextLine().split(" ");
				if (query[0].equals("1")){
					int k = Integer.parseInt(query[1]);
					int count = 0;
					boolean found =false;
					for (int a = 0; a < n; a++){
						if (arr[a] == 0){
							count++;
							if (count == k){
								result.add(""+a);
								found = true;
								break;
							}
						}
					}
					
					if (!found){
						result.add("NO");
					}
				} else if (query[0].equals("2")){ 
					int index = Integer.parseInt(query[1]);
					arr[index] = Integer.parseInt(query[2]);
				}
			}
			
			for (String each:result){
				System.out.println(each);
			}
		}

	}

}
