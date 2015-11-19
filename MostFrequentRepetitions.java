
//Given a sorted array of integers, write a function that 
//will return the number with the biggest number of repetitions. 
//(Asked to refine the solution to be more efficient)

public class MostFrequentRepetitions {

	//Complexity: O(n)
	//Space: O(1)
	public static int most(int[] arr) {
		int most = arr[0];
		int highCount = 1;
		int count = highCount;
		int last = most;

		for (int i = 1; i < arr.length; i++) {
			if (last == arr[i]) count++;
			else count = 0;
			if (count > highCount) {
				most = arr[i];
				highCount = count;
			}
			last = arr[i];
		}
		return most;
	}

	public static void main(String[] args) {
		System.out.println(most(new int[]{2,4,4,5,5,5,6,7,8,9}));
	}

}
