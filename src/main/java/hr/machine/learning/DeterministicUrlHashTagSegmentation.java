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
package hr.machine.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

/**
 * @author debmalyajash
 *
 */
public class DeterministicUrlHashTagSegmentation {
	private static List<String> wordList = new ArrayList<>();
	private static List<String>[] alphabetWiseWordList = new ArrayList[26];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setWordList();

		try (Scanner in = new Scanner(System.in)) {
			// First line will contain the number of test cases N
			int N = in.nextInt();
			in.nextLine();
			String[] result = new String[N];
			for (int i = 0; i < N; i++) {
				result[i] = getSegmenetation(in.nextLine());
			}

			for (int i = 0; i < N; i++) {
				System.out.println(result[i]);
			}
		}

	}

	/**
	 * 
	 */
	public static void setWordList() {
		try (BufferedReader read = new BufferedReader(new FileReader("words.txt"))) {
			String eachLine = "";
			while ((eachLine = read.readLine()) != null) {
				eachLine = eachLine.toLowerCase();
				char c = eachLine.charAt(0);
				int index = c - 'a';
				if (index > -1 && index < 26) {
					if (alphabetWiseWordList[index] == null) {
						alphabetWiseWordList[index] = new ArrayList<String>();
					}
					alphabetWiseWordList[index].add(eachLine);
				} else {
					System.err.println(c + " has index " + index);
				}
				wordList.add(eachLine);
			}
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}

	/**
	 * @param nextLine
	 * @return
	 */
	public static String getSegmenetation1(final String nextLine) {
		String modifiedLine = "";
		if (nextLine.startsWith("#")) {
			modifiedLine = nextLine.replace("#", "");
		} else {
			modifiedLine = nextLine.substring(nextLine.indexOf(".") + 1);
			modifiedLine = modifiedLine.substring(0, modifiedLine.indexOf("."));
		}
		List<String> matchedWords = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		modifiedLine = modifiedLine.toLowerCase();
		while (true) {
			char c = modifiedLine.charAt(0);
			int index = c - 'a';
			for (int i = 0; i < alphabetWiseWordList[index].size(); i++) {
				if (modifiedLine.startsWith(alphabetWiseWordList[index].get(i))) {
					matchedWords.add(alphabetWiseWordList[index].get(i));
					modifiedLine = modifiedLine.replace(alphabetWiseWordList[index].get(i), "");
					sb.append(alphabetWiseWordList[index].get(i));
					sb.append(" ");
					i = 0;
				}
			}

			if (modifiedLine.length() == 0) {
				break;
			}
		}

		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * @param nextLine
	 * @return
	 */
	public static String getSegmenetation(final String nextLine) {
		String modifiedLine = "";
		if (nextLine.startsWith("#")) {
			modifiedLine = nextLine.replace("#", "");
		} else {
			modifiedLine = nextLine.substring(nextLine.indexOf(".") + 1);
			modifiedLine = modifiedLine.substring(0, modifiedLine.indexOf("."));
		}
		List<String> matchedWords = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < wordList.size(); i++) {
			if (modifiedLine.startsWith(wordList.get(i))) {
				matchedWords.add(wordList.get(i));
				modifiedLine = modifiedLine.replace(wordList.get(i), "");
				sb.append(wordList.get(i));
				sb.append(" ");
				i = 0;
			}
		}
		return sb.toString();
	}

	/**
<<<<<<< HEAD
	 * @return the wordList
	 */
	public static List<String> getWordList() {
		return wordList;
	}

	/**
	 * @param wordList the wordList to set
	 */
	public static void setWordList(List<String> wordList) {
		DeterministicUrlHashTagSegmentation.wordList = wordList;
	}
	/**
	 * @return the alphabetWiseWordList
	 */
	public static List<String>[] getAlphabetWiseWordList() {
		return alphabetWiseWordList;

	}

}
