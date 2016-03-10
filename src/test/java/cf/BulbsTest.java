/**
 * 
 */
package cf;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class BulbsTest {

	/**
	 * Test method for {@link cf.Bulbs#lightBulbs(int[], int)}.
	 */
	@Test
	public final void testLightBulbs() {
		int[] expecteds = new int[]{0, 0, 1, 1, 0};
		Bulbs bulbs = new Bulbs();
		Assert.assertArrayEquals(expecteds, bulbs.lightBulbs(new int[]{0,1,1,0,1}, 2));
		
		expecteds = new int[]{1, 1, 1, 0, 1};
		Assert.assertArrayEquals(expecteds, bulbs.lightBulbs(new int[]{0, 0, 1, 1, 1}, 5));
	}

}
