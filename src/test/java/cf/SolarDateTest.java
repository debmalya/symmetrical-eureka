package cf;

import org.junit.Test;

import org.junit.Assert;

public class SolarDateTest {

	@Test
	public void testSolarDate() {
		SolarDate sd = new SolarDate();
		Assert.assertEquals("1, Fa", sd.solarDate(1));
		Assert.assertEquals("31, Fa", sd.solarDate(31));
		Assert.assertEquals("1, Or", sd.solarDate(32));
	}

}
