package cf;

import org.junit.Assert;
import org.junit.Test;



public class GoldenNumberTest {

	@Test
	public void testGoldenNumbers() {
		Assert.assertEquals(1,GoldenNumber.GoldenNumbers(1));
		Assert.assertEquals(2,GoldenNumber.GoldenNumbers(2));
		Assert.assertEquals(3,GoldenNumber.GoldenNumbers(3));
		Assert.assertEquals(4,GoldenNumber.GoldenNumbers(4));
		Assert.assertEquals(5,GoldenNumber.GoldenNumbers(5));
		Assert.assertEquals(6,GoldenNumber.GoldenNumbers(6));
		Assert.assertEquals(8,GoldenNumber.GoldenNumbers(7));
		Assert.assertEquals(859963392,GoldenNumber.GoldenNumbers(1500));
		System.out.println(GoldenNumber.GoldenNumbers(1500));
	}

}
