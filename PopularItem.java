//Find popular item in sorted array of natural numbers. 
//An item is popular is if its repeated n/4 times or more. 
//For Ex: 
//Input: 123444445678 
//Popular item is 4. 

public class PopularItem {
	
	// Complexity: O(d log n) arr of length n, item at least n/d times
	// Space: O(1)
	// for d=4
	// Complexity: O(log n)
	// Space: O(1)
	public static int popular(int[]arr, int d) {
		int p = arr[0];
		int n = arr.length;
		int start = n/d;
		int popularity = 0;
		for (int i=start; i<n; i+=start) {
			int newPop = findLast(arr,arr[i]) - findFirst(arr,arr[i]);
			if (newPop>popularity) {
				popularity=newPop;
				p=i;
			}
		}
		return arr[p];
	}
	
	static int findFirst(int[] arr, int num) {
		int top = arr.length-1;
		int bottom = 0;
		int mid = 0;

		while (top>=bottom) {
			mid = (top+bottom)/2;
			if (arr[mid] < num) bottom = mid+1;
			else if (arr[mid] >= num) {
				top = mid-1;
				if (arr[top] ==num) return top;
			}
		}
		return mid;
	}
	
	static int findLast(int[] arr, int num) {
		int top = arr.length-1;
		int bottom = 0;
		int mid = 0;

		while (top>=bottom) {
			mid = (top+bottom)/2;
			if (arr[mid] <= num) bottom = mid+1;
			else if (arr[mid] > num) {
				top = mid-1;
				if (arr[top] ==num) return top;
			}
		}
		return mid;
	}

	public static void main(String[] args) {
		System.out.println(popular(new int[]{1,2,2,2,2,3,4,5,5,5,5,5,6,6,6,6,7,8},4));
		System.out.println(popular(new int[]{1,2,2,2,2,3,4,4,4,4,4,4,5,6,6,6,6,7,8},4));
	}

}
