import java.util.PriorityQueue;

//Given a N*N Matrix. 
//All rows are sorted, and all columns are sorted. 
//Find the Kth Largest element of the matrix.

public class KthLargestInSortedMatrix {
	
	private static class V<E extends Comparable<E>> implements Comparable<V<E>> {
		E val; int row,col;
		private V(E val,int row,int column){
			this.val=val;
			this.row=row;
			this.col=column;
		}
		public int compareTo(V<E> o) { return this.val.compareTo(o.val); }
	}

	// Complexity: O(k*log(n)) n rows, kth largest
	// Space: O(n)
	public static <E extends Comparable<E>> E largest(int k, E[][]matrix) {
		PriorityQueue<V<E>> h = new PriorityQueue<>();
		for (int i=0;i<matrix.length;i++) 
			if (matrix[i].length>0) h.offer(new V<E>(matrix[i][0],i,0));
		for (int i=1; i<k && !h.isEmpty(); i++){
			V<E> v = h.poll();
			if (v.col+1 < matrix[v.row].length) 
				h.offer(new V<E>(matrix[v.row][v.col+1],v.row,v.col+1));
		}
		if (h.isEmpty()) throw new IllegalArgumentException();
		return h.peek().val;
	}
	
	public static void main(String[] args) {
		Integer[][] M = {
				{2,4,6,8,10},
				{12,20,50,60},
				{1,3,5,7,9,11},
				};
		System.out.println(largest(13,M));
	}
}
