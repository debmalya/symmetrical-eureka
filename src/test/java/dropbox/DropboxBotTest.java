/**
 * 
 */
package dropbox;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class DropboxBotTest {

	/**
	 * Test method for {@link dropbox.DropboxBot#loadTimeEstimator(int[], int[], int)}.
	 */
	@Test
	public final void testLoadTimeEstimator() {
		DropboxBot dbb = new DropboxBot();
		int[] expecteds = new int[]{116,115};
		int[] actuals = dbb.loadTimeEstimator(new int[]{21,10}, new int[]{100,105}, 2);
		Assert.assertArrayEquals(expecteds, actuals);
		
	}

}
