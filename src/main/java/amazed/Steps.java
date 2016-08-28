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

/**
 * @author debmalyajash
 *
 */
public class Steps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top. Each
	 * time you can either climb 1 or 2 steps. In how many distinct ways can you
	 * climb to the top?
	 * 
	 * @param n
	 * @return
	 * 
	 * @see 
	 * 
	 * http://math.stackexchange.com/questions/789804/how-many-distinct-ways-to-climb-stairs-in-1-or-2-steps-at-a-time
	 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
	 */
	public int getNumberOfSteps(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		return getNumberOfSteps(n - 1) + getNumberOfSteps(n - 2);
	}

}
