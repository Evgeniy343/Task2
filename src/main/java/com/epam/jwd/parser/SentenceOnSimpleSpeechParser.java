package com.epam.jwd.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceOnSimpleSpeechParser implements CompoundSpeechParser {
    private final static Pattern SIMPLE_REGEX =
            Pattern.compile("(([a-zA-Z-]+)|([\\p{Punct}\\p{Digit}]{3,}))|([\\s.—,’()])");
    private static SentenceOnSimpleSpeechParser sentenceParser;

    private SentenceOnSimpleSpeechParser() {
    }

    @Override
    public List<String> execute(String text) {
        return parse(text);
    }

    private List<String> parse(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = SIMPLE_REGEX.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static SentenceOnSimpleSpeechParser getInstance() {
        if (sentenceParser == null) {
            sentenceParser = new SentenceOnSimpleSpeechParser();
        }
        return sentenceParser;
    }

}
