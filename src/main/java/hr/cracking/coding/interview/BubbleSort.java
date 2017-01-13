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

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			
			int[] result = bubbleSort(arr);
			System.out.println("Array is sorted in "+result[0]+" swaps.");
			System.out.println("First Element: "+result[1]);
			System.out.println("Last Element: "+result[2]);
		}

	}

	public static int[] bubbleSort(int[] arr){
		// Track number of elements swapped during a single array traversal
	    int numberOfSwaps = 0;
	    int[] result = new int[3];
	    for (int i = 0; i < arr.length; i++) {
	       
	        
	        for (int j = 0; j < arr.length - 1; j++) {
	            // Swap adjacent elements if they are in decreasing order
	            if (arr[j] > arr[j + 1]) {
	            	int temp = arr[j];
	            	arr[j] = arr[j + 1];
	            	arr[j + 1] = temp;
	                numberOfSwaps++;
	            }
	        }
	    }
	    
	    result[0] = numberOfSwaps;
	    result[1] = arr[0];
	    result[2] = arr[arr.length - 1];
	    return result;
	}
}
