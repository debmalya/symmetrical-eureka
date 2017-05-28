/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class WordLadder {
	/**
	 * Given two words, beginWord and endWord, and a wordList of approved words,
	 * find the length of the shortest transformation sequence from beginWord to
	 * endWord such that:
	 * 
	 * Only one letter can be changed at a time Each transformed word must exist
	 * in the wordList. Return the length of the shortest transformation
	 * sequence, or 0 if no such transformation sequence exists.
	 * 
	 * Note: beginWord does not count as a transformed word. You can assume that
	 * beginWord and endWord are not empty and are not the same.
	 * 
	 * Example
	 * 
	 * For beginWord = "hit", endWord = "cog", and wordList = ["hot", "dot",
	 * "dog", "lot", "log", "cog"], the output should be wordLadder(beginWord,
	 * endWord, wordList) = 5.
	 * 
	 * The shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog"
	 * with a length of 5.
	 * 
	 * Input/Output
	 * 
	 * [time limit] 3000ms (java) [input] string beginWord
	 * 
	 * Guaranteed constraints: 1 ≤ beginWord.length ≤ 5.
	 * 
	 * [input] string endWord
	 * 
	 * Guaranteed constraints: endWord.length = beginWord.length.
	 * 
	 * [input] array.string wordList
	 * 
	 * An array containing all of the approved words. All words in the array are
	 * the same length and contain only lowercase English letters. You can
	 * assume that there are no duplicates in wordList.
	 * 
	 * Guaranteed constraints: 2 ≤ wordList.length ≤ 600, wordList[i].length =
	 * beginWord.length.
	 * 
	 * [output] integer
	 * 
	 * An integer representing the length of the shortest transformation
	 * sequence from beginWord to endWord using only words from wordList as
	 * described above.
	 * 
	 * @param beginWord
	 *            word to begin with.
	 * @param endWord
	 *            final changed word.
	 * @param wordList
	 *            list of words can be used for the conversion.
	 * @return number of conversions required to reach from begin word to end
	 *         word changing one letter at a time.
	 */
	public int wordLadder(String beginWord, String endWord, String[] wordList) {
		// Initial difference between begin word and end word
		int initialDiff = difference(beginWord, endWord);

		String[] fromStart = new String[wordList.length];
		fromStart[initialDiff] = endWord;

		String[] fromEnd = new String[wordList.length];
		fromEnd[initialDiff] = beginWord;

		for (int i = 0; i < wordList.length; i++) {
			int diffFromStart = difference(beginWord, wordList[i]);
			int diffFromEnd = difference(endWord, wordList[i]);
			boolean additionOK = true;

			if (diffFromStart < fromStart.length) {
				if (fromStart[diffFromStart] != null) {
					
					if (!fromStart[diffFromStart].contains(wordList[i])){
					fromStart[diffFromStart] += "|";
					} else {
						additionOK = false;
					}
				} else {
					fromStart[diffFromStart] = "";
				}
				if (additionOK) {
					fromStart[diffFromStart] += wordList[i];
				}
			}

			if (diffFromEnd < fromEnd.length) {
				additionOK = true;
				if (fromEnd[diffFromEnd] != null) {
					if (!fromEnd[diffFromEnd].contains(wordList[i])) {
						fromEnd[diffFromEnd] += "|";
					} else {
						additionOK = false;
					}
				} else {
					fromEnd[diffFromEnd] = "";
				}
				if (additionOK) {
					fromEnd[diffFromEnd] += wordList[i];
				}
			}
		}

		return 0;
	}

	/**
	 * How many characters are different in word1 and word2?
	 * 
	 * @param word1
	 *            first word
	 * @param word2
	 *            second word
	 * @return number of characters different.
	 */
	public int difference(String word1, String word2) {
		int result = Math.abs(word1.length() - word2.length());
		int minLength = Math.min(word1.length(), word2.length());

		for (int i = 0; i < minLength; i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				result++;
			}
		}
		return result;
	}
	
	/**
	 * Give shortest possible conversion path. Different between two consecutive word in only one letter.
	 * @param beginWord starting word.
	 * @param endWord ending word.
	 * @param wordList possible possible words at each conversion stage.
	 * @return minimum number of word required for the conversion.
	 * 
	 * Example :
	 * beginWord : hit
	 * endWord: cog
	 * wordList : [cog, dog|log, hot|dot|lot, hit, null, null]
	 * Possible paths 
	 * cog->dog->dot->hot->hit
	 * cog->dog->dot->lot->hot->hit
	 * cog->log->dog->dot->hot->hit
	 * cog->log->lot->hot->hit
	 * 
	 * It will return the shortest one cog->dog->dot->hot->hit, answer is 5.
	 */
	public int getPossiblePath(String beginWord,String endWord,String[] wordList){
		return 0;
	}

}
