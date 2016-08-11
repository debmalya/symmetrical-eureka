/**
 * 
 */
package cf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class HofSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * A sequence. Such that t(1) = 1
	 * 
	 * It is increasing t(k) > t(k - 1) (for each k > 1)
	 * 
	 * t(k) - t(k -1) > t(k-1) - t(k-2) (for each k > 2)
	 * 
	 * each positive integer occurs either in the sequence, or in the
	 * differences of some two consecutive elements of the sequence (but NOT in
	 * both)
	 * 
	 * So, t = {1, 3, 7, 12, 18, ​​26, 35, 45, ...}, and the differences are {2,
	 * 4, 5, 6, 8, 9, 10, ...}. These two sequences are disjoint and cover the
	 * multitude of positive integers. Given a positive integer n, return t(n).
	 * 
	 * @param n
	 * @return  nth term.
	 */
	public String Hof(int n) {
		int s1 = 1;
		int s2 = 2;
		int count = 1;
		List<Integer> sl = new ArrayList<>();
		while (count < n){
			s1 += s2;
			sl.add(s1);
			s2++;
			while (sl.contains(s2)){
				s2++;
			}
			
			count++; 
		}
		return ""+s1;
	}

}
