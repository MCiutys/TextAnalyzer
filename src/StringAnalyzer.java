
public class StringAnalyzer {
	
	private String text;
	
	public StringAnalyzer(String text) {
		this.text = text;
	}
	
	public void changeText(String text) {
		this.text = text;
	}
	
	// Checks if a string is palindrome
	// A valid alphanumerical string has to be provided
	public boolean isPalindrome() {
		int start = 0, end = text.length() - 1;
		
		while (start < end) {
			char charStart = text.charAt(start);
			char charEnd = text.charAt(end);
			
			if (charStart != charEnd) return false;
			start++;
			end++;
		}
		return true;
	}
}
