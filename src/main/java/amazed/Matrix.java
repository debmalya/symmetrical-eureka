package amazed;

public class Matrix {

	int[][] matrix;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void rotate() {
		int n = matrix.length;
		int l = n / 2;
		for (int layer = 0; layer < l; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i -  first;
				int top = matrix[ first][i]; // save top
				// left -> top
				matrix[ first][i] = matrix[last-offset][ first];
				
				// bottom -> left
				matrix[last-offset][ first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top; // right <- saved top
				
			}
		}
	}

}
