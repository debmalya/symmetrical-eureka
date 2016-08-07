package sap;

import org.junit.Assert;
import org.junit.Test;

public class MillyNSpecialSubArrayTest {

	@Test
	public void testGetNumberOfSubArrays() {
		
		Assert.assertEquals(4, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,3}));
		Assert.assertEquals(7, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1,3}));
		Assert.assertEquals(7, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,2,2,3}));
		Assert.assertEquals(11, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1,1,3}));
		Assert.assertEquals(11, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1,3,1}));
		Assert.assertEquals(8, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1,3,2}));
		Assert.assertEquals(6, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1}));
		
		Assert.assertEquals(10, MillyNSpecialSubArray.getNumberOfSubArrays(new int[]{1,1,1,1}));
		
	}

}
