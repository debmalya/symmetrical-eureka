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
		
		String[] arr = new String[]{"1 2 3","4 5 6"};
		Assert.assertEquals("NO",ManhattanDistance.check(arr, 2));
		
		arr = new String[]{"1 2 3","4 5 6","5 8 9"};
		Assert.assertEquals("YES",ManhattanDistance.check(arr, 2));
		
		arr = new String[]{"1 2 3","4 5 6","7 8 2","10 11 12"};
		Assert.assertEquals("NO",ManhattanDistance.check(arr, 2));
	}

}
