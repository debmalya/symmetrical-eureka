/**
 * 
 */
package amazed;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ManhattanDistanceTest {

	@Test
	public final void test() {
		String[] arr = new String[]{"1 2 3 4","3 2 1 3"};
		Assert.assertEquals("YES",ManhattanDistance.check(arr, 3));
		
		arr = new String[]{"1 2 3 4","4 2 1 3"};
		Assert.assertEquals("NO",ManhattanDistance.check(arr, 3));
	}

}
