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
public class PronicNumberTest {

	/**
	 * Test method for {@link cf.PronicNumber#isPronic(int)}.
	 */
	@Test
	public final void testIsPronic() {
		PronicNumber n = new PronicNumber();
		Assert.assertTrue(n.isPronic(6));
		Assert.assertTrue(n.isPronic(42));
		Assert.assertTrue(n.isPronic(182));
		Assert.assertTrue(n.isPronic(25760));
//		Assert.assertTrue(n.isPronic(42230));
	}

}
