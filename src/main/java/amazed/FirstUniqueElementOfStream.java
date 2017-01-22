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
package amazed;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author debmalyajash
 *
 */
public class FirstUniqueElementOfStream {

	/**
	 * Have a stream of integers, We have to find the first unique element.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}



	public static int getFirstUniqueElement(int[] arr) {
		LinkedHashMap<Integer,Integer> occurrenceMap = new LinkedHashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			Integer count = occurrenceMap.get(arr[i]);
			if (count == null) {
				count = 0;
			}
			occurrenceMap.put(arr[i], ++count);
		}
		
	  Iterator<Integer> keySetIterator = occurrenceMap.keySet().iterator();
	  while (keySetIterator.hasNext()) {
		  Integer eachKey = keySetIterator.next();
		  if (occurrenceMap.get(eachKey) == 1) {
			  return eachKey;
		  }
	  }
	  return -99;
		
	}
}
