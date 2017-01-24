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
package geekForGeek;

/**
 * @author debmalyajash
 *
 */
public class LuckyNumbers {
	
	public static void main(String[] args) {
		System.out.println(Math.floor((double)5/(double)3));
	}

	/**
	 * Take the set of integers 1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,……
	 * 
	 * First, delete every second number, we get following reduced set.
	 * 1,3,5,7,9,11,13,15,17,19,…………
	 * 
	 * Now, delete every third number, we get 1, 3, 7, 9, 13, 15, 19,….….
	 * 
	 * Continue this process indefinitely…… Any number that does NOT get deleted
	 * due to above process is called “lucky”.
	 * 
	 * Therefore, set of lucky numbers is 1, 3, 7, 13,………
	 * 
	 * Now, given an integer ‘n’, write a function to say whether this number is
	 * lucky or not.
	 * 
	 * @param args
	 */
	private int counter = 2;
	public boolean isLucky(int n){
		
		int nextPosition = n;
		// Lucky number cannot be even
		if (counter > n) {
			return true;
		}
		
		if (n % counter == 0){
			return false;
		}
		
		
		nextPosition -= nextPosition / counter;
		counter++;
		return isLucky(nextPosition);
	}

}
