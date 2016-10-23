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
public class SimilarStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			int q = in.nextInt();
			String s = in.next();
			int[] re = new int[q];
			for (int i = 0; i < q; i++){
				int l = in.nextInt();
				int r = in.nextInt();
				
				List<char[]> similars = new ArrayList<>();
				for (int a = 0; a < s.length() - r; a++){
					int size = r - l;
					char[] s1 = s.substring(a, a + ( r - l)).toCharArray();
					if (r - l == 1){
						similars.add(s1);
					}
				}
				re[i] = similars.size();
			}
			
			for (int i = 0; i < q; i++){
				System.out.println(re[i]);
			}
		}

	}

}
