import java.util.*;

//Write a function 
//bool fancy_shuffle(char* s); 
//
//which rearranges characters in the string given as input, 
//in such a way that no same character occurs twice in a row 
//(that is, next to each other). 
//If such rearrangement is not possible, the function should return false.

public class FancyShuffle {
	
	static class V implements Comparable<V> {
		int count; 
		Character ch;
		V(int count, Character ch) {
			this.count=count;
			this.ch=ch;
		}
		public int compareTo(V o) {return Integer.compare(o.count, count);}
	}
	
	// Complexity: O(n log n)
	// Space: O(n)
	public static boolean fancyShuffle(char[] s) {
		PriorityQueue<V> h = new PriorityQueue<>();
		HashMap<Character,Integer> letters = new HashMap<>();
		for (char c: s) {
			if (letters.containsKey(c)) letters.put(c, letters.get(c)+1);
			else letters.put(c, 1);
		}
		for (Map.Entry<Character, Integer> e: letters.entrySet())
			h.offer(new V(e.getValue(), e.getKey()));
		Character last = null;
		for (int i=0; i<s.length && !h.isEmpty(); i++) {
			V v = h.poll();
			if (v.ch.equals(last)) {
				if (h.isEmpty()) return false;
				V v_p = h.poll();
				last = v_p.ch;
				if (--v_p.count>0) h.offer(v_p);
			} else last = v.ch;
			if (--v.count>0) h.offer(v);
			s[i] = last;
		}
		return true;
	}

	public static void main(String[] args) {
		char [] s ="raaccecar".toCharArray();
		System.out.println(fancyShuffle(s));
		System.out.println(s);
	}

}
