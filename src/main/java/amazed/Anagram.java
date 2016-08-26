package amazed;

import java.util.Arrays;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a dictionary of English words, find sets of anagrams. For instance,
	 * “pots”, “stop”, and “tops” are all anagrams of one another because each
	 * can be found by permuting the letters of the others.
	 * 
	 * @param wordList
	 *            - list of words to be tested for anagram.
	 * @return true if they are anagram, false otherwise.
	 */
	public static boolean isAnagram(List<String> wordList) {
		if (wordList != null && !wordList.isEmpty()) {
			char[] sorted = wordList.get(0).toLowerCase().toCharArray();
			Arrays.sort(sorted);
			for (int i = 1; i < wordList.size(); i++) {
				char[] check = wordList.get(i).toLowerCase().toCharArray();
				Arrays.sort(check);
				if (!Arrays.equals(sorted, check)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
