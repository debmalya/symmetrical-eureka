package amazed;

public class RotateVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Rotate a one-dimensional vector of n elements left by i positions. For
	 * instance, with n=8 and i=3, the vector abcdefg is rotated to defghabc.
	 * Simple code uses an n-element intermediate vector to do the job in n
	 * steps. Can you rotate the vector in time proportional to n using only a
	 * few dozen extra bytes of storage?
	 * 
	 * @param vector
	 * @param n
	 * @param j
	 * @return
	 */
	public String rotate(String vector, int n, int j) {
		String modified = vector + vector;
		int beginIndex = j % n;
		
		return modified.substring(beginIndex, beginIndex + n);
	}

}
