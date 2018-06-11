
public class CharAnalyzer {
	private char character;
	
	public CharAnalyzer() {
		character = 0;
	}
	
	public CharAnalyzer(char c) {
		setCharacter(c);
	}
	
	public void setCharacter(char c) {
		character = c;
	}
	
	public boolean isNumber() {
		return (character >= 48 && character <= 57);
	}
	
	public boolean isUpperCaseLetter() {
		return (character >= 65 && character <= 90);
	}
	
	public boolean isLowerCaseLetter() {
		return (character >= 97 && character <= 122);
	}
	
	public boolean isLetter() {
		return isUpperCaseLetter() || isLowerCaseLetter();
	}
}
