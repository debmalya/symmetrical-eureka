/**
 * 
 */
package amazed;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class ManhattanDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = "NO";
		try (Scanner scanner = new Scanner(System.in)){
			
			int rowsInMatrix = scanner.nextInt();
			scanner.nextLine();
			
			String[] inputs = new String[rowsInMatrix];
			for (int i = 0; i < rowsInMatrix; i++) {
				inputs[i] = scanner.nextLine();
			}
			
			int k = scanner.nextInt();
			result = check(inputs,k);
		}finally {
			System.out.println(result);
		}

	}

	/**
	 * @param inputs
	 * @param k
	 * @return
	 */
	public static String check(String[] inputs, int k) {
		Set<Integer> unique = new HashSet<Integer>();
		boolean isFirst = true;
		for (String each:inputs){
			String[] values = each.split(" ");
			for (int i = 0; i < k; i++){
				if (unique.add(Integer.parseInt(values[i])) && !isFirst){
					return "NO";
				}
			}	
			
			if (isFirst) {
				isFirst = false;
			}
		}
		return "YES";
	}

}
