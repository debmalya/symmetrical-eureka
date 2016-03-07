/**
 * 
 */
package here;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class KthSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<String> result = new ArrayList<String>();
		try {
			line = br.readLine();
			int N = Integer.parseInt(line);
			for (int i = 0; i < N; i++) {
				result.add(process(br.readLine()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (String each:result){
				System.out.println(each);
			}
		}

	}

	/**
	 * @param line
	 * @return
	 */
	public static String process(String line) {
		String[] values = line.split(" ");
		int n = Integer.parseInt(values[0]);
		Long k = Long.parseLong(values[1]);
		List<String> sequences = new ArrayList<String>();
		String[] base = new String[] { "OO", "OZ", "ZO" };
		if (n == 2) {
			if (k < 3) {
				return base[k.intValue()];
			} else {
				return "-1";
			}
		}

		int i = 2;
		sequences = Arrays.asList(base);
		while (i < n) {
			List<String> all = generate(sequences);
			sequences = null;
			sequences = new ArrayList<String>();
			sequences.addAll(all);
			i++;
		}

		Collections.sort(sequences);
		if (k.intValue() < sequences.size()) {
			return sequences.get(k.intValue() - 1);
		}
		return "-1";
	}

	/**
	 * @param sequences
	 * @param i
	 * @return
	 */
	private static List<String> generate(List<String> sequences) {
		List<String> newList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sequences.size(); i++) {
			sb.delete(0, sb.length());
			String each = sequences.get(i);
			if (!each.startsWith("Z")) {
				sb.append("Z");
				sb.append(each);
				if (!newList.contains(sb.toString())) {
					newList.add(sb.toString());
				}
				sb.delete(0, sb.length());
			}

			sb.append("O");
			sb.append(each);
			if (!newList.contains(sb.toString())) {
				newList.add(sb.toString());
			}

			sb.delete(0, sb.length());
			sb.append(each);
			sb.append("O");
			if (!newList.contains(sb.toString())) {
				newList.add(sb.toString());
			}

			if (!each.endsWith("Z")) {
				sb.delete(0, sb.length());
				sb.append(each);
				sb.append("Z");
				if (!newList.contains(sb.toString())) {
					newList.add(sb.toString());
				}
			}
		}
		return newList;
	}

}
