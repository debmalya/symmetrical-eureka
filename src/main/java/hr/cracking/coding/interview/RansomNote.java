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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RansomNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int m = in.nextInt();
			int n = in.nextInt();
			String magazine[] = new String[m];
			for (int magazine_i = 0; magazine_i < m; magazine_i++) {
				magazine[magazine_i] = in.next();
			}
			String ransom[] = new String[n];
			for (int ransom_i = 0; ransom_i < n; ransom_i++) {
				ransom[ransom_i] = in.next();
			}
			
			boolean isPossible = canWriteNote(magazine,ransom);
			if (isPossible) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

	/**
	 * @param magazine
	 * @param ransom
	 * @return
	 */
	public static boolean canWriteNote(String[] magazine, String[] ransom) {
		Map<String,Integer> magazineMap = new HashMap<>();
		for (String each:magazine){
			Integer count = magazineMap.get(each);
			if (count == null) {
				count = 0;
			}
			count++;
			magazineMap.put(each, count);
		}
		
		for (String each:ransom){
			Integer count = magazineMap.get(each);
			if (count == null || count == 0) {
				return false;
			} else {
				count--;
				magazineMap.put(each, count);
			}
		}
		return true;
	}

}
