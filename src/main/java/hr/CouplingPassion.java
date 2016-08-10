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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class CouplingPassion {

	static Set<String> ps = new HashSet<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = Integer.parseInt(scanner.nextLine());
			String[] p = new String[n];
			Guest[] g = new Guest[n];
			for (int i = 0; i < n; i++) {
				g[i] = new Guest(scanner.nextLine());
			}

			int y = Integer.parseInt(scanner.nextLine());
			Destination[] d = new Destination[y];
			for (int i = 0; i < y; i++) {
				d[i] = new Destination(scanner.nextLine());
			}
			Arrays.sort(d);
			String[] names = new String[2];
			if (d[y - 1].mc == d[y - 2].mc) {
				names[0] = d[y - 1].name;
				names[1] = d[y - 2].name;
				Arrays.sort(names);
				System.out.println(names[0] + "  " + names[1]);
			} else {
				System.out.println(d[y - 1].name + "  " + d[y - 2].name);
			}

		}

	}

	static class Destination implements Comparable<Destination> {
		/**
		 * @param nextLine
		 */
		public Destination(String nextLine) {
			String[] v = nextLine.split(" ");
			name = v[0];
			latitude = Float.parseFloat(v[1]);
			longitude = Float.parseFloat(v[2]);
			passions = new ArrayList<>();
			for (int i = 3; i < v.length; i++) {
				passions.add(v[i]);
				if (ps.contains(v[i])) {
					mc++;
				}
			}
		}

		String name;
		float latitude;
		float longitude;
		int np;
		int mc;
		List<String> passions;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Destination o) {
			if (mc > o.mc) {
				return 1;
			} else if (mc < o.mc) {
				return -1;
			}
			return 0;
		}

	}

	static class Guest {
		/**
		 * @param nextLine
		 */
		public Guest(String nextLine) {
			String[] v = nextLine.split(" ");
			np = Integer.parseInt(v[0]);
			passions = new ArrayList<>();
			for (int i = 1; i < v.length; i++) {
				passions.add(v[i]);
				ps.add(v[i]);
			}
		}

		// number of passions that the guest has
		int np;
		// list of passions
		List<String> passions;
	}

}
