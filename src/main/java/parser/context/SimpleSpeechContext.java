package parser.context;

public class SimpleSpeechContext {
    private final String word;
    private final String expression;
    private final char character;

    SimpleSpeechContext(String word, String expression, char character) {
        this.word = word;
        this.expression = expression;
        this.character = character;
    }

    public static SimpleSpeechContext of(String word, String expression, char character) {
        return new SimpleSpeechContext(word, expression, character);
    }

    public String getWord() {
        return word;
    }

    public String getExpression() {
        return expression;
    }

    public char getCharacter() {
        return character;
    }
}
