import java.io.IOException;
import java.io.Writer;
import java.util.PriorityQueue;
import java.util.Scanner;

//Given an active stream of sorted arrays, how would you merge them efficiently?

public class MergeSortedArrays {
	
	static class N implements Comparable<N> {
		String val;
		int arr;
		N(String val, int arr) {
			this.val=val;
			this.arr=arr;
		}
		@Override
		public int compareTo(N o) { return val.compareTo(o.val);}
	}
	
	// Complexity: n*m log(n), for n arrays of length m
	// Space: O(n)
	public void merge(Scanner[] in, Writer out) throws IOException {
		PriorityQueue<N> h = new PriorityQueue<>();
		for (int i=0; i< in.length; i++)
			if (in[i].hasNext()) h.offer(new N(in[i].next(),i));
		N n = null;
		while ((n = h.poll()) != null) {
			out.write(n.val);
			if (in[n.arr].hasNext()) h.offer(new N(in[n.arr].next(),n.arr));
		}
	}
}
