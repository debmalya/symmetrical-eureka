package cf;

import org.junit.Assert;
import org.junit.Test;



public class DateUtilityTest {

	@Test
	public void testUShouldDate0() {
		DateUtility utility = new DateUtility();
		int diff = utility.uShouldDate0(31,12,-1,1,1,0);
		Assert.assertEquals(1, diff);
	}
	
	@Test
	public void testUShouldDate() {
		DateUtility utility = new DateUtility();
		int diff = utility.uShouldDate(31,12,-1,1,1,0);
		Assert.assertEquals(1, diff);
	}

}
