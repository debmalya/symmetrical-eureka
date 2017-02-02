package techgig;

public class Easy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @param input1
	 *            - balls in different boxes.
	 * @param input2
	 *            - number of boxes can choose.
	 * @param input3
	 *            - should be multiple of this value.
	 * @return minimum possible value which is multiple of input3.
	 */
	public static int ball_count(int[] input1, int input2, int input3) {
		// Write code here
		int result = Integer.MAX_VALUE;

		for (int i = 0; i <= input1.length - input3; i++) {
			int sum = input1[i];
			for (int k = i + 1; k <= input1.length - input3 + 1; k++) {
				for (int j = k; j < k + input3 - 1; j++) {
					// take sum of total input2 elements.
					sum += input1[j];
				}
				if (sum % input2 == 0) {
					result = Math.min(result, sum);
				}
				sum = input1[i];
			}
		}
		if (result == Integer.MAX_VALUE)
			return -1;
		else
			return result;
	}

}
