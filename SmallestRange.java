import java.util.PriorityQueue;

//You have k lists of sorted integers. Find the smallest range that 
//includes at least one number from each of the k lists. 
//
//For example, 
//List 1: [4, 10, 15, 24, 26] 
//List 2: [0, 9, 12, 20] 
//List 3: [5, 18, 22, 30] 
//
//The smallest range here would be [20, 24] as it contains 24 from 
//list 1, 20 from list 2, and 22 from list 3.

public class SmallestRange {

	static class V implements Comparable<V> {
		int val, row, col;
		V(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
		public int compareTo(V o) {return Integer.compare(this.val, o.val);}
	}
	
	// Complexity: O(m*nlog(n)) n lists of m elements
	// Space: O(n)
	public static int[] range(int[][] m) {
		PriorityQueue<V> h = new PriorityQueue<>();
		int[] ans = new int[2];
		for (int r = 0; r < m.length; r++) {
			if (m[r].length > 0) {
				h.offer(new V(m[r][0], r, 0));
				ans[0] = Math.min(m[r][0], ans[0]);
				ans[1] = Math.max(m[r][0], ans[1]);
			}
		}
		int max = ans[1];
		while (!h.isEmpty()) {
			V v = h.poll();
			if (max - v.val < ans[1] - ans[0]) {
				ans[0] = v.val;
				ans[1] = max;
			}
			if (v.col + 1 < m[v.row].length) {
				h.offer(new V(m[v.row][v.col + 1], v.row, v.col + 1));
				max = Math.max(max, m[v.row][v.col + 1]);
			} else break;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] M = { 
				{ 4, 10, 15, 24, 26 }, 
				{ 0, 9, 12, 20 }, 
				{ 5, 18, 22, 30 }, 
				};
		int[] range = range(M);
		System.out.println(range[0]);
		System.out.println(range[1]);
	}
}
