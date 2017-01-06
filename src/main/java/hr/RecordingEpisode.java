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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class RecordingEpisode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int q = in.nextInt();
			for (int i = 0; i < q; i++){
				int[] arr = new int[4];
				for (int j = 0; j < 4; j++){
					arr[0] = in.nextInt();
					arr[1] = in.nextInt();
					arr[2] = in.nextInt();
					arr[3] = in.nextInt();
				}
			}
			
		}

	}
	
	public static class Season {
		List<Show> showList = new ArrayList<>();
		
		public void addShow(Show show){
			showList.add(show);
		}
		
	}
	public static class Show {
		boolean repeat;
		int start;
		int end;
	}

}
