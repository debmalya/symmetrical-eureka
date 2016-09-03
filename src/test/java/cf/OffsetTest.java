package cf;

import org.junit.Assert;
import org.junit.Test;




public class OffsetTest {

	@Test
	public void testOffsets() {
		Offset offSet = new Offset();
		int actual = offSet.offsets("14839");
		Assert.assertEquals(6, actual);
		
		actual = offSet.offsets("05992644492");
		Assert.assertEquals(-3, actual);
	}

}
