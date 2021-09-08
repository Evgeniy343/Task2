package parser;

import java.util.List;

@FunctionalInterface
public interface CompoundSpeechParser {
    List<String> execute(String text);
}
