/**
 * 
 */
package here;

/**
 * @author debmalyajash
 *
 */
public interface Encoder {
	/**
	 * We can save bits by encoding frequently used characters with fewer bits
	 * than rarely used characters, thereby lowering total number of bits used.
	 * 
	 * If input sequence has only 1 character then it will be encoded as 0.
	 * @param input string to be encoded.
	 * @return encoded string
	 */
	String constructTree(String input);
}
