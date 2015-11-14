import java.util.*;

//Given a source string and a destination string write a program 
//to display sequence of strings to travel from source to destination. Rules for traversing: 
//1. You can only change one character at a time 
//2. Any resulting word has to be a valid word from dictionary 
//Example: Given source word CAT and destination word DOG , 
//one of the valid sequence would be 
//CAT -> COT -> DOT -> DOG 
//Another valid sequence can be 
//CAT -> COT - > COG -> DOG 
//
//One character can change at one time and every resulting word 
//has be a valid word from dictionary

public class TransformationDictionary {	
	
	// Complexity: O(n*m) n words of m letters each
	// Space: O(n*m) n words of m letters each
	public static int transform(String start, String end, String[] dictionary) {
		if (start.length()!=end.length()) return Integer.MAX_VALUE;
		Map<String,List<String>> dict = new HashMap<>();
		for (String word: dictionary)
			for (int i=0; i<word.length(); i++) {
				String in_word = wildCard(word, i);
				if (!dict.containsKey(in_word)) dict.put(in_word, new LinkedList<>());
				dict.get(in_word).add(word);
			}
		Set<String> visited = new HashSet<>();
		List<String> paths = new LinkedList<>();
		paths.add(start);
		int count = 0;
		while (!paths.isEmpty() && !visited.contains(end)) {
			List<String> next = new LinkedList<>();
			for (String path: paths)
				for (int i=0; i<path.length(); i++)
					for(String word: dict.get(wildCard(path, i)))
						if (!visited.contains(word)) {
							next.add(word);
							visited.add(word);
						}
			if (paths.size()==0 && !visited.contains(end)) return Integer.MAX_VALUE;
			paths = next;
			count++;
		}
		return count;
	}

	private static String wildCard(String word, int i) {
		return new StringBuilder()
				.append(word, 0, i)
				.append('_')
				.append(word, i+1, word.length())
				.toString();
	}
	
	public static void main(String [] args) {
		System.out.println(transform("cat","dog", new String[]{"dog","cat","ace","cot","cog"}));
	}
}
