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
public class GayleLegacy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		List<String> result = null;
		try {

			line = br.readLine().trim();
			int T = Integer.parseInt(line);

			result = new ArrayList<String>(T);

			for (int i = 0; i < T; i++) {

				String[] values = br.readLine().trim().split(" ");
				int N = Integer.parseInt(values[0]);
				int M = Integer.parseInt(values[1]);

				int[] G = new int[N];
				int[] P = new int[N];

				boolean isPossible = true;
				for (int j = 0; j < N; j++) {

					values = br.readLine().trim().split(" ");
					G[j] = Integer.parseInt(values[0]);
					P[j] = Integer.parseInt(values[1]);

					if (M <= P[j]) {
						result.add("NO");
						isPossible = false;
						break;
					} else {
						// hit six
						M = G[j] + P[j];
					}
				}
				
				if (isPossible) {
					result.add("YES");
				}
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

			for (String each : result) {
				System.out.println(each);
			}
		}

	}

}
