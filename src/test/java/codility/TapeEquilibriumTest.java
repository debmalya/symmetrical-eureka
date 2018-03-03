package codility;


import org.junit.Assert;
import org.junit.Test;



public class TapeEquilibriumTest {

	@Test
	public void testSolution() {
		TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
		Assert.assertEquals(0, tapeEquilibrium.solution(new int[]{1,1,1,1,4}));
		Assert.assertEquals(1, tapeEquilibrium.solution(new int[]{3,1,2,4,3}));
	}

}
