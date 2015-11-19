import java.math.BigInteger;
import java.util.HashMap;

public class KnightGame {
	
	static HashMap<Integer,int[]> moves = new HashMap<>();
	
	static {
		moves.put(1, new int[]{6,8});
		moves.put(2, new int[]{7,9});
		moves.put(3, new int[]{4,8});
		moves.put(4, new int[]{3,9,0});
		moves.put(6, new int[]{1,7,0});
		moves.put(7, new int[]{2,6});
		moves.put(8, new int[]{1,3});
		moves.put(9, new int[]{2,4});
		moves.put(0, new int[]{4,6});
	}

	// Complexity: O(n)
	// Space: O(n)
	public static BigInteger knight(int start, int digits) {
		if (start<0 || start>9) 
			throw new IllegalArgumentException("start must be between 0 and 9");
		else if (digits<0) 
			throw new IllegalArgumentException("digits must be > 0");
		else if (start==5 && digits>1) return BigInteger.ZERO;
		
		HashMap<Integer,BigInteger> pathCounts = new HashMap<>();
		pathCounts.put(start, BigInteger.ONE);
		for (int i=1;i<digits && !pathCounts.isEmpty();i++) {
			HashMap<Integer,BigInteger> tempCounts = new HashMap<>();
			for (HashMap.Entry<Integer, BigInteger> k: pathCounts.entrySet())
				for (int move: moves.get(k.getKey()))
					if (tempCounts.containsKey(move)) 
						tempCounts.put(move, k.getValue().add(tempCounts.get(move)));
					else tempCounts.put(move, k.getValue());
			pathCounts = tempCounts;
		}
		
		BigInteger count = BigInteger.ZERO;
		for (HashMap.Entry<Integer, BigInteger> k: pathCounts.entrySet()) 
			count = count.add(k.getValue());
		return count;
	}
	
	public static void main(String [] args) {
		System.out.println(knight(1,10));
		System.out.println(knight(1,10000));
		System.out.println(knight(5,1));
		System.out.println(knight(5,10));
	}
}
