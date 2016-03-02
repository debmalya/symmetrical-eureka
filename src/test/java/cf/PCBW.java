/**
 * 
 */
package cf;

/**
 * @author debmalyajash
 *
 */
public class PCBW {

	/**
	 * We call letter x a counterpart of letter y, if x is the ith letter of the
	 * English alphabet, and y is the (27 - i)th for each valid i (1-based). For
	 * example, 'z' is the counterpart of 'a' and vice versa, 'y' is the
	 * counterpart of 'b', and so on.
	 * 
	 * A properly closed bracket word (PCBW) is such a word that its first
	 * letter is the counterpart of its last letter, its second letter is the
	 * counterpart of its last by one letter, and so one.
	 * 
	 * Determine if the given word is a PCBW or not.
	 * 
	 * Example:
	 * 
	 * ClosedBracketWord("abiryz") = true 'a' is the counterpart of 'z'; 'b' <->
	 * 'y' 'i' <-> 'r' ClosedBracketWord("aibryz") = false
	 * ClosedBracketWord("abitryz") = false [input] string word
	 * 
	 * A string consisting of lowercase letters, 0 ≤ len(word) ≤ 20. [output]
	 * boolean
	 * 
	 * true if word is a PCBW, false otherwise.
	 * 
	 * @param word
	 * @return
	 */
	static boolean ClosedBracketWord(String word) {
		if (word.trim().length() > 0) {
			char[] c = word.toCharArray();
			int l = c.length;
			for (int i = 0; i <= l / 2; i++) {
				if (c[i] - 'a' + c[l - 1 - i] - 'a' != 25) {
					return false;
				}
			}
		}
		return true;
	}
}
