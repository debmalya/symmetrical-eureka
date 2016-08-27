package amazed;



import org.junit.Assert;
import org.junit.Test;



public class StringUtilTest {

	@Test
	public void testIsUnique() {
		StringUtil util = new StringUtil();
		Assert.assertTrue(util.isUnique("raju"));
		Assert.assertFalse(util.isUnique("debmalya"));
		
	}
	
	@Test
	public void testRemoveDuplicates() {
		StringUtil util = new StringUtil();
		Assert.assertEquals("Not matching", "Debmaly", util.removeDuplicates("Debmalya"));
	}
	
	@Test
	public void testIsValid(){
		StringUtil util = new StringUtil();
		Assert.assertTrue(util.isValid("bxc"));
//		Assert.assertFalse(util.isValid("abc"));
	}

}
