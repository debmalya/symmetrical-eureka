package amazed;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void testRotate() {
		int[][] arr = new int[][]{{1,2},{3,4}};
		int[][] rot = new int[][]{{3,1},{4,2}};
		
		printDoubleDimensionArray(arr);
		Matrix matrix = new Matrix(arr);
		matrix.rotate();
		Assert.assertArrayEquals(rot, matrix.matrix);
		printDoubleDimensionArray(rot);
		
	}

	private void printDoubleDimensionArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}
