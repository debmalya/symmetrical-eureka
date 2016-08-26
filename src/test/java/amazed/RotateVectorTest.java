package amazed;

import org.junit.Assert;
import org.junit.Test;



public class RotateVectorTest {

	@Test
	public void testRotate() {
		RotateVector vector = new RotateVector();
		Assert.assertEquals("defghabc", vector.rotate("abcdefgh", 8, 3));
		Assert.assertEquals("efghabcd", vector.rotate("abcdefgh", 8, 4));
		Assert.assertEquals("fghabcde", vector.rotate("abcdefgh", 8, 5));
		Assert.assertEquals("ghabcdef", vector.rotate("abcdefgh", 8, 6));
		Assert.assertEquals("habcdefg", vector.rotate("abcdefgh", 8, 7));
		Assert.assertEquals("abcdefgh", vector.rotate("abcdefgh", 8, 8));
		Assert.assertEquals("bcdefgha", vector.rotate("abcdefgh", 8, 9));
	}

}
