package codility;

public class CyclicRotation {
	public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
		int[] r = new int[A.length];
		for (int i = 0, j = K; i < A.length;i++, j++){
			r[j%A.length] = A[i];
		}
		return r;
    
    }

}
