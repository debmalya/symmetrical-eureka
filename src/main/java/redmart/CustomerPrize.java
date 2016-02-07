/**
 * 
 */
package redmart;

import java.util.List;

/**
 * @author debmalyajash
 *
 */
public interface CustomerPrize {
	/**
	 * 
	 * @param productList
	 * @return product to choose
	 */
	String selectProduct(List<String[]> productList);
}
