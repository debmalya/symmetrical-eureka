/**
 * 
 */
package codility;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class DwarfCompanyTest {

	/**
	 * Test method for {@link codility.DwarfCompany#solution(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSolution() {
		DwarfCompany dwarfCompany = new DwarfCompany();
		int actual = dwarfCompany.solution(4, "1B 1C 4B 1D 2A", "3B 2D");
		Assert.assertEquals(6, actual);
		
		actual = dwarfCompany.solution(4, "1B 1C 4B 1D 2A", "3B 2D 1A 2B 2C 2D 3A 3C 3D 4A 4C 4D");
		Assert.assertEquals(-1, actual);
		
		actual = dwarfCompany.solution(4, "1B", "4D");
		Assert.assertEquals(14, actual);
		
		actual = dwarfCompany.solution(4, "1B 3A", "1C 4D");
		Assert.assertEquals(12, actual);
	}
	
	@Test
	public final void testConvertLocation(){
		DwarfCompany dwarfCompany = new DwarfCompany();
		int[] expecteds = new int[]{0,0};
		int[] actuals  = dwarfCompany.convertLocation("1A");
		Assert.assertArrayEquals(expecteds, actuals);
		
		expecteds = new int[]{0,1};
		actuals  = dwarfCompany.convertLocation("1B");
		Assert.assertArrayEquals(expecteds, actuals);
		
	}

}
