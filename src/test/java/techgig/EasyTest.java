package techgig;

import org.junit.Assert;
import org.junit.Test;



public class EasyTest {

	@Test
	public void testBall_count() {
		Assert.assertEquals(15, Easy.ball_count(new int[]{1,2,3,4,5}, 3, 5));
		Assert.assertEquals(10, Easy.ball_count(new int[]{1,2,3,4,5}, 5, 3));
		Assert.assertEquals(8, Easy.ball_count(new int[]{1,2,3,4,5}, 4, 3));
		Assert.assertEquals(6, Easy.ball_count(new int[]{1,2,3,4,5}, 6, 3));
		Assert.assertEquals(14, Easy.ball_count(new int[]{1,2,3,4,5}, 7, 4));
	}

}
