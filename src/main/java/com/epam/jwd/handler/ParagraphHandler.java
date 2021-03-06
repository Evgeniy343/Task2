package com.epam.jwd.handler;

import com.epam.jwd.exception.ParserNotFoundException;
import com.epam.jwd.exception.SpeechNotFoundException;
import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.SpeechTypeModel;
import com.epam.jwd.parser.ParagraphOnSentenceParser;
import com.epam.jwd.parser.context.CompoundSpeechContext;
import com.epam.jwd.parser.context.SimpleSpeechContext;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements CompoundSpeechHandler {
    private final static Pattern REGEX_TAB = Pattern.compile("\\t");
    private CompoundSpeechHandler nextHandler;

    ParagraphHandler() {
    }

    @Override
    public SpeechModel handle(String text) throws SpeechNotFoundException, ParserNotFoundException {
        CompoundSpeechContext paragraphContext = createParagraphContext();
        SpeechModel sentences = SpeechModel.newInstance(paragraphContext);
        for (String sentenceOrTab : ParagraphOnSentenceParser.getInstance().execute(text)) {
            pushSentences(sentences, sentenceOrTab);
        }
        return sentences;
    }


    @Override
    public void next(CompoundSpeechHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    private CompoundSpeechContext createParagraphContext() {
        return new CompoundSpeechContext(SpeechTypeModel.TEXT_COMPOUND_PART
                , Collections.emptyList(), SimpleSpeechContext.of("", "", '\0'));
    }


    private CompoundSpeechContext createTabContext(String simpleSpeech) {
        return new CompoundSpeechContext(SpeechTypeModel.CHARACTER, Collections.emptyList()
                , SimpleSpeechContext.of("", "", simpleSpeech.charAt(0)));
    }

    private boolean isTab(String simpleSpeech) {
        Matcher characterMatcher = REGEX_TAB.matcher(simpleSpeech);
        return characterMatcher.matches();
    }

    private void pushSentences(SpeechModel sentences, String sentenceOrTab) throws SpeechNotFoundException
            , ParserNotFoundException {

        if (isTab(sentenceOrTab)) {
            sentences.getComponents().add(SpeechModel.newInstance(createTabContext(sentenceOrTab)));
        } else {
            sentences.getComponents().add(nextHandler.handle(sentenceOrTab));
        }
    }

}
