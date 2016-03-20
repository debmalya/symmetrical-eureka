/**
 * 
 */
package codility;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author debmalyajash
 *
 */
public class EnclosureTest {

	@Test
	public final void test() {
		Enclosure enclosure = new Enclosure();
		int actual = enclosure.solution(new int[]{1, 2, 5, 1, 1, 2, 3, 5, 1}, 5);
		Assert.assertEquals(2, actual);
	}

}
