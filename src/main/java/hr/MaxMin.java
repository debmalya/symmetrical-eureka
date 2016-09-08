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

import java.util.Arrays;

/**
 * @author debmalyajash
 *
 */
public class MaxMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getUnfairness(int[] arr,int range){
		int unfairness = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - range + 1; i++){
			unfairness = Math.min(unfairness, arr[i + range - 1] - arr[i]);
		}
		return unfairness;
	}

}
