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
	 * Maximize the dollar value of the products in the tote.
	 * A lighter tote is better, as long as you don’t sacrifice any dollar value.
	 * @param productList.
	 * @return product to choose.
	 */
	String selectProduct(List<String[]> productList);
}
