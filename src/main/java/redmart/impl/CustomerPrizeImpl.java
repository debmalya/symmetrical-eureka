/**
 * 
 */
package redmart.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import redmart.CustomerPrize;
import redmart.model.Product;

/**
 * @author debmalyajash
 *
 */
public class CustomerPrizeImpl implements CustomerPrize {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerPrize.class);
	
	private static final int TOTE_VOLUME = 45*30*35;

	/* (non-Javadoc)
	 * @see redmart.CustomerPrize#selectProduct(java.util.List)
	 */
	public String selectProduct(List<String[]> productList) {
		List<Product> products = new ArrayList<Product>();
		List<Product> rejectedProducts = new ArrayList<Product>();
		for (String[] eachProduct: productList) {
			Product product = new Product(eachProduct);
			if (product.getLength()*product.getHeight()*product.getWidth() < TOTE_VOLUME){
				products.add(product);
			} else {
				rejectedProducts.add(product);
			}
			
		}
		
		Collections.sort(products);
		
		printProduct(products);
//		printProduct(products);
		
		return String.valueOf(products.get(products.size() - 1).getProductID());
	}

	private void printProduct(List<Product> products) {
		for (Product each: products) {
			LOGGER.debug(each);
		}
	}

}
