import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

//Given an infinite stream of characters and a list L of strings, 
//create a function that calls an external API when a word in L is 
//recognized during the processing of the stream. 
//
//Example: 
//L = ["ok","test","one","try","trying"] 
//stream = a,b,c,o,k,d,e,f,t,r,y,i,n,g............. 
//
//the call to external API (let's call it some function callAPI()) 
//		would be called when the 'k' is encountered, again when 
//		the 'y' is encountered, and again at 'g'.

public class StreamChecker {
	
	static class V {
		Map<Character,V> children = new HashMap<>();
		boolean word;
		
		void insert(String word){ insert(word,0);}
		
		void insert(String word, int index) {
			if (index < word.length()) {
				if (index==word.length()-1) this.word=true;
				char c = word.charAt(index);
				if (!children.containsKey(c)) children.put(c, new V());
				children.get(c).insert(word,index+1);
			}
		}
	}

	public static void callAPI(){}
	
	// Complexity: O(1) constant check for each char in stream
	// Space: O(n) n words
	public void contains(String[] words, InputStream stream) throws Exception {
		V root = new V();
		for (String word: words) root.insert(word);
		
		char c = 0;
		V last = root;
		while ((c=(char) stream.read()) != -1) {
			if (last.word) callAPI();
			if (last.children.containsKey(c)) last = last.children.get(c);
			else last=root;
		}
	}
}
