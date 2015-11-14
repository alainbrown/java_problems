import java.util.*;

//Given an int array which might contain duplicates, 
//find the largest subset of it which form a sequence. 
//Eg. {1,6,10,4,7,9,5} 
//then ans is 4,5,6,7 
//
//Sorting is an obvious solution. Can this be done in O(n) time
public class LargestSequence {

	// Space: O(n)
	// Complexity: O(n)
	public static List<Integer> largestSequence(int[] arr) {
		
		List<Integer> maxSeq = new LinkedList<>();
		Map<Integer, Integer> visits = new HashMap<>();
		for (int i : arr) {
			if (visits.containsKey(i)) visits.put(i, visits.get(i)+1);
			else visits.put(i,1);
		}
		for (int i : arr) {
			if (visits.get(i) > 0) {
				List<Integer> seq = new LinkedList<>();
				seq.add(i);
				for (int j=i+1; visits.containsKey(j) && visits.get(j)>0; j++) {
					seq.add(j);
					visits.put(j, visits.get(j)-1);
				}
				for (int j=i-1; visits.containsKey(j) && visits.get(j)>0; j--) {
					seq.add(j);
					visits.put(j, visits.get(j)-1);
				}
				if (seq.size()>maxSeq.size()) maxSeq = seq;
			}
		}
		return maxSeq;
	}

	public static void main(String[] args) {
		int [] arr = {1,6,10,4,6,10,5,4,7,9,5};
		System.out.println(largestSequence(arr));
	}
}
