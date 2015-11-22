import java.util.*;

// Given two arrays A [n] and B[m], find the smallest window in
// A that contains all the elements of B.

public class SmallestWindow {
	
	// Complexity: O(n) n elements in A
	// Space: O(m) m elements in B
	public static int[] smallestWindow(int[] A, int[] B) {
		
		HashMap<Integer,Integer> bElements = new HashMap<>();
		HashMap<Integer,Integer> window = new HashMap<>();
		HashSet<Integer> complete = new HashSet<>();
		int [] minRange = new int [] {0, A.length-1};
		int front = 0; int back = 0;
		boolean solution = false;
		
		for (int i : B) {
			if (bElements.containsKey(i)) bElements.put(i, bElements.get(i)+1);
			else bElements.put(i,1);
			window.put(i,0);
		}
		
		while(back+1<A.length || complete.size() == bElements.size()) {
			if (complete.size() == bElements.size()) {
				if (back-front < minRange[1]-minRange[0]) {
					minRange[0] = front;
					minRange[1] = back;
					solution = true;
				}
				if (bElements.containsKey(A[front])) {
					if (window.get(A[front])>0) 
						window.put(A[front], window.get(A[front])-1);
					if (window.get(A[front])!=bElements.get(A[front])) 
						complete.remove(A[front]);
				}
				front++;
			} else if (back+1<A.length) {
				back++;
				if (bElements.containsKey(A[back])) {
					window.put(A[back], window.get(A[back])+1);
					if (window.get(A[back]).equals(bElements.get(A[back]))) 
						complete.add(A[back]);					
				}
			}
		}
		return solution ? minRange : new int [] {-1,-1};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				smallestWindow(new int []{3,1,7,8,2,8,10,4,11,8,7}, new int []{7,8,8,4})));
		System.out.println(Arrays.toString(
				smallestWindow(new int []{3,1,7,8,2,8,10,4,11,8,7}, new int []{7,8,88,4})));
	}
}
