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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * You and your friends just returned from a fantastic trip to Europe. During
 * the trip, members of your group went on excursions to different attractions.
 * You decide to make a scrapbook of all the good memories, but you can't
 * remember the sequence in which you visited each attraction during each
 * excursion. You ask your friends to write down the sequence of attractions
 * they remember visiting during each excursion — in order (note that your
 * friends may not recall all the attractions visited on an excursion). Next,
 * you want to take the notes for each individual excursion and determine
 * whether or not you all agree on the order of visited attractions. For
 * example, consider the following two notes:
 * 
 * Eiffel tower,Olympus,Disneyland Eiffel tower,Oktoberfest,Disneyland In this
 * example, one of your friends forgot about visiting Olympus and the other
 * friend forgot about visiting Oktoberfest; however, both of your friends agree
 * on a weak order (Eiffel tower first, Disneyland last). Because a weak order
 * exists and there are no contradictions in the sequence of events, the group
 * is in agreement that an order exists.
 * 
 * It's also important to note that your friends may disagree on the order in
 * which they visited attractions. For example, consider the following two
 * notes:
 * 
 * Disneyland,Eiffel tower Eiffel tower,Disneyland In this example, your friends
 * disagree on the order in which they visited Disneyland and the Eiffel tower.
 * Because there is a conflict in the sequence of events, the order is violated.
 * 
 * Given the notes for excursions, determine whether or not the group of friends
 * that went on an excursion agrees on the sequence of attractions visited. For
 * each excursion, print whether or not everyone agrees on the sequence of
 * events. If the information given in the notes contains direct conflicts,
 * print ORDER VIOLATION on a new line; otherwise, print ORDER EXISTS.
 * 
 * Input Format
 * 
 * The first line contains a single integer, , denoting the number of
 * excursions. The subsequent lines describe each excursion in the following
 * form:
 * 
 * The first line contains an integer, , denoting the number of friends that
 * went on the excursion. Each line of the subsequent lines contains a single
 * string of comma-separated attraction names specifying the sequence of
 * attractions that friend recalls visiting. Constraints
 * 
 * The total number of attractions visited during a single excursion is . It is
 * guaranteed that an attraction name contains a maximum of characters. Output
 * Format
 * 
 * For each of the excursions, print whether or not the group of friends who
 * went on the excursion agrees on the sequence in which they visited the
 * attractions. If everyone is in agreement, print ORDER EXISTS on a new line;
 * otherwise, print ORDER VIOLATION on a new line.
 * 
 * Sample Input
 * 
 * 2 3 Red square,Colosseum Louvre,Red square Louvre 3 Sacre Coeur,The Hermitage
 * Stonehenge,Versailles,Louvre Louvre,Stonehenge Sample Output
 * 
 * ORDER EXISTS ORDER VIOLATION Explanation
 * 
 * For the first excursion, the only possible sequence of visited attractions is
 * Louvre → Red square → Colosseum. Because everyone is in agreement, we print
 * ORDER EXISTS on a new line.
 * 
 * For the second excursion, your friends do not agree on the order in which you
 * visited the Louvre and Stonehenge. Because everyone is not in agreement, we
 * print ORDER VIOLATION on a new line.
 * 
 * @author debmalyajash
 *
 */
public class GoodMemories {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfExcursions = Integer.parseInt(scanner.nextLine());
			String[] result = new String[numberOfExcursions];
			for (int a = 0; a < numberOfExcursions; a++) {

				int noOfFriends = Integer.parseInt(scanner.nextLine());
				
				Set<String> first = new HashSet<String>();
				Set<String> last = new HashSet<String>();
				boolean agreedOnFirst = false;
				boolean agreedOnLast = false;

				for (int i = 0; i < noOfFriends; i++) {
					
					String[] ar =scanner.nextLine().split(",");
					if (!first.add(ar[0])){
						agreedOnFirst = true;
					}
					
					if (!last.add(ar[ar.length - 1])){
						agreedOnLast = true;
					}
					
				}
				
				if (agreedOnFirst || agreedOnLast){
					result[a] = "ORDER EXISTS";
				} else {
					result[a] = "ORDER VIOLATION";
				}

				
			}
			
			

			for (int a = 0; a < numberOfExcursions; a++) {
				System.out.println(result[a]);
			}
		}

	}

}
