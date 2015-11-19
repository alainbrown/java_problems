import java.util.Arrays;

public class MinDigitSum {

	// Complexity: O(n log n)
	// Space: O(n)
	public static int minSum(int[] arr) {
		Arrays.sort(arr);
		int leftSize = arr.length/2 + arr.length % 2;
		int rightSize = arr.length/2;
		int sum = 0;
		for (int i=0;i<arr.length; i++) {
			if (i%2==0) sum+= Math.pow(10, --leftSize)*arr[i];
			else sum+= Math.pow(10, --rightSize)*arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(minSum(new int[]{2,1,5,3,7,9,11,4}));
	}
}
