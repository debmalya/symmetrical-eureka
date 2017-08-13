/**
 * Copyright 2015-2017 Debmalya Jash
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
package lc;

/**
 * @author debmalyajash
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main( String[ ] args ) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0;i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

}
