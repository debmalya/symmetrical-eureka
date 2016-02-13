/**
 * 
 */
package codeeval;

import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class HuffmanEncoderTest {

	@Test
	public final void test() {
		HuffmanEncoder encoder = new HuffmanEncoder();
		String encodedValue = encoder.constructTree("abc");
		System.out.println(encodedValue);
		encodedValue = encoder.constructTree("ilovecodeeval");
		System.out.println(encodedValue);
	}

}
