package cf;

public class Soccer {

	public static void main(String[] args) {
		int d = 1000000007;
		System.out.println(d);

	}

	/**
	 * You recently joined the soccer club at your university, and you've
	 * noticed a cool ritual that your team performs before each game.
	 * 
	 * In the last few minutes before the starting whistle, some of the players
	 * from your team stand in a circle to get a pep talk from your coach. Fans
	 * often join the circle to show their support, but with a catch: only those
	 * wearing the official team t-shirts are allowed! This means the total
	 * number n of people in the circle can vary from 3 (the most important
	 * players) to 10**9 (all team members with all the fans). Each person in
	 * the circle has a two-digit number written on their back, ranging from
	 * "00" to "99" (it is possible for two people to have the same number).
	 * 
	 * under certain circumstances the formation of the circle is considered
	 * lucky, and the team wins the game - and otherwise it loses. The circle is
	 * considered to be a lucky formation if:
	 * 
	 * for each person in the circle the number "ab" written on their back is
	 * such that |a - b| < k; if one person has the number "ab" written on their
	 * back and the person to their right has number "cd", then b + c > t.
	 * 
	 * Once you've figured out the pattern, before every game you step in and
	 * make sure that each circle is a lucky formation. However, in the
	 * semifinal, disaster strikes: you get a red card, so you won't be able to
	 * play in the final game, and, more importantly, you won't be able to make
	 * a lucky formation! Now you're wondering how many luckily formation
	 * circles your team members can possibly make without you.
	 * 
	 * Calculate the number of lucky formations modulo 109 + 7. Because you
	 * always check the luckiness of a circle starting from the person closest
	 * to the stands, the order that the numbers on peoples' backs appear in the
	 * circle does matter. Thus, formations in the image below are considered
	 * different.
	 * 
	 * Example
	 * 
	 * For n = 3, k = 2 and t = 16, the output should be soccerSuperstition(n,
	 * k, t) = 27.
	 * 
	 * Here are all possible lucky formations without rotations: ("88", "99",
	 * "89"), ("88", "98", "99"), ("88", "99", "99"), ("89", "89", "89"), ("89",
	 * "89", "99"), ("89", "98", "99"), ("89", "99", "99"), ("98", "98", "98"),
	 * ("98", "98", "99"), ("98", "99", "99") and ("99", "99", "99"), 11
	 * formations altogether. Counting all rotations, we get the final answer: 3
	 * + 3 + 3 + 1 + 3 + 3 + 3 + 1 + 3 + 3 + 1 = 27.
	 * 
	 * @param n
	 *            - The number of people in a circle. In order to be on the
	 *            challenge leader board you only have to solve it for n = 3.
	 *            Range 3 <= n <= 10**9.
	 * @param k
	 *            Range 1 <= k <= 10
	 * @param t
	 *            Range 1 <= t <= 17
	 * @return The number of lucky formations modulo 10**9 + 7.
	 */
	public int soccerSuperstition(int n, int k, int t) {
		int d = 1000000007;
		return 0;
	}
}
