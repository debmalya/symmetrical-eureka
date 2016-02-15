/**
 * 
 */
package cf;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class InstabotTest {

	/**
	 * Test method for {@link cf.Instabot#isAdmissibleOverpayment(double[], java.lang.String[], double)}.
	 */
	@Test
	public final void testIsAdmissibleOverpayment() {
		Instabot.isAdmissibleOverpayment(new double[]{110,95,70},new String[]{"10.0% higher than in-store", 
		         "5.0% lower than in-store", 
		         "Same as in-store"}, 5);
	}

}
