/**
 * 
 */
package redmart.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import redmart.CustomerPrize;
import redmart.MapImplTest;
import au.com.bytecode.opencsv.CSVReader;

/**
 * @author debmalyajash
 *
 */
public class CustomerPrizeImplTest {
	
	private static final String PRODUCT_FILE = MapImplTest.DIR + "products.csv";
	
	private static final Logger LOGGER = Logger.getLogger(CustomerPrizeImplTest.class);

	/**
	 * Test method for {@link redmart.impl.CustomerPrizeImpl#selectProduct(java.util.List)}.
	 */
	@Test
	public final void testSelectProduct() {
		CSVReader reader =  null;
		CustomerPrize prize = new CustomerPrizeImpl();
		try {
			reader = new CSVReader(new FileReader(PRODUCT_FILE));
			List<String[]> productList = reader.readAll();
			String productID = prize.selectProduct(productList);
			Assert.assertNotNull(productID);
			System.out.println(productID);
		} catch (Throwable e) {
			LOGGER.error(e.getMessage(),e);
			Assert.fail(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					LOGGER.error("CLOSE CALL:" + e.getMessage(), e );
				}
			}
		}
	}

}
