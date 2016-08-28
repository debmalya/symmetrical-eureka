package he.ittiam.think;

import java.util.Arrays;
import java.util.Scanner;

public class PokeTravel {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int d = in.nextInt();
			int k = in.nextInt();
			SpecialPath[] sps = new SpecialPath[k];
			for (int i = 0; i < k; i++){
				int u = in.nextInt();
				int v = in.nextInt();
				int w = in.nextInt();
				sps[i] = new SpecialPath(u,v,w);
			}
			
			Arrays.sort(sps);
		}

	}
	
	static class SpecialPath implements Comparable<SpecialPath>{
		int u;
		int v;
		int w;
		public SpecialPath(int u2, int v2, int w2) {
			u = u2;
			v = v2;
			w = w2;
		}
		@Override
		public int compareTo(SpecialPath o) {
			if (w > o.w){
				return 1;
			} else if (w < o.w){
				return -1;
			}
			return 0;
		}
		
	}

}
