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
public class SumOf2Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int N = in.nextInt();
			int M = in.nextInt();
			int[] arr = new int[M];
			for (int a = 0; a <M; a++){
				arr[a] = in.nextInt();
			}
			
			for (int i = 0; i < M; i++){
				for (int j = 0; j < M; j++){
					if (i != j && arr[i] + arr[j] == N){
						System.out.println("1");
						return;
					}
				}
			}
		}	

		System.out.println("0");
	}

}
