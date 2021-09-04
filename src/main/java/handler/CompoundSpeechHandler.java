package handler;

import exception.ParserNotFoundException;
import exception.SpeechNotFoundException;
import model.SpeechModel;

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
                throw new ParserNotFoundException("This handler not found!");
        }
    }
}
