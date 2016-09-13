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
package he;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	
		public static void main(String args[] ) throws Exception {
	        try (Scanner in = new Scanner(System.in)){
	        	int N = in.nextInt();
	        	int[] A = new int[N];
	        	for (int i = 0; i < N; i++) {
	        		A[i] = in.nextInt();
	        	}
	        	Arrays.sort(A);
	        	int q = in.nextInt();
	        	int[] r = new int[q];
	        	for (int i = 0; i < q; i++){
	        		int a = in.nextInt();
	        		r[i] = Arrays.binarySearch(A,a);
	        		if (r[i] != -1){
	        			r[i]++;
	        		}
	        	}
	        	
	        	for (int i = 0; i < q; i++){
	        			System.out.println(r[i]);
	        	}
	    }

	}

}
