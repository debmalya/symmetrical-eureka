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
package hr.weekOfCode34;

import java.util.Scanner;

public class OnceInATram {

    public static String onceInATram(int x) {
        // Complete this function
    	x++;
    	while (!isMagic(x)) {
    		x++;
    	}
    	
    	return ""+x;
    }
    
    

    /**
	 * @param x
	 * @return
	 */
	public static boolean isMagic(int x) {
		int f = x / 1000;
		int l = x % 1000;
		
		return sum(f) == sum(l);
	}



	/**
	 * @param f
	 * @return
	 */
	public static int sum(int f) {
		int sum  = 0;
		while (f > 0) {
			sum += f %10;
			f /= 10;
		}
		return sum;
	}



	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}

