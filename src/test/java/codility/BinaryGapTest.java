package codility;



import org.junit.Assert;
import org.junit.Test;



public class BinaryGapTest {

	@Test
	public void test() {
		BinaryGap bg = new BinaryGap();
		Assert.assertEquals(5, bg.solution(1041));
		Assert.assertEquals(0, bg.solution(15));
		Assert.assertEquals(1, bg.solution(5));
		Assert.assertEquals(0, bg.solution(16));
		Assert.assertEquals(1, bg.solution(110));
	}

}
