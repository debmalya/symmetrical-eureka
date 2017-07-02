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
	
	@Test
	public void testCompress(){
		Assert.assertEquals("a5b9c4pqrstuv",StringUtil.compress("aaaaabbbbbbbbbccccpqrstuv"));
		Assert.assertEquals("a5b9c4de7", StringUtil.compress("aaaaabbbbbbbbbccccdeeeeeee"));
	}

	@Test
	public void testWt(){
		Assert.assertEquals(4, StringUtil.waitingTime(new int[]{1,2,5}, 1));
		Assert.assertEquals(11, StringUtil.waitingTime(new int[]{5,5,2,3}, 3));
		Assert.assertEquals(1, StringUtil.waitingTime(new int[]{1,1,1,1}, 0));
		Assert.assertEquals(12, StringUtil.waitingTime(new int[]{2,6,3,4,5}, 2));
		Assert.assertEquals(20, StringUtil.waitingTime(new int[]{2,6,3,4,5}, 1));
	}
}
