import java.util.*;

//Given two strings a and b, find whether any anagram of string 
//a is a sub-string of string b. For eg: 
//if a = xyz and b = afdgzyxksldfm then the program should return true.

public class AnagramSubstring {
	
	// Complexity: O(n) n letters in word
	// Space: O(m) m letters in sub
	public static boolean anagramSubstring(String sub, String word) {
		Map<Character,Integer> letters = new HashMap<>();
		for (char c: sub.toCharArray()) {
			if (letters.containsKey(c)) letters.put(c, letters.get(c)+1);
			else letters.put(c, 1);
		}
		for (char c: word.toCharArray()) {
			if (letters.containsKey(c) && letters.get(c)>0) 
				letters.put(c,letters.get(c)-1);
		}
		for (Map.Entry<Character,Integer> l: letters.entrySet())
			if (l.getValue()>0) return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(anagramSubstring("xyz", "afdgzyxksldfm"));
	}
}
