/**
 * 
 */
package amazed;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class RotateArray2Test {

	/**
	 * Test method for {@link amazed.RotateArray2#rotateMatrix(int[][], int)}.
	 */
	@Test
	public final void testRotateMatrix() {
		int[][] matrix = new int[][]{{1,2},{3,4}};
		int[][] actuals = RotateArray2.rotateMatrix(matrix, 2);
		int[][] expecteds = new int[][]{{3,1},{4,2}};
		
		checkTwoDimensionalArrays(actuals, expecteds);
		
		matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		actuals = RotateArray2.rotateMatrix(matrix, 3);
		expecteds = new int[][]{{4,1,2},{7,5,3},{8,9,6}};
		checkTwoDimensionalArrays(actuals, expecteds);
		
		matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		actuals = RotateArray2.rotateMatrix(matrix, 4);
		expecteds = new int[][]{{5,1,2,3},{9,10,6,4},{13,11,7,8},{14,15,16,12}};
		checkTwoDimensionalArrays(actuals, expecteds);
		
	}

	private void checkTwoDimensionalArrays(int[][] actuals, int[][] expecteds) {
		for (int i = 0; i < actuals.length; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
	}

}
