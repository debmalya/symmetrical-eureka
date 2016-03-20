/**
 * 
 */
package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class Enclosure {
	

	/**
	 * Pen is an enclosure.Pen will be rectangular and built from exactly four
	 * pieces of fence.
	 * 
	 * @param A
	 *            - length of available pieces of fence. [0 - 100000]
	 * @param X
	 *            - Threshold (area of fence must be greater than or equal to
	 *            X). [1 - 1000000000]
	 * @return number of different ways in which a pen can be built.
	 */
	public int solution(int[] A, int X) {
		Set<Integer> allItems = new HashSet<>();
		int k = (int)Arrays.stream(A).filter(n -> n >= X && !allItems.add(n)).distinct().count()*(int)Arrays.stream(A).filter(n -> n < X && !allItems.add(n)).distinct().count();							
		return k  >= 1 ? k  : -1;
	}
}
