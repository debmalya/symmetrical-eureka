package hr;

import org.junit.Assert;
import org.junit.Test;



public class BabyStepGaintStepTest {

	@Test
	public void testGetAnswer() {
		int actual = BabyStepGaintStep.getAnswer(3, 2, 1);
		Assert.assertEquals(2, actual);
		
//		actual = BabyStepGaintStep.getAnswer(3, 4, 11);
//		Assert.assertEquals(3, actual);
//		
//		actual = BabyStepGaintStep.getAnswer(2, 3, 0);
//		Assert.assertEquals(0, actual);
//		
//		actual = BabyStepGaintStep.getAnswer(4, 1, 7);
//		Assert.assertEquals(3, actual);
	}

}
