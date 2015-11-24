import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
	
	private final C root;
	
	public StreamChecker(String [] words) {
		this.root = new C();
		for (String word: words) root.insert(word);
	}
	
	// Complexity: O(n) constant check for each char in stream, n chars
	// Space: O(m) m words
	public void contains(InputStream stream) throws IOException {
		int i;
		char c;
		C last = root;
		while ((i= stream.read()) != -1) {
			c = (char)i;
			if (last.children.containsKey(c)) last = last.children.get(c);
			else last=root;
			if (last.word!=null) callAPI(last.word);
		}
	}

	static class C {
		Map<Character,C> children = new HashMap<>();
		String word;
		
		void insert(String word){ this.insert(word,0);}
		
		void insert(String word, int index) {
			if (index < word.length()) {
				if (index==word.length()-1) this.word=word;
				char c = word.charAt(index);
				if (!children.containsKey(c)) children.put(c, new C());
				children.get(c).insert(word,index+1);
			}
		}
	}
	
	public static void callAPI(String word){System.out.println(word);}

	public static void main(String [] args) throws Exception {
		InputStream stream = new ByteArrayInputStream("abcokdeftrying".getBytes(StandardCharsets.UTF_8));
		StreamChecker checker = new StreamChecker(new String[]{"ok","test","one","try","trying"});
		checker.contains(stream);
	}
}
