package hr;

/**
 * the maximum subarray problem is the task of finding the contiguous subarray
 * within a one-dimensional array of numbers which has the largest sum.
 * 
 * @author debmalyajash
 *
 *         Reference : https://en.wikipedia.org/wiki/Maximum_subarray_problem
 */
public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

	public static int maxSubArray(int[] arr){
		int maxEndingHere = 0;
		int maxSoFar = 0;
		for (int i = 0; i < arr.length; i++){
			maxEndingHere = Math.max(0, maxEndingHere + arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
