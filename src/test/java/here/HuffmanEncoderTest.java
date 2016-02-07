/**
 * 
 */
package here;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class HuffmanEncoderTest {

	/**
	 * Test method for {@link here.HuffmanEncoder#constructTree(java.lang.String)}.
	 */
	@Test
	public final void testConstructTree() {
		Encoder en = new HuffmanEncoder();
		
		String result = en.constructTree("aabb");	
		Assert.assertEquals("Expected '0011' but found " + result, "0011", result);
		
//		result = en.constructTree("aabbc");
//		System.out.println(" aabbc :" +result);
		
		result = en.constructTree("acdabebaae");
		Assert.assertEquals("0111011110101101000110", result);
		
		result = en.constructTree("aaaaaaa");
//		System.out.println("Raju :" + result);
//		Assert.assertNotNull(result);
	}

}
