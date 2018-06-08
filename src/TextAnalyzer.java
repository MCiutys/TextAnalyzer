import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer {
	
	private String text;
	private String[] words;
	private Set<String> uniqueWords;
	
	public TextAnalyzer(String text) {
		this.text = text;
		buildWords();
		buildUniqueWords();
	}
	
	private void buildWords() {
		words = text.split("\\s+");
	}
	
	private void buildUniqueWords() {
		uniqueWords = new HashSet<>();
		for (String word : words) {
			uniqueWords.add(word);
		}
	}
	
	public int countWords() {
		if (words[0].equals("")) return 0;
		return words.length;
	}
	
	public int countUniqueWords() {
		if (words[0].equals("")) return 0;
		return uniqueWords.size();
	}
	
	public int coundPalindromes() {
		if (text.equals("")) return 0;
		
		return 0;
	}
}
