//# Determine minimum sequence of adjacent values in the 
//# input parameter array that is greater than input parameter sum. 
//
//# Eg 
//# Array 2,1,1,4,3,6. and Sum is 8 
//# Answer is 2, because 3,6 is minimum sequence greater than 8
public class MinSequenceSum {
	
	public static int minSequence(int [] A, int target) {
		int test =0;
		for (int a: A) test+=a;
		if ( test< target) return Integer.MAX_VALUE;
		int front=0;
		int back=0;
		int minSeq = A.length;
		int sum = A[0];
		while (front+1<back || back+1<A.length) {
			if (sum > target && front+1<A.length) {
				sum-=A[front];
				front++;
				minSeq = Math.min(minSeq, back-front+1);
			} else if (back+1 <A.length) {
				back++;
				sum+=A[back];
			}
		}
		return minSeq;
	}
	
	public static void main(String [] args) {
		System.out.println(minSequence(new int[]{2,1,1,4,3,6}, 8));
	}
}
