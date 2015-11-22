// Given an unsorted array of nonnegative integers, 
// find the number of continous subarray which adds to a given number.
public class SubarraySum {
	
	// Complexity: O(n)
	// Space: O(1)
	public static int subarraySum(int[] arr, int sum){
		int current = arr[0], front=0, count=0;
		for (int back=1;back<=arr.length;back++) {
			while (current>sum && front<back-1) current -=arr[front++];
			if (current == sum)	count++;
			if (back<arr.length) current += arr[back];
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[]{15,2,4,8,9,5,10,23},23));
	}
}
