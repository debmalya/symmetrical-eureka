/**
 * 
 */
package codeeval;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ColumnNamesTest {

	@Test
	public final void test() {
		Assert.assertEquals("A",ColumnNames.getColumnName("1"));
		Assert.assertEquals("B",ColumnNames.getColumnName("2"));
		Assert.assertEquals("Z",ColumnNames.getColumnName("26"));
		Assert.assertEquals("AA",ColumnNames.getColumnName("27"));
		Assert.assertEquals("AZ",ColumnNames.getColumnName("52"));
		Assert.assertEquals("ELJ",ColumnNames.getColumnName("3702"));
	}

}
