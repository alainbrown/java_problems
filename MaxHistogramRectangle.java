import java.util.LinkedList;

// Find the area of the rectangle of maximal area under a histogram.

public class MaxHistogramRectangle {

	// Complexity: O(n)
	// Space: O(n)
	public static long maxArea(int[] hist) {
		long max_area = 0, current_area = 0;
		LinkedList<Integer> st = new LinkedList<>();
		int bar = 0, total = hist.length;
		while (bar < total) {
			if (st.isEmpty() || hist[st.peek()] <= hist[bar]) st.push(bar++);
			else {
				current_area = hist[st.pop()] * (st.isEmpty() ? bar : bar - st.peek() - 1);
				if (max_area < current_area) max_area = current_area;
			}
		}
		while (!st.isEmpty()) {
			current_area = hist[st.pop()] * (st.isEmpty() ? total : total - st.peek() - 1);
			if (max_area < current_area) max_area = current_area;
		}
		return max_area;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 6, 2, 5, 4, 5, 1, 6 })==3*4);
	}
}
