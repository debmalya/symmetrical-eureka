package cf;

import org.junit.Assert;
import org.junit.Test;

public class CircumscribedCircleTest {

	@Test
	public void testCircumcircle() {
		CircumscribedCircle circle = new CircumscribedCircle();
		int[][] triangle = new int[][] { { 3, 2 }, { 1, 4 }, { 5, 4 } };
		int[] expecteds = new int[] { 3, 4, 2 };
		int[] actuals = circle.circumcircle(triangle);
//		Assert.assertArrayEquals(expecteds, actuals);

		triangle = new int[][] { { 8, 6 }, { 8, -2 }, { 2, -2 } };
		expecteds = new int[] { 5, 2, 5 };
		actuals = circle.circumcircle(triangle);
//		Assert.assertArrayEquals(expecteds, actuals);
		
		triangle = new int[][] { { 5, 7 }, { 6, 6 }, { 2, -2 } };
		expecteds = new int[] { 2, 3, 5 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
		
		triangle = new int[][] { { 3, 4 }, { 4, 5 }, { 4, 3 } };
		expecteds = new int[] { 4, 4, 1 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
		
		triangle = new int[][] { { 3, 4 }, { 4, 5 }, { 4, 3 } };
		expecteds = new int[] { 4, 4, 1 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
		
		triangle = new int[][] { { 2, 11 }, { 6, 7 }, { -2, 7 } };
		expecteds = new int[] { 2, 7, 4 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
		
		triangle = new int[][] { { 5, 1 }, { -2, 0 }, { 4, 8 } };
		expecteds = new int[] { 1, 4, 5 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
		
		triangle = new int[][] { { 1, 4 }, { -2, 3 }, { 5, 2 } };
		expecteds = new int[] { 1, -1, 5 };
//		Assert.assertArrayEquals(expecteds, circle.circumcircle(triangle));
	}

}
