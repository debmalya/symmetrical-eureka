/**
 * 
 */
package math.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MathUtilTest {

	/**
	 * Test method for {@link math.util.MathUtil#PerfectSquare(int)}.
	 */
	@Test
	public final void testPerfectSquare() {
		for (int i = 0; i < 1000; i++) {
			if (MathUtil.isPerfectSquare(i)){
				System.out.println(i);
			}
		}
	}
	
	@Test
	public final void testGoodNumbers() {
		String[] r = new String[]{"1","2","3"};
		int[] actuals = MathUtil.getGoodNumbers(r);
		int[] expecteds = new int[]{1,2,3};
		
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
