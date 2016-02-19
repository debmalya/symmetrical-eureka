/**
 * 
 */
package amazed;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RotateArray2 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		boolean isError = false;
		int[][] matrix = null;
		int rowsInMatrix = 0;
		try (Scanner scanner = new Scanner(System.in)) {

			rowsInMatrix = scanner.nextInt();
			matrix = new int[rowsInMatrix][rowsInMatrix];
			scanner.nextLine();

			for (int i = 0; i < rowsInMatrix; i++) {
				String[] eachInput = scanner.nextLine().split(" ");
				if (eachInput.length != rowsInMatrix) {
					isError = true;
				} else {
					for (int j = 0; j < rowsInMatrix; j++) {
						matrix[i][j] = Integer.parseInt(eachInput[j]);
					}
				}
			}
			if (!isError) {
				rotateMatrix(matrix, rowsInMatrix);

			}

		} finally {
			if (isError) {
				System.out.println("ERROR");
			} else {
				for (int i = 0; i < rowsInMatrix; i++) {
					for (int j = 0; j < rowsInMatrix; j++) {
						System.out.println(matrix[i][j] + " ");
					}
					System.out.println();
				}
			}
		}

	}

	public static int[][] rotateMatrix(int[][] matrix, int rowsInMatrix) {
		int i = rowsInMatrix - 1;
		int j = rowsInMatrix - 1;
		int direction = 0;
		int temp = matrix[i][j];
		int total = rowsInMatrix * rowsInMatrix;
		int itemCount = 0;
		int next = 0;
		boolean[][] visited = new boolean[rowsInMatrix][rowsInMatrix];
		boolean newCircle = false;

		while (itemCount < total) {

			switch (direction) {
			case 0:
				if (j > 0) {
					j--;
				} else {
					direction++;
					i--;
				}
				break;
			case 1:
				if (i > 0) {
					i--;
				} else {
					direction++;
					j++;
				}
				break;
			case 2:
				if (j + 1 < rowsInMatrix) {
					j++;
				} else {
					direction++;
					i++;
				}

				break;

			case 3:
				if (i + 1 < rowsInMatrix) {
					i++;
				} else {
					direction++;
					j--;
				}
				break;
			default:
				System.err.println("Direction err :" + direction);
				break;
			}

			if (!visited[i][j]) {
				next = matrix[i][j];
				if (!newCircle) {
					matrix[i][j] = temp;
					visited[i][j] = true;
					newCircle = false;
					itemCount++;
				} else {
					newCircle = false;
					itemCount--;
				}
				temp = next;
				
			} else {
				if (direction == 4) {
					// time to go deep in inner circle
					newCircle = true;
					i--;
					j++;
					itemCount++;
				} else {
					direction++;
				}
			}
			

			direction %= 4;
		}
		return matrix;
	}

}
