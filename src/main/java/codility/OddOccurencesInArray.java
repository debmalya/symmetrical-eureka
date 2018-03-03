package codility;

import java.util.Arrays;

public class OddOccurencesInArray {
	
	public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int prev = A[0];
        int r = A[0];
        int count = 1;
        boolean broken = false;
        for (int i = 1; i < A.length; i++){
        	if (prev == A[i]){
        		count++;
        	} else {
        		if (count%2==1){
        			r = prev;
        			broken=true;
        			break;
        		}
        		count = 1;
        	}
        	prev=A[i];
        }
        if (!broken && count%2==1){
        	r = A[A.length - 1];
        }
        return r;
    }

}
