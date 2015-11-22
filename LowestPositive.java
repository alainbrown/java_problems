// Given an array of integers (positive or negative) 
// find the lowest positive integer NOT present in that array.

public class LowestPositive {

	// Complexity: O(n)
	// Space: O(1)
	public static int lowestPositive(int [] arr) {
		int lowest = Integer.MAX_VALUE;
		for (int i: arr) if (i>0 && i<lowest) lowest=i;
		return lowest;
	}
	
	public static void main(String[] args) {
		System.out.println(lowestPositive(new int[]{-1,-10,30,7,300,1,1000,-20}));
	}
}
