package codility;

import org.junit.Assert;
import org.junit.Test;

public class OddOccurencesInArrayTest {

	@Test
	public void testSolution() {
		OddOccurencesInArray occurencesInArray = new OddOccurencesInArray();
		Assert.assertEquals(1,occurencesInArray.solution(new int[]{1,2,3,4,5}));
		Assert.assertEquals(1,occurencesInArray.solution(new int[]{1,2,2,4,4}));
		Assert.assertEquals(1,occurencesInArray.solution(new int[]{2,2,4,4,1}));
	}

}
