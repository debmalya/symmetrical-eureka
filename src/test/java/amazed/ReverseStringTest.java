package amazed;

import org.junit.Assert;
import org.junit.Test;



public class ReverseStringTest {

	@Test
	public void testReverse() {
		ReverseString reverseString = new ReverseString();
		Assert.assertEquals("Coder a am i", reverseString.reverse("I am a coder"));
	}

}
