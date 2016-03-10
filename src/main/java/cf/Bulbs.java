/**
 * 
 */
package cf;

import java.util.Arrays;

/**
 * @author debmalyajash
 *
 */
public class Bulbs {

	/**
	 * Some light bulbs are placed in a circle. Each one is either on (1) or off
	 * (0).
	 * 
	 * Every turn, the light bulbs change their states. If a light bulb was on
	 * at the previous turn, the light bulb to the right of it changes its
	 * state, i.e. if it was on it turns off and vice versa.
	 * 
	 * Find the state of the light bulbs after n turns.
	 * 
	 * Example:
	 * 
	 * lightBulbs([0,1,1,0,1],2) = [0,0,1,1,0]
	 * 
	 * Here are how the light bulbs' states change each turn:
	 * 
	 * 0) 0 1 1 0 1 1) 1 1 0 1 1 2) 0 0 1 1 0 [input] array.integer lights
	 * 
	 * A non-empty array, the initial states of the light bulbs, 2 ≤
	 * lights.length ≤ 70. [input] integer n
	 * 
	 * The number of turns, 1 ≤ n ≤ 300. [output] array.integer
	 * 
	 * The final light bulbs' states.
	 * 
	 * @param lights
	 * @param n
	 * @return
	 */
	int[] lightBulbs(int[] lights, int n) {
		int l = lights.length;
		int[] r = new int[l];
		for (int i = 0; i < n; i++) {
			System.arraycopy(lights, 0, r, 0, l);
			
			for (int j = 0; j < l; j++) {
				int f =  (j == 0 ? r[l - 1] : r[j - 1]);
				lights[j] = (f == 1) ? 1 - r[j] : r[j];
			}
		}
		return lights;
	}

}
