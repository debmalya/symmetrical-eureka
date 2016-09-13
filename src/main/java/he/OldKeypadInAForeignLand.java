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
package he;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Some people remain old fashioned and John is one of them. He doesn't like the
 * new smart phones with full keypads and still uses the old keypads which
 * require you to tap a key multiple times to type a single letter. For example,
 * if the keyboard has two keys, one with the letters "adef" and the other one
 * with the letters "zyx", then typing 'a' requires one keystroke, typing 'f'
 * requires four keystrokes, typing 'y' requires two keystrokes, and so on.
 * 
 * He recently moved to a new country where the language is such that his keypad
 * is not the most efficient. In every language some characters occur more often
 * than others. He wants to create a specific keyboard for this language that
 * uses N different letters. He has a large body of text in this language, and
 * has already analyzed it to find the frequencies of all N letters of its
 * alphabet.
 * 
 * You are given an array 'frequencies' with N elements. Each element of
 * frequencies is the number of times one of the letters in the new language
 * appears in the text John has. Each element of frequencies will be strictly
 * positive. (I.e., each of the N letters occurs at least once.)
 * 
 * You are also given an array keySize. The number of elements of keySize is the
 * number of keys on the keyboard. Each element of keySize gives the maximal
 * number of letters that maybe put on one of the keys.
 * 
 * Find an assignment of letters to keys that minimizes the number of keystrokes
 * needed to type the entire text. Output that minimum number of keystrokes. If
 * there is not enough room on the keys and some letters of the alphabet won't
 * fit, Output -1 instead.
 * 
 * @author debmalyajash
 *
 */
public class OldKeypadInAForeignLand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// The first line will contain a number 'N' that specifies the size
			// of 'frequencies' array
			int N = in.nextInt();

			// The second line will contain N numbers that form the frequencies
			// array
			int[] frequencies = new int[N];
			for (int i = 0; i < N; i++) {
				frequencies[i] = in.nextInt();
			}
			Arrays.sort(frequencies);

			// The third line contains a number 'K' that specifies the size of
			// the 'keySize' array
			int K = in.nextInt();

			// The fourth line contains K numbers that form the keySize array
			int[] key = new int[K];
			int totalNumberOfKeys = 0;
			for (int i = 0; i < K; i++) {
				key[i] = in.nextInt();
				totalNumberOfKeys += key[i];
			}

			if (totalNumberOfKeys < N) {
				System.out.println("-1");
				return;
			}
			System.out.println(getKeyStrokeCount(N, frequencies, K, key));
		}
	}

	/**
	 * @param N - number of letters
	 * @param frequencies of each letter.
	 * @param K - number of keys
	 * @param key - how many character each key can hold.
	 */
	public static int getKeyStrokeCount(int N, int[] frequencies, int K, int[] key) {

		Arrays.sort(frequencies);

		int c = 0;
		int l = 1;
		// Assigning most frequent keys (first keys).
		int i = N - 1;
		int keyIndex = 0;
		for (; i > -1; i--, keyIndex++) {
			
			if (keyIndex >= K) {
				// Reusing keypads
				l++;
			}
			keyIndex %= K;
			// Can this keypad hold the key?
			if (key[keyIndex] > 0) {
				c += (frequencies[i] * l);
				key[keyIndex]--;

			} else {
				// This key cannot hold any more letter.
				// Check next available key.
				// Not able to assign this letter.
				// The value i will not be decremented.
				i++;
			}

		}

		return c;
	}
	public static int getKeyStrokeCount0(int N, int[] frequencies, int K, int[] key) {

		Arrays.sort(frequencies);

		int c = 0;
		int l = 1;
		for (int i = N - 1; i > 0; i -= K, l++) {
			for (int j = 0; j < K; j++) {
				c += frequencies[i - j] * l;
			}
		}
		return c;
	}

}
