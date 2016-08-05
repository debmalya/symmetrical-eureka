package cf;

import java.math.BigInteger;

/**
 * 
 * @author debmalyajash
 *
 */
public class Seconds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given the number of days, hours, minutes and seconds, return the total
	 * number seconds in all of them. Since it can be quite large, return it as
	 * a string.
	 * 
	 * Example
	 * 
	 * For days = 1, hours = 1, minutes = 1 and seconds = 1, the output should
	 * be howManySeconds(days, hours, minutes, seconds) = "9006
	 */
	public String howManySeconds(int days, int hours, int minutes, int seconds) {
		BigInteger b = new BigInteger(""+days).multiply(new BigInteger(""+(24*60*60)));
		b = b.add(new BigInteger(""+hours).multiply(new BigInteger(""+(60*60))));
		b = b.add(new BigInteger(""+minutes).multiply(new BigInteger(""+60)));
		b = b.add(new BigInteger(""+seconds));
		
		return b.toString();
	}
}
