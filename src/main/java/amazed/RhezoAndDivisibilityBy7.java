/**
 * 
 */
package amazed;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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

		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger n = scanner.nextBigInteger();
			BigInteger q = scanner.nextBigInteger();
			
			for (BigInteger i = BigInteger.ZERO; i.compareTo(q) < 0; i.add(BigInteger.ONE)){
				BigInteger l = scanner.nextBigInteger();
				BigInteger r = scanner.nextBigInteger();
			}
			
		} 
	}

	public static void balerChop(Scanner scanner) {
		String v = scanner.nextLine();
		long q = scanner.nextLong();
		List<String> answers = new ArrayList<>();

		for (int i = 0; i < q; i++) {
			int l = scanner.nextInt() - 1;
			int r = scanner.nextInt();
			if (l > r){
				int temp = l;
				l = r;
				r = temp;
			}
			if (l == r) {
				l--;
			}
			int c = 0;
			
			if (l < r) {
				c = Integer.valueOf(v.substring(l, r));
			}
			if (c % 7 == 0) {
				answers.add("YES");
			} else {
				answers.add("NO");
			}
		}
		for (String each:answers) {
			System.out.println(each);
		}
	}

}
