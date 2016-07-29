/**
 * 
 */
package amazed;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RhezoAndDivisibilityBy7 {

	/**
	 * @param args
	 * 
	 *            Rhezo is obsessed with the number 7 7 and likes numbers that
	 *            are divisible by 7 7.
	 * 
	 *            He has a big number of N N digits and Q Q questions. In each
	 *            of the question, he wants to find if the number formed by the
	 *            string between indices L i Li and R i Ri is divisible by 7 7
	 *            or not. As he is very weak at programming, you should help him
	 *            in this task.
	 * 
	 *            Input:
	 * 
	 *            First line contains the number consisting of N N digits. Next
	 *            line contains Q Q, denoting the number of questions. Each of
	 *            the next Q Q lines contains 2 2 integers L i Li and R i Ri.
	 * 
	 *            Output:
	 * 
	 *            For each question, print "YES" or "NO", if the number formed
	 *            by the string between indices L i Li and R i Ri is divisible
	 *            by 7 7.
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)){
			int n = scanner.nextInt();
			char[] v = Integer.toString(n).toCharArray();
			int q = scanner.nextInt();
			String[] answer = new String[q];
			StringBuilder sb = new StringBuilder();
			for (int i =0; i < q; i++){
				int l = scanner.nextInt();
				int r = scanner.nextInt();
				
				for (int j = l -1;  j < r; j++){
					sb.append(v[j]);
				}
				if (Integer.valueOf(sb.toString()) % 7 == 0) {
					answer[i] = "YES";
				} else {
					answer[i] = "NO";
				}
				sb.delete(0, sb.length());
				
			}
			
			for (int i =0; i < q; i++){
				System.out.println(answer[i]);
			}
		}
	}

}
