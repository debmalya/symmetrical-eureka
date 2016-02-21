/**
 * 
 */
package codeeval;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class BeatOrBitTest {

	/**
	 * Test method for {@link codeeval.BeatOrBit#decodeGrayCode(java.lang.String)}.
	 */
	@Test
	public final void testGrayToDecimal() {
		int actual = BeatOrBit.grayToDecimal(10);
		Assert.assertEquals(3, actual);
	}


}
