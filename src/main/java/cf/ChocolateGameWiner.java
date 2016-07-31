/**
 * 
 */
package cf;

/**
 * Chocolate Game is played between two players. The game starts once one of the
 * player buys a rectangular piece of chocolate, made up of 2 × n small square
 * pieces.
 * 
 * On each turn one of them eats either 1 × 1 or 2 × 2 piece from the chocolate
 * (whatever he chooses). The one who eats the last piece is known as the looser
 * of the game.
 * 
 * You are given the number n. Will the first player to make the turn win
 * assuming that both players play optimally? Here "play optimally" means they
 * make the optimal move to win, not to each as much chocolate as possible.
 * 
 * 
 * 
 * @author debmalyajash
 *
 */
public class ChocolateGameWiner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are given the number n. Will the first player to make the turn win
	 * assuming that both players play optimally? Here "play optimally" means
	 * they make the optimal move to win, not to each as much chocolate as
	 * possible.
	 * 
	 * @param n
	 *            square pieces.
	 * @return true if the first player wins, false otherwise.
	 * 
	 *         Example: if n = 1. There are 2 X 1 small chocolate square. First
	 *         player takes 1 X 1 piece. Second player has to take the remaining
	 *         one.
	 * 
	 *         So the first player wins, return will be true.
	 * 
	 * 
	 */
	boolean ChocolateGame(int n) {
		boolean f = false;
		n *= 2;
		while (n > 0) {
			if (n == 3) {
				n--;
			}
			n--;
			f = !f;
		}
		return f;
	}

}
