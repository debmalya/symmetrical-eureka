/**
 * 
 */
package cf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class UserNameTest {

	@Test
	public final void test() {
		UserName userName = new UserName();
		Assert.assertTrue(userName.canUpdate("Sheik", "Zelda", false, new String[]{"Link", "Ganon", "Zelda"}));
		Assert.assertFalse(userName.canUpdate("CASTOR", "John", false, new String[]{"Castor","Polux","John"}));
		Assert.assertTrue(userName.canUpdate("The_Boss", "the_boss", true, new String[]{"Snake","the_boss","Zero"}));
		Assert.assertFalse(userName.canUpdate("Sheik", "Zelda", true, new String[]{"Link", "Ganon", "Zelda"}));
		Assert.assertFalse(userName.canUpdate("CASTOR", "John", true, new String[]{"Castor","Polux","John"}));
//		the newUsername and the curUsername differ only in the case
		Assert.assertTrue(userName.canUpdate("Sheik", "SHeik", false, new String[]{"Link", "Ganon", "Zelda"}));
		Assert.assertTrue(userName.canUpdate("Sheik", "SHeik", true, new String[]{"Link", "Ganon", "Zelda"}));
		Assert.assertTrue(userName.canUpdate("Sheik", "SHeik", true, new String[]{"Link", "Ganon", "Zelda"}));
		Assert.assertFalse(userName.canUpdate("debmalya_jash$", "debmalya_jash", false, new String[]{"Link", "Ganon", "Zelda"}));
	}

}
