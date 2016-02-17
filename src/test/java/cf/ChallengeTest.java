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
public class ChallengeTest {

	@Test
	public final void test() {
		Challenge ch = new Challenge();
		ch.MaximumString("2354");
	}

	@Test
	public final void tasteShanta() {
		Challenge ch = new Challenge();
		Assert.assertEquals("WAR", ch.colorOfOurFlag("XCVcRebludcEXBDlXxuECVCD"));
	}
}
