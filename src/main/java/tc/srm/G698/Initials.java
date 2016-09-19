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
package tc.srm.G698;

/**
 * @author debmalyajash
 *
 */
public class Initials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getInitials(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] tokens = name.split("\\s+");
		for (String t : tokens) {
			stringBuilder.append(t.charAt(0));
		}
		return stringBuilder.toString();
	}
	
	public String getInitials0(String name){
		String[] n = name.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String e:n){
			sb.append(e.charAt(0));
		}
		return sb.toString();
    }

}
