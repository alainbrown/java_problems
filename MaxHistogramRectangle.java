import java.util.Stack;

// Find the area of the rectangle of maximal area under a histogram.

public class MaxHistogramRectangle {

	// Complexity: O(n)
	// Space: O(n)
	public static long maxArea(int[] hist) {
		long max_area = 0; int bar = 0, total = hist.length;
		Stack<Integer> st = new Stack<>();
		while (bar < total)
			if (st.isEmpty() || hist[st.peek()] <= hist[bar]) st.push(bar++);
			else max_area = max_area(hist, max_area, st, bar);
		while (!st.isEmpty()) max_area = max_area(hist, max_area, st, total);
		return max_area;
	}

	private static long max_area(int[] hist, long max_area, Stack<Integer> st, int bar) {
		return Math.max(max_area, hist[st.pop()]*(st.isEmpty() ? bar : bar-st.peek()-1));
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 6, 2, 5, 4, 5, 1, 6 })==3*4);
	}
}
