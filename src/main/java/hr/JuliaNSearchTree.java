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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class JuliaNSearchTree {
	
//	static Queue<Integer> q = new LinkedBlockingQueue<Integer>();
	
//	static boolean[] marked;
	
	static Map<Integer,Integer> levelMap = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] arr = new int[n];
			

			Node root = new Node();
			int f = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				if (i == 0) {
					root.value = arr[i];
				} else {

					Node insertionPoint = root;
					int level = 0;
					while (true) {
						level++;
						if (arr[i] < insertionPoint.value) {
							if (insertionPoint.left == null) {
								insertionPoint.left = new Node();
								insertionPoint.left.value = arr[i];
								Integer count = levelMap.get(level);
								if (count == null) {
									count = 0;
								}
								count++;
								levelMap.put(level, count);
								break;
							}
							insertionPoint = insertionPoint.left;
						} else if (arr[i] > insertionPoint.value) {
							if (insertionPoint.right == null) {
								insertionPoint.right = new Node();
								insertionPoint.right.value = arr[i];
								Integer count = levelMap.get(level);
								if (count == null) {
									count = 0;
								}
								count++;
								levelMap.put(level, count);
								break;
							}
							insertionPoint = insertionPoint.right;
						}
					}
				}
			}

			
			Iterator<Entry<Integer, Integer>> it = levelMap.entrySet().iterator();
			while (it.hasNext()){
				Entry<Integer, Integer> nextEntry = it.next();
				f += (nextEntry.getKey() * nextEntry.getValue());
			}
			System.out.println(f);
		}

	}



	public static class Node {
		int value;
		Node left;
		Node right;
	}

}
