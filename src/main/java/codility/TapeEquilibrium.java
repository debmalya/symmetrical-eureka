package codility;

public class TapeEquilibrium {
	public int solution(int[] A) {
		// write your code in Java SE 8
		long sum = 0L;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		long currentSum = 0L;
		
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			currentSum += A[i];
			result = (int) Math.min(result,Math.abs(sum-2*currentSum));
		}
		return result;
	}
}
