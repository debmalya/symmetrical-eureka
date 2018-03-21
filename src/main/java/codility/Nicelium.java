package codility;

public class Nicelium {

	public static int solution(boolean[] P) {
		long result = 0;

		if (P != null) {
			
			if (P.length == 1 && P[0]){
				return 1;
			} else if (P.length == 1 && !P[0]){
				return 0;
			} else {
				boolean[] P1 = new boolean[P.length -1];
				if (P[0]){
					result++;
				}
				for (int i = 1; i < P.length; i++){
					if (P[i]){
						if (result == 999999999 || result == Long.MAX_VALUE) {
							result = 1000000000;
						}
						result++;
					}
					P1[i - 1] = P[i-1] || P[i];
				}
				
				
				return (int)result + solution(P1);
			}

			
		}

		return (int) result;
	}


}
