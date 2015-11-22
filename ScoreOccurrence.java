// Given a sorted array which contains scores range from 0 to 100. 
// Write a program to find occurrence of given score. 
// eg. 1,1,1,40,40,40,100,100 
// input: 40 
// o/p : 3 (as 40 appear 3 times in array)

public class ScoreOccurrence {

	// Complexity: O(log n)
	// Space: O(1)
	public static int occurrence(int[] arr, int score) {
		int last = lastIndex(arr, score);
		int first = firstIndex(arr, score);
		return (last>=0 && last==first) ? 1 : last-first;
	}

	static int firstIndex(int[] arr, int score) {
		int bottom = 0;
		int top = arr.length - 1;
		int mid = -1;
		boolean found = false;
		
		while (top >= bottom) {
			mid = (top + bottom) / 2;
			if (arr[mid]==score) found = true;
			if (arr[mid] >= score) top = mid - 1;
			else if (arr[mid] < score) {
				bottom = mid + 1;
				if (arr[mid]==score) return mid;
			}
		}
		return found ? mid : -1;
	}

	static int lastIndex(int[] arr, int score) {
		int bottom = 0;
		int top = arr.length - 1;
		int mid = -1;
		boolean found = false;
		
		while (top >= bottom) {
			mid = (top + bottom) / 2;
			if (arr[mid]==score) found = true;
			if (arr[mid] <= score) bottom = mid + 1;
			else if (arr[mid] > score) {
				top = mid - 1;
				if (arr[mid]==score) return mid;
			}
		}
		return found ? mid : -1;
	}

	public static void main(String[] args) {
		System.out.println(occurrence(new int[]{0,1,10,10,10,10,20,30},7));
		System.out.println(occurrence(new int[]{0,1,10,10,10,10,20,30},10));
		System.out.println(occurrence(new int[]{0,1,10,10,10,10,20,30},30));
	}

}
