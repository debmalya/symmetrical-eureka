package cf;

/**
 * 
 * @author debmalyajash
 *
 */
public class CircumscribedCircle {

	public static void main(String[] args) {

	}

	/**
	 * All triangles are cyclic, i.e. every triangle has a circumscribed circle.
	 * 
	 * @param triangle
	 *            - three coordinates of a triangle (x,y).
	 * @return - find the (x,y) coordinates of the circumscribed circle and its
	 *         radius.
	 * 
	 * Reference http://www.qc.edu.hk/math/Advanced%20Level/circle%20given%203%20points.htm
	 */
	int[] circumcircle(int[][] triangle) {
		// Assume x,y is the center of the circle
		int x = 0;
		int y = 0;
		// r is the radius of the circle
		int r = 0;

		// Find the equation of the circle passing through the points
		// {triangle[0][0],triangle[0][1]} - (A),
		// {triangle[1][0],triangle[1][1]} - (B),
		// {triangle[2][0],triangle[2][1]} - (C)

		// Get mid point of AB
		int m1X = (triangle[0][0] + triangle[1][0]) / 2;
		int m1Y = (triangle[0][1] + triangle[1][1]) / 2;
		// Get mid point of BC
		int m2X = (triangle[1][0] + triangle[2][0]) / 2;
		int m2Y = (triangle[1][1] + triangle[2][1]) / 2;
		// Get mid point of CA
		int m3X = (triangle[2][0] + triangle[0][0]) / 2;
		int m3Y = (triangle[2][1] + triangle[0][1]) / 2;

		// Gradient of AB
		int g1 = (triangle[0][1] - triangle[1][1]) / (triangle[0][0] - triangle[1][0]);
		// Gradient of BC
		int g2 = (triangle[1][1] - triangle[2][1]) / (triangle[1][0] - triangle[2][0]);
		// Gradient of CA
		int g3 = (triangle[2][1] - triangle[0][1]) / (triangle[2][0] - triangle[0][0]);

		// Product of gradients of perpendicular lines = -1
		// Gradient of perpendicular bisector of AB
		int rg1 = 0;
		if (g1 != 0) {
			rg1 = -1 / g1;
		}
		// Gradient of perpendicular bisector of BC
		int rg2 = 0;
		if (g2 != 0) {
			rg2 = -1 / g2;
		}
		// Gradient of perpendicular bisector of CA
		int rg3 = 0;
		if (g3 != 0) {
			rg3 = -1 / g3;
		}

		// (y - m1y) / (x - m1x) = rg1;
		// (y - m2y) / (x - m2x) = rg2;
		// (y - m3y) / (x - m3x) = rg3;
		// (y - m1y) = rg1 * (x - m1x);
		// (y - m2y) = rg2 * (x - m2x);
		// m2y - m1y = x( rg1 - rg2) + m2x - m1x
		if (rg1 - rg2 != 0) {
			x = (m2Y - m1Y - m2X + m1X) / (rg1 - rg2);
			y = (rg1 * (x - m1X)) + m1Y;
		} else if (rg2 - rg3 != 0) {
			x = (m3Y - m2Y - m3X + m2X) / (rg2 - rg3);
			y = (rg2 * (x - m2X)) + m2Y;
		} else if (rg1 - rg3 != 0) {
			x = (m1Y - m3Y - m1X + m3X) / (rg1 - rg3);
			y = (rg3 * (x - m3X)) + m3Y;
		}

		r = (int)(Math.sqrt(Math.pow(triangle[0][0] - x, 2)+Math.pow(triangle[0][1] - y, 2)));
		return new int[] { x, y, r };
	}

	int[] circumcircle0(int[][] triangle) {
		// Assume x,y is the center of the circle
		int x = 0;
		int y = 0;
		// r is the radius of the circle
		int r = 0;

		int[][] t = triangle;
		//
		double a = Math.sqrt(Math.pow(t[0][0] - t[1][0], 2) + Math.pow(t[0][1] - t[1][1], 2));
		double b = Math.sqrt(Math.pow(t[1][0] - t[2][0], 2) + Math.pow(t[1][1] - t[2][1], 2));
		double c = Math.sqrt(Math.pow(t[2][0] - t[1][0], 2) + Math.pow(t[2][1] - t[1][1], 2));
		double p = (a + b + c) / 2;
		double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		r = (int) ((int) (a * b * c) / (2 * area));

		return new int[] { x, y, r };
	}
}
