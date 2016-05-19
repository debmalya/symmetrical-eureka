/**
 * 
 */
package hr;

/**
 * @author debmalyajash
 *
 */
public class HourGlass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		System.out.println(getMax(arr));

		System.out.println("-------------------");
		arr = new int[][] { { 0, -4, -6, 0, -7, -6 },
				{ -1, -2, -6, -8, -3, -1 }, { -8, -4, -2, -8, -8, -6 },
				{ -3, -1, -2, -5, -7, -4 }, { -3, -5, -3, -6, -6, -6 },
				{ -3, -6, 0, -8, -6, -7 } };
		System.out.println(getMax(arr));
	}

	public static int getMax(int[][] arr) {
		int r = 0;
		int max = Integer.MAX_VALUE + 1;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				if (j > 1 && i > 1) {
					r = arr[i - 2][j - 2] + arr[i - 2][j - 1] + arr[i - 2][j]
							+ arr[i - 1][j - 1] + arr[i][j] + arr[i][j - 1]
							+ arr[i][j - 2];
					max = Math.max(r, max);
					System.out.println(r + " -> " + arr[i - 2][j - 2] + ","
							+ arr[i - 2][j - 1] + "," + arr[i - 2][j] + ","
							+ arr[i - 1][j - 1] + "," + arr[i][j - 2] + ","
							+ arr[i][j - 1] + "," + arr[i][j]);
				}
			}
		}
		return max;
	}

}
