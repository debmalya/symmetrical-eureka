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
public class HerosNZerosTest {

	/**
	 * Test method for {@link cf.HerosNZeros#Zeros(int)}.
	 */
	@Test
	public final void testZeros() {
		
		Assert.assertEquals(1,HerosNZeros.Zeros(5));
		Assert.assertEquals(1,HerosNZeros.Zeros(7));
		Assert.assertEquals(4,HerosNZeros.Zeros(23));
		Assert.assertEquals(7,HerosNZeros.Zeros(32));
		Assert.assertEquals(12,HerosNZeros.Zeros(50));
		Assert.assertEquals(24,HerosNZeros.Zeros(101));
//		Assert.assertEquals(499999997,HerosNZeros.Zeros(2000000000));
	}

}
