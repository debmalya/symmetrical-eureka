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
package cf;

import java.math.BigInteger;

/**
 * @author debmalyajash
 *
 */
public class StoryOfByte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	String ComputerUnitsToByte(int capacity, String unit) {
		BigInteger b = new BigInteger("1024");
		BigInteger v = new BigInteger("" + capacity);
		String[] u = new String[] { "KB", "MB", "G", "TB", "P" };
		for (int i = 0; i < u.length; i++) {
			v = v.multiply(b);
			if (u[i].equals(unit)){
				break;
			}
		}

		return v.toString();
	}

	String ComputerUnitsToByte1(int capacity, String unit) {
		BigInteger b = new BigInteger("1024");
		BigInteger v = new BigInteger("" + capacity);
		if ("KB".equals(unit)) {
			return b.multiply(v).toString();
		}
		if ("MB".equals(unit)) {
			return b.multiply(v).multiply(b).toString();
		}
		if ("G".equals(unit)) {
			return b.multiply(v).multiply(b).multiply(b).toString();
		}
		if ("TB".equals(unit)) {
			return b.multiply(v).multiply(b).multiply(b).multiply(b).toString();
		}
		if ("P".equals(unit)) {
			return b.multiply(v).multiply(b).multiply(b).multiply(b)
					.multiply(b).toString();
		}
		return "";
	}

	String ComputerUnitsToByte0(int capacity, String unit) {
		if (unit.equals("KB"))
			return "" + (capacity * 1024);
		if (unit.equals("MB"))
			return "" + (capacity * 1048576);
		if (unit.equals("G"))
			return "" + (capacity * 1073741824);
		if (unit.equals("TB"))
			return "" + (capacity * 1099511627776L);
		if (unit.equals("P"))
			return "" + (capacity * 1125899906842624L);
		return "";
	}

}
