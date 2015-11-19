package java_problems;

import java.util.Arrays;

public class MinDigitSum {
	
	// Complexity: O(n logn)
	// Space: O(n)
	public static int minSum(int[] arr){
		Arrays.sort(arr);
		int leftSize = arr.length/2 + arr.length % 2;
		int rightSize = arr.length/2;
		boolean check = true;
		int l=0;
		int r=0;
		for (int i=0;i<arr.length; i++) {
			if (check) l+= Math.pow(10, --leftSize)*arr[i];
			else r+= Math.pow(10, --rightSize)*arr[i];
			check=!check;
		}
		return l+r;
	}

	public static void main(String[] args) {
		System.out.println(minSum(new int[]{2,1,5,3,7,9,11,4}));
	}

}
