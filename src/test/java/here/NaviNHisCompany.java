/**
 * 
 */
package here;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class NaviNHisCompany {

	/**
	 * Navi is a CEO of a famous IT based software company. He is hiring some
	 * new developers to work in his company. He already knows the number of new
	 * projects and number of hirings at particular timestamp. He will assign
	 * one project to one developer and that developer will work alone on that
	 * project . Your task is to help Navi in finding the number of projects
	 * that will still be unassigned. A project will go unassigned if there is
	 * no free developer at that time. . You will be given the chronological
	 * order of project requirements and recruit hirings, find the number of
	 * projects which will go unassigned.
	 * 
	 * Input
	 * 
	 * First line of the input will contain T (No. of test cases). For each test
	 * case, first line will contain a integer N. Next each N line will contain
	 * either an integer X (No. of hirings) or a string "New Project" . Output
	 * 
	 * For every test case, print the answer in a new line. Constraints
	 * 
	 * 1 ≤ T ≤ 10 
	 * 1 ≤ N ≤ 10**5 
	 * 1 ≤ X ≤ 5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int hiring = 0;
		List<Integer> results = new ArrayList<Integer>();
		try {
			line = br.readLine().trim();
			int T = Integer.parseInt(line);
			for (int i = 0; i < T; i++) {
				line = br.readLine().trim();
				int N = Integer.parseInt(line);
				
				int uP = 0;
				for (int j = 0; j < N; j++) {
					line = br.readLine().trim();

					if ("New Project".equalsIgnoreCase(line)) {						
						if (hiring > 0) {
							hiring--;							
						} else {
							uP++;
						}
					} else {
						hiring += Integer.parseInt(line);
					}
				}
				results.add(uP);
			}

		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			for (int e:results) {
				System.out.println(e);
			}
		}

	}
}
