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

/**
 * @author debmalyajash
 *
 */
class A1 {
	public int i;
	protected int j;
}

class B2 extends A1 {
	int j;

	void display() {
		super.j = 3;
		super.i = 10;
		System.out.println(i + " " + j);
	}
}

public class OutputClass {
	public static void main(String args[]) {
		B2 obj = new B2();
		obj.i = 1;
		obj.j = 2;
		obj.display();
	}
}
