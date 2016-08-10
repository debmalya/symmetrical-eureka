package cf;

import org.junit.Test;

import org.junit.Assert;

public class FactorialTest {

	@Test
	public void testFactorialCount() {
		Assert.assertEquals(1, Factorial.FactorialCount(1));
		Assert.assertEquals(1, Factorial.FactorialCount(2));
		Assert.assertEquals(2, Factorial.FactorialCount(3));
		Assert.assertEquals(2, Factorial.FactorialCount(4));
		Assert.assertEquals(3, Factorial.FactorialCount(5));
		Assert.assertEquals(1, Factorial.FactorialCount(6));
	}

}
