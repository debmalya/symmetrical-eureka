package he.ittiam.think;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class JPnSubSequenceTest {

	@Test
	public void testMaxSubsequenceSum() {
		
		Assert.assertEquals(6,JPnSubSequence.maxSubsequenceSum(new int[]{1,2,3}));
		Assert.assertEquals(6,JPnSubSequence.maxSubsequenceSum(new int[]{1,2,3,-1}));
	}

	@Test
	public void testMaxSubsequenceSum1() {
		int[] result = JPnSubSequence.maxSubsequenceSum(new int[]{1,2,3},5);
		Assert.assertEquals(6,result[0]);
		Assert.assertEquals(5,result[1]);
		
		result = JPnSubSequence.maxSubsequenceSum(new int[]{1,2,3, -1},5);
		System.out.println(Arrays.toString(result));
		Assert.assertEquals(6,result[0]);
	}
	
	@Test
	public void testMasSubsequenceSum2() {
		int result = JPnSubSequence.maxSubsequence(new int[]{1,2,3, -1},5);
		System.out.println(result);
		
	}
}
