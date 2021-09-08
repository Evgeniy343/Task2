package com.epam.jwd.handler;

import com.epam.jwd.exception.ParserNotFoundException;
import com.epam.jwd.exception.SpeechNotFoundException;
import com.epam.jwd.model.SpeechModel;

public interface CompoundSpeechHandler {
    SpeechModel handle(String text) throws SpeechNotFoundException, ParserNotFoundException;

    void next(CompoundSpeechHandler nextHandler);

    static CompoundSpeechHandler newInstance(CompoundSpeechTypeHandler type) throws ParserNotFoundException {
        switch (type) {
            case TEXT_ON_PARAGRAPH:
                return new TextHandler();
            case PARAGRAPH_ON_SENTENCE:
                return new ParagraphHandler();
            case SENTENCE_ON_SIMPLE_SPEECH:
                return new SentenceHandler();
            default:
                throw new ParserNotFoundException("This com.epam.jwd.handler not found!");
        }
    }
}
