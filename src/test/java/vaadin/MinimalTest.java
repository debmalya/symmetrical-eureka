package vaadin;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MinimalTest {

	@Test
	public void test() {
		int[] bs = new int[]{1,2,3,5};
		Arrays.sort(bs);
		
		bs = new int[]{1,2,3,4,5};
		Arrays.sort(bs);
		
		int[] A = new int[] { 1, 3, 2, 1 };
		int[] B = new int[] { 4, 2, 5, 3, 2 };
		Minimal m = new Minimal();
		int actual = m.solution(A, B);
		Assert.assertEquals(2, actual);

		A = new int[] { 1, 1, 1, 1, 4, 2, 5, 3, 2 };
		B = new int[] { 2, 3, 2, 4 };
		actual = m.solution(A, B);
		Assert.assertEquals(2, actual);

		A = new int[] {2,1};
		B = new int[] {3,3};
		actual = m.solution(A, B);
		Assert.assertEquals(-1, actual);
		
		A = new int[] {2,1,3};
		B = new int[] {0,0,0,0,3,3};
		actual = m.solution(A, B);
		Assert.assertEquals(3, actual);
		
		A = new int[1000000];
		B = new int[1000000];
		for (int i = 0; i < 1000000; i++){
			A[i] = (int)(Math.random()*10000000);
			B[i] = (int)(Math.random()*10000000);
		}
		actual = m.solution(A, B);
		System.out.println(actual);
		

		
	}

}
