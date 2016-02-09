/**
 * 
 */
package codeeval;

import org.junit.Assert;
import org.junit.Test;

import redmart.utility.Constants;

/**
 * @author debmalyajash
 *
 */
public class WorkingSolution {

	
	/**
	 * Test method for {@link codeeval.WokingSolution#getAcutalWorkExperience(java.lang.String)}.
	 */
	@Test
	public final void testGetAcutalWorkExperience() {
		String input = Constants.DIR + "ExperienceSummary.txt";
		
		
		Integer[] actuals = WokingSolution.getAcutalWorkExperience(input);
		Integer[] expecteds = new Integer[]{5,4,1,6,0};
		Assert.assertArrayEquals(expecteds, actuals);
		
	}
	
	@Test
	public final void testGetAcutalWorkExperience1() {
		String input = Constants.DIR + "ExperienceSummary1.txt";
		
		
		Integer[] actuals = WokingSolution.getAcutalWorkExperience(input);
		Integer[] expecteds = new Integer[]{1};
		Assert.assertArrayEquals(expecteds, actuals);
		
	}

}
