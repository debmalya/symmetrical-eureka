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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Trigram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			StringBuilder sb = new StringBuilder();
			while (in.hasNextLine()){
				sb.append(in.nextLine());
			}
			
			getMostFrequeneTrigram(sb);
			
		}

	}

	/**
	 * @param sb
	 */
	public static void getMostFrequeneTrigram(StringBuilder sb) {
		String input = sb.toString();
		input = input.replace("\\n", " ");
		input = input.toLowerCase();
		String[] allWords = input.split(" ");
		List<Tri> triList = new ArrayList<>();
		for (int i = 0; i < allWords.length -2; i++){
			Tri tri = new Tri(allWords[i]+" "+allWords[i+1]+" "+allWords[i + 2]);
			int index = triList.indexOf(tri);
			if (index == -1){
				tri.frequency = 1;
				triList.add(tri);
			} else {
				tri = triList.get(index);
				tri.frequency++;
				triList.set(index, tri);
			}

			
		}
		
		Collections.sort(triList);
		System.out.println(triList.get(triList.size() - 1));
	}

	static class Tri implements Comparable<Tri>{
		String threeWords;
		int frequency;
		
		
		/**
		 * @param string
		 */
		public Tri(String string) {
			threeWords = string;
		}


		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Tri o) {
			if (frequency > o.frequency){ 
				return 1;
			} else if (frequency < o.frequency){ 
				return -1;
			}
			return 0;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((threeWords == null) ? 0 : threeWords.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tri other = (Tri) obj;
			if (threeWords == null) {
				if (other.threeWords != null)
					return false;
			} else if (!threeWords.equals(other.threeWords))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return threeWords;
		}
		
		
	}
}
