/**
 * 
 */
package ht;

import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class DuplicateTest {

	/**
	 * Test method for {@link ht.DuplicateFinder#getDuplicate(int, java.lang.String[])}.
	 */
	@Test
	public final void testGetDuplicate() {
		long startTime = System.currentTimeMillis();
		String[] values = new String[1000000];
		int n = 0;
		
		for (int i = 0; i < values.length; i++) {
			int a = (int)((double)Math.random()*Integer.MAX_VALUE);
			n = Math.max(n, a);
			values[i] = String.valueOf((int)Math.random()*Integer.MAX_VALUE);
		}
		
		String actual = DuplicateFinder.getDuplicate(n, values);
		System.out.println(actual+ " time taken :"+  " " + (System.currentTimeMillis() - startTime) + "ms.");
	}

}
