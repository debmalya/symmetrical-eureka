package cf;

import org.junit.Assert;
import org.junit.Test;

public class CashTest {

	@Test
	public void testNCash() {
		Cash cash = new Cash();
		Assert.assertEquals(3, cash.nCash(new int[] { 1, 2, 5, 10, 20, 50, 100 }, 125));
		Assert.assertEquals(1, cash.nCash(new int[] { 0, 1, 2, 200, 5, 10, 20, 50, 100 }, 0));
		Assert.assertEquals(11, cash.nCash(new int[] { 10, 2, 1, 20, 500, 50 }, 1235));
		Assert.assertEquals(10, cash.nCash(new int[] { 1, 2, 5, 10, 20, 50, 100, 500 }, 1348));
	}

}
