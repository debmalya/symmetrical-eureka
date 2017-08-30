/**
 * Copyright 2015-2017 Debmalya Jash
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
package Equinix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class SingaporeMappleTree {

	/**
	 * They asked me to find the first repeating word from a sentence.
	 * @param sentence to processed.
	 * @return first repeating word.
	 */
	public String getFirstRepeatingWord(final String sentence) {
		if (sentence == null) {
			return "";
		}
		String[] words = sentence.split( "\\s+" );
		Set<String> unique = new HashSet<>();
		for (String eachWord: words) {
			String converted = eachWord.toLowerCase();
			if (!unique.add( converted )) {
				return eachWord;
			}
		}
		return "";
	}
}
