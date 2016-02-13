/**
 * 
 */
package codeeval;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class LightsOut {
	
	private static int onCount = 0;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		getInputOutput();
	}

	private static void getInputOutput() {
		List<String> inputList = new ArrayList<>();
		String eachLine = "";
		List<Integer> resultList = new ArrayList<>();
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				eachLine = scanner.nextLine();
				if (eachLine != null && eachLine.trim().length() > 0) {
					inputList.add(eachLine);
				} else {
					break;
				}
			}

			resultList = getOffCount(inputList);
		} finally {
			for (Integer each : resultList) {
				System.out.println(each);
			}
		}
	}

	/**
	 * 
	 * @param inputList
	 * @return
	 */
	private static List<Integer> getOffCount(List<String> inputList) {
		List<Integer> resultList = new ArrayList<>();
		for (String each : inputList) {
			boolean[][] lightBoard = createLightBoard(each);
			System.out.println(onCount);
		}
		return resultList;
	}

	/**
	 * The circuit board controls a rectangular box filled with N by M lights,
	 * which each may be on or off depending on the lighting needs of the
	 * performers.
	 * 
	 * @param each
	 *            The input begins with two integers on a line, N and M (1 <=
	 *            N,M <= 10), separated by a space. Then, N light box row
	 *            follow, separated by pipe. Each row has M characters either
	 *            '.' or 'O', indicating a light that is current off or a light
	 *            that is currently on, respectively.
	 * @return
	 * 
	 *         boolean array of size N X M. If the value is true that means
	 *         light is ON, false otherwise.
	 */
	private static boolean[][] createLightBoard(String each) {
		String[] boardDetails = each.split(" ");
		
		int N = Integer.parseInt(boardDetails[0]);
		int M = Integer.parseInt(boardDetails[1]);
		
		boolean[][] lightBoard = new boolean[N][M];
		
		String[] lights = boardDetails[2].split("\\|");
		
		onCount = 0;
		for (int row = 0; row < N; row++) {
			lightBoard[row] = new boolean[M];
			for (int col = 0; col < M; col++) {
				if (lights[row].charAt(col) == 'O') {
					lightBoard[row][col] = true;
					onCount++;
				}
			}
		}
				
		return lightBoard;
	}
}
