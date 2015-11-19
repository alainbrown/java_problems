import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public interface KnightGame {

	public BigInteger solve(int start, int digits);

	static class PhonepadKnightGame implements KnightGame {

		static HashMap<Integer, int[]> defaultMoves = new HashMap<>();
		static {
			defaultMoves.put(1, new int[] { 6, 8 });
			defaultMoves.put(2, new int[] { 7, 9 });
			defaultMoves.put(3, new int[] { 4, 8 });
			defaultMoves.put(4, new int[] { 3, 9, 0 });
			defaultMoves.put(5, new int[] {});
			defaultMoves.put(6, new int[] { 1, 7, 0 });
			defaultMoves.put(7, new int[] { 2, 6 });
			defaultMoves.put(8, new int[] { 1, 3 });
			defaultMoves.put(9, new int[] { 2, 4 });
			defaultMoves.put(0, new int[] { 4, 6 });
		}

		private Map<Integer, int[]> moves = new HashMap<>();

		// Complexity: O(n), constant m and p
		// Space: O(1), constant m
		//
		// Complexity: O(n*m*p) n digits, m positions, p possible movements
		// Space: O(m)
		public PhonepadKnightGame() { this(defaultMoves);}
		public PhonepadKnightGame(Map<Integer, int[]> moves) { this.moves = moves;}

		public BigInteger solve(int start, int digits) {
			if (edgeCase(start, digits)) return BigInteger.ZERO;

			HashMap<Integer, BigInteger> pathCounts = new HashMap<>();
			pathCounts.put(start, BigInteger.ONE);
			for (int i = 1; i < digits; i++) {
				HashMap<Integer, BigInteger> tempCounts = new HashMap<>();
				for (HashMap.Entry<Integer, BigInteger> k : pathCounts.entrySet()) {
					for (int move : move(k.getKey())) {
						if (tempCounts.containsKey(move))
							tempCounts.put(move, k.getValue().add(tempCounts.get(move)));
						else tempCounts.put(move, k.getValue());
					}
				}
				pathCounts = tempCounts;
			}

			BigInteger count = BigInteger.ZERO;
			for (HashMap.Entry<Integer, BigInteger> k : pathCounts.entrySet())
				count = count.add(k.getValue());
			return count;
		}

		protected int[] move(int m) { 
			if (moves.containsKey(m)) return moves.get(m);
			else return new int[]{};
		}

		protected boolean edgeCase(int start, int digits) {
			return !((moves.containsKey(start) && 
					digits > 0 && 
					!(moves.get(start).length == 0 && digits > 1)));
		}
	}

	public static void main(String[] args) {
		KnightGame k = new PhonepadKnightGame();
		System.out.println(k.solve(1, 10));
		System.out.println(k.solve(1, 100));
		System.out.println(k.solve(5, 1));
		System.out.println(k.solve(5, 10));
	}

}
