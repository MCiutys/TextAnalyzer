import java.util.HashSet;
import java.util.Set;

public class Analyzer {
	
	private String text;
	
	public Analyzer(String text) {
		this.text = text;
	}
	
	public int countWords() {
		String[] words = text.split("\\s+");
		System.out.println(words.length);
		return words.length;
	}
	
	public int countUniqueWords() {
		
		Set<String> set = new HashSet<>();
		String[] words = text.split("\\s+");
		for (String word : words) {
			set.add(word);
		}
		System.out.println(set.size());
		return set.size();
	}
}
