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
package hr;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;

/**
 * @author debmalyajash
 *
 */
public class Trial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = new String[2];
		names[0] = "Jash";
		names[1] = "Debmalya";
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		LocalDateTime ldt1 = LocalDateTime.of(2016, 6, 15, 12, 0);
		LocalDateTime ldt2 = LocalDateTime.of(2016, 7, 15, 12, 0);
		Calendar c1 = Calendar.getInstance();
		c1.set(2016, Calendar.JUNE, 15, 12, 0, 0);
		Calendar c2 = Calendar.getInstance();
		c2.set(2016, Calendar.JULY, 15, 12, 0, 0);
		
		

	}

}
