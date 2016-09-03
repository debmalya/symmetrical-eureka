package cf;

public class Offset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are given a chain of digits. The first element of the chain is the
	 * initial offset. Your task is to calculate the total offset, where offset
	 * is the sum of differences between two consecutive digits.
	 * 
	 * @param chain
	 * @return
	 */
	int offsets(String chain) {
		char[] a = chain.toCharArray();
		int s = a[0] - '0';
		for (int i = 2; i < a.length; i++){
			s += a[i] - a[i - 1];
		}
		return s;
	}
	

}
