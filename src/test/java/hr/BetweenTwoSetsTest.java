package hr;

import org.junit.Assert;
import org.junit.Test;



public class BetweenTwoSetsTest {

	@Test
	public void testGetNumbersBetweenSets() {
		int[] a = new int[]{2,4};
		int[] b = new int[]{16,32,96};
//		Assert.assertEquals(3, BetweenTwoSets.getNumbersBetweenSets(a, b));
		
		 a = new int[]{2,3};
		 b = new int[]{24,48};
//		 Assert.assertEquals(3, BetweenTwoSets.getNumbersBetweenSets(a, b));
		 
		 a = new int[]{2,3};
		 b = new int[]{32,48};
//		 Assert.assertEquals(3, BetweenTwoSets.getNumbersBetweenSets(a, b));
		 
	}

}
