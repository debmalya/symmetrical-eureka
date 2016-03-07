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
public class KthSequenceTest {

	@Test
	public final void test() {
		String actual = KthSequence.process("2 1");
		Assert.assertEquals("OZ",actual);
		
		actual = KthSequence.process("2 2");
		Assert.assertEquals("ZO",actual);
		
		actual = KthSequence.process("2 3");
		Assert.assertEquals("-1",actual);
		
		actual = KthSequence.process("3 2");
		Assert.assertEquals("OOZ",actual);
	}

}
