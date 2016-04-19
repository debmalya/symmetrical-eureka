/**
 * 
 */
package cf;

import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class ShortestSuperString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int shortestSuperstring(String[] a) {
		Set<Character> u = new HashSet<>();
		for (String e:a) {
			for (int i = 0; i < e.length(); i ++) {
				u.add(e.charAt(i));
			}
		}
		return u.size();
	}

}
