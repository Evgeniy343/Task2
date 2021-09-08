package com.epam.jwd.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextOnParagraphParser implements CompoundSpeechParser {
    private static final Pattern PARAGRAPH_REGEX = Pattern.compile("(\\t.+)|(\\n)");
    private static TextOnParagraphParser textParser;

    private TextOnParagraphParser() {
    }

    @Override
    public List<String> execute(String text) {
        return parse(text);
    }

    private List<String> parse(String text) {
        List<String> paragraphs = new ArrayList<>();
        Matcher matcher = PARAGRAPH_REGEX.matcher(text);
        while (matcher.find()) {
            paragraphs.add(matcher.group());
        }
        return paragraphs;
    }

    public static TextOnParagraphParser getInstance() {
        if (textParser == null) {
            textParser = new TextOnParagraphParser();
        }
        return textParser;
    }

}
