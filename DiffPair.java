import java.util.*;

//# Given an array of positive, unique, increasingly sorted numbers A, 
//# e.g. A = [1, 2, 3, 5, 6, 8, 9, 11, 12, 13]. 
//# Given a positive value K, e.g. K = 3. Output all pairs in A that differ exactly by K. 
//# e.g. 
//# 2, 5 
//# 3, 6 
//# 5, 8 
//# 6, 9 
//# 8, 11 
//# 9, 12 
//# what is the runtime for your code?
		
public class DiffPair {

	// Complexity: O(n)
	// Space: O(1)
	public static List<int[]> diffPairs(int k, int[]A) {
		List<int[]> ans = new LinkedList<>();
		if (A.length<2) return ans;
		int start =0;
		int end=1;
		while (start<end && end <A.length-1) {
			if (A[end]-A[start] == k) {
				ans.add(new int[]{A[start],A[end]});
				start++;
			}
			else if((A[end]-A[start]) <k) end++;
			else start++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		for (int[] pair: diffPairs(3, new int[] {1, 2, 3, 5, 6, 8, 9, 11, 12, 13})) {
			System.out.print(pair[0]);
			System.out.print(",");
			System.out.println(pair[1]);
		}
	}
}
