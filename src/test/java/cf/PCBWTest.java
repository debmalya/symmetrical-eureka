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
public class PCBWTest {

	/**
	 * Test method for {@link cf.PCBW#ClosedBracketWord(java.lang.String)}.
	 */
	@Test
	public final void testClosedBracketWord() {
		Assert.assertTrue(PCBW.ClosedBracketWord("abiryz"));
		Assert.assertFalse(PCBW.ClosedBracketWord("abitryz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdevwxyz"));
		Assert.assertFalse(PCBW.ClosedBracketWord("abcdetvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdevwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdefuvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdefgtuvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdefghstuvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdefghirstuvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord("abcdefghijqrstuvwxyz"));
		Assert.assertFalse(PCBW.ClosedBracketWord("abcdefghijkqrstuvwxyz"));
		Assert.assertTrue(PCBW.ClosedBracketWord(""));
	}

}
