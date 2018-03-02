package codility;

public class BinaryGap {

	

	public int solution(int N) {
		// write your code in Java SE 8

		int r = 0, cl = 0;
		boolean isOne = false;

		while (N > 0) {
			int now = N % 2;
			if (now == 0) {
				if (isOne || cl > 0) {
					cl++;
				}
				isOne = false;
			} else {
				isOne = true;
				if (cl > r) {
					r = cl;
				}
				cl = 0;
			}

			N /= 2;
		}

		return r;
	}

}
