/**
 * 
 */
package redmart.model;

import org.apache.log4j.Logger;

/**
 * @author debmalyajash
 *
 */
public class Product implements Comparable<Product>{
	
	private static final Logger LOGGER = Logger.getLogger(Product.class);
	private int productID;
	private double price;
	private int length;
	private int width;
	private int height;
	private int weight;

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Product(String[] values) {
		try {
			productID = Integer.parseInt(values[0]);
			price = Integer.parseInt(values[1]);
			length = Integer.parseInt(values[2]);
			width = Integer.parseInt(values[3]);
			height = Integer.parseInt(values[4]);
			weight = Integer.parseInt(values[5]);
		} catch (Throwable th) {
			LOGGER.error(th.getMessage(),th);
			throw new RuntimeException(th.getMessage(),th);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", price=" + price
				+ ", length=" + length + ", width=" + width + ", height="
				+ height + ", weight=" + weight + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Product o) {
		if (price != o.price) {
			return (int) (price - o.price);
		} else {
			return weight - o.weight;
		}
		
	}

}
