package amazed;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class Anagram {
	
	static int count;

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
				if (!Arrays.equals(sorted, check)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * How many characters will be removed to make it an anagram.
	 * 
	 * @param first
	 *            string.
	 * @param second
	 *            string.
	 * @return how many characters should be removed to make it anagram.
	 */
	public static int numberNeeded(String first, String second) {
		int[] f = new int[26];
		int[] s = new int[26];

		for (int i = 0; i < first.length(); i++) {
			f[first.charAt(i) - 'a']++;
		}

		for (int i = 0; i < second.length(); i++) {
			s[second.charAt(i) - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (f[i] != s[i]) {
				count += (Math.abs(f[i] - s[i]));
			}
		}
		return count;

	}

	/**
	 * 
	 * @param magazine
	 *            word in the magazine (case sensitive)
	 * @param note
	 *            word in the note (case sensitive)
	 * @return true if all the words in note are available in magazine, false
	 *         otherwise.
	 */
	public static boolean isRansomNote(String magazine, String note) {
		String[] magazineWords = magazine.split(" ");
		String[] noteWords = note.split(" ");

		LinkedHashMap<String, Integer> magazineMap = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> notemap = new LinkedHashMap<>();

		for (String each : magazineWords) {
			Integer count = magazineMap.get(each);
			if (count == null) {
				count = 0;
			}
			count++;
			magazineMap.put(each, count);
		}

		for (String each : noteWords) {
			Integer count = notemap.get(each);
			if (count == null) {
				count = 0;
			}
			count++;
			notemap.put(each, count);
		}

		
		BiConsumer<String, Integer> biConsumer = (key, value) -> {
			if (magazineMap.get(key) == value) {
				count++;
			}
		};

		notemap.forEach(biConsumer);
		return count == notemap.size();
	}
}
