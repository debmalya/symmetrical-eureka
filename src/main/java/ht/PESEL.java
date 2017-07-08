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
package ht;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class PESEL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int t = in.nextInt();
			long[] a = new long[t];
			char[] ans = new char[t];
			for (int i = 0; i < t; i++){
				a[i] = in.nextLong();
				ans[i] = getAnswer(a[i]);
			}
			
			
			for (int i = 0; i < t; i++){
				System.out.println(ans[i]);
			}
			
			
		}

	}

	/**
	 * @param i
	 * @return
	 */
	private static char getAnswer(long i) {
		long a = 0;
		int count = 0;
		long divisor = 10000000000L;
		while (i > 0){
			long d = i/divisor;
			switch(count){
			case 0:
			case 4:
			case 8:
			case 10:
				a += d;
				break;
			case 1:
			case 5:
			case 9:
				a+= 3*d;
				break;
			case 2:
			case 6:
				a+= 7*d;
				break;
			case 3:
			case 7:
				a+= 9*d;
				break;
			
			}
			count++;
			i = i%divisor;
			divisor = divisor/10;
		}
		return a%10==0?'Y':'N';
	}

}
