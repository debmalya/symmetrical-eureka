/**
 * 
 */
package codeeval;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class BeatOrBitTest {
	
	@Test
	public final void testProcessEachLine() {
		String actual = BeatOrBit.processEachLine("1111 | 1110");
		Assert.assertEquals("10 | 11", actual);
	}

	/**
	 * Test method for {@link codeeval.BeatOrBit#decodeGrayCode(java.lang.String)}.
	 */
	@Test
	public final void testGrayToDecimal() {
		int actual = BeatOrBit.grayToDecimal(10);
		Assert.assertEquals(3, actual);
		
		actual = BeatOrBit.grayToDecimal(1111);
		Assert.assertEquals(10, actual);
		
		actual = BeatOrBit.grayToDecimal(1110);
		Assert.assertEquals(11, actual);
		
		actual = BeatOrBit.grayToDecimal(1100001);
		Assert.assertEquals(65, actual);
		
		actual = BeatOrBit.grayToDecimal(101);
		Assert.assertEquals(6, actual);
	}


}
