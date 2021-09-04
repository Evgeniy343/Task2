package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphOnSentenceParser implements CompoundSpeechParser {
    private static final Pattern SENTENCE_REGEX = Pattern.compile("([^\\t.]+\\.)|(\\t)");
    private static ParagraphOnSentenceParser paragraphParser;

    private ParagraphOnSentenceParser() {
    }

    @Override
    public List<String> execute(String text) {
        return parse(text);
    }

    private List<String> parse(String text) {
        List<String> sentencesWithTabs = new ArrayList<>();
        Matcher matcher = SENTENCE_REGEX.matcher(text);
        while (matcher.find()) {
            sentencesWithTabs.add(matcher.group());
        }
        return sentencesWithTabs;
    }

    public static ParagraphOnSentenceParser getInstance() {
        if (paragraphParser == null) {
            paragraphParser = new ParagraphOnSentenceParser();
        }
        return paragraphParser;
    }

}
