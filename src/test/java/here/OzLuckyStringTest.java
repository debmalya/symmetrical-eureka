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
public class OzLuckyStringTest {

	@Test
	public final void test() {
		int actual = OzLuckyString.process("KRKRKKR");
		Assert.assertEquals(4, actual);
		
		actual = OzLuckyString.process("KKKRRR");
		Assert.assertEquals(0, actual);
		
		actual = OzLuckyString.process("RRRKKK");
		Assert.assertEquals(6, actual);
		
		actual = OzLuckyString.process("RKRKRK");
		Assert.assertEquals(4, actual);
	}

}
