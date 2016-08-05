package cf;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrayCodeTest {

	@Test
	public void testGrayCode() {
		GrayCode grayCode = new GrayCode();
		grayCode.grayCode(13);
	}

}
