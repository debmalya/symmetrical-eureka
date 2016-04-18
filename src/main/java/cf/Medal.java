/**
 * 
 */
package cf;

/**
 * @author debmalyajash
 *
 */
public class Medal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String codemania_medal(final String user_time, final String gold, final String silver, final String bronze) {
		long u = getTime(user_time);
		long g = getTime(gold);
		if (u < g) {
			return "Gold";
		}
		
		long s = getTime(silver);
		if (u < s) {
			return "Silver";
		}
		
		long b = getTime(bronze);
		if (u < b) {
			return "Bronze";
		}
		return "None";
	}

	public long getTime(final String time) {
		String[] tc = time.split(":");
		
		long tt = Integer.parseInt(tc[0])*3600;
		tt += Integer.parseInt(tc[1])*60;
		tt += Integer.parseInt(tc[2]);
		
		return tt;
	}
}
