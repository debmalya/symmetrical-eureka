/**
 * 
 */
package codeeval;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class StringNMuskTest {

	/**
	 * Test method for {@link codeeval.StringNMusk#processEachLine(java.lang.String)}.
	 */
	@Test
	public final void testProcessEachLine() {
		String actual = StringNMusk.processEachLine("hello 11001");
		Assert.assertEquals("HEllO",actual);
		
		actual = StringNMusk.processEachLine("world 10000");
		Assert.assertEquals("World",actual);
		
		actual = StringNMusk.processEachLine("cba 111");
		Assert.assertEquals("CBA",actual);
	}
	
	@Test
	public void test() {
//		Collections.newSetFromMap
	}

}
