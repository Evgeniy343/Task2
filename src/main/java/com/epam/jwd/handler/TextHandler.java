package com.epam.jwd.handler;

import com.epam.jwd.exception.ParserNotFoundException;
import com.epam.jwd.exception.SpeechNotFoundException;
import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.SpeechTypeModel;
import com.epam.jwd.parser.TextOnParagraphParser;
import com.epam.jwd.parser.context.CompoundSpeechContext;
import com.epam.jwd.parser.context.SimpleSpeechContext;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler implements CompoundSpeechHandler {
    private CompoundSpeechHandler nextHandler;
    private final static Pattern REGEX_NEXT_LINE = Pattern.compile("\\n");

    TextHandler() {

    }

    @Override
    public SpeechModel handle(String text) throws SpeechNotFoundException, ParserNotFoundException {
        CompoundSpeechContext textContext = createTextContext();
        SpeechModel paragraphs = SpeechModel.newInstance(textContext);
        for (String paragraphOrNextLine : TextOnParagraphParser.getInstance().execute(text)) {
            pushParagraphs(paragraphs, paragraphOrNextLine);
        }
        return paragraphs;
    }

    @Override
    public void next(CompoundSpeechHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    private void pushParagraphs(SpeechModel paragraphs, String paragraph) throws SpeechNotFoundException
            , ParserNotFoundException {

        if (isCharacter(paragraph)) {
            paragraphs.getComponents().add(SpeechModel.newInstance(createNextLineContext(paragraph)));
        } else {
            paragraphs.getComponents().add(nextHandler.handle(paragraph));
        }
    }

    private CompoundSpeechContext createNextLineContext(String simpleSpeech) {
        return new CompoundSpeechContext(SpeechTypeModel.CHARACTER, Collections.emptyList()
                , SimpleSpeechContext.of("", "", simpleSpeech.charAt(0)));
    }

    private CompoundSpeechContext createTextContext() {
        return new CompoundSpeechContext(SpeechTypeModel.TEXT_COMPOUND_PART
                , Collections.emptyList(), SimpleSpeechContext.of("", "", '\0'));
    }

    private boolean isCharacter(String simpleSpeech) {
        Matcher characterMatcher = REGEX_NEXT_LINE.matcher(simpleSpeech);
        return characterMatcher.matches();
    }

}
