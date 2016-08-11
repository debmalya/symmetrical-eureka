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
public class HofSequenceTest {

	/**
	 * Test method for {@link cf.HofSequence#Hof(int)}.
	 */
	@Test
	public final void testHof() {
		HofSequence hs = new HofSequence();
		Assert.assertEquals("1",hs.Hof(1));
		Assert.assertEquals("3",hs.Hof(2));
		Assert.assertEquals("18",hs.Hof(5));
		Assert.assertEquals("69",hs.Hof(10));
	}

}
