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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class SentenceSegmentation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			StringBuilder allEntries = new StringBuilder();
			while (in.hasNextLine()){
				allEntries.append(in.nextLine());
			}
			
			List<String> allLines = getAllSentences(allEntries.toString());
			
			for (String eachLine : allLines){
				System.out.println(eachLine);
			}
			
		}
	}

	public static List<String> getAllSentences(String paragraph) {
		List<String> reservedWords = Arrays.asList(new String[] { "Mr.", "Mrs.", "Dr.","Ms." });
		String[] words = paragraph.split(" ");
		StringBuilder eachLine = new StringBuilder();
		List<String> allLines = new ArrayList<>();
		for (String eachWord:words){
			eachLine.append(eachWord);
			eachLine.append(" ");
			if (eachWord.endsWith(".") && !reservedWords.contains(eachWord) || eachWord.endsWith("?") || eachWord.endsWith("!")){
				allLines.add(eachLine.toString());
				eachLine.delete(0, eachLine.length());
				
			} 
		}
		return allLines;
	}
}
