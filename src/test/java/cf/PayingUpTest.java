/**
 * 
 */
package cf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class PayingUpTest {

	/**
	 * Test method for {@link cf.PayingUp#paidUp(int[], int)}.
	 */
	@Test
	public final void testPaidUp() {
		PayingUp up = new PayingUp();
		String actual = up.paidUp(new int[] { 1, 1, 1 }, 3);
		Assert.assertEquals("Yes", actual);

		actual = up.paidUp(new int[] { 1, 2, 4, 8, 16 }, 11);
		Assert.assertEquals("Yes", actual);
		
//		actual = up.paidUp(new int[] { 17, 6, 4, 998, 254, 137, 259, 153, 154, 3, 28, 19, 123, 542, 857, 23, 687, 35, 99, 999 }, 132);
//		Assert.assertEquals("Yes", actual);
	}

}
