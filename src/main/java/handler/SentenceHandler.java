package handler;

import interpreter.Interpreter;
import exception.SpeechNotFoundException;
import model.SpeechModel;
import model.SpeechTypeModel;
import parser.SentenceOnSimpleSpeechParser;
import parser.context.CompoundSpeechContext;
import parser.context.SimpleSpeechContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements CompoundSpeechHandler {
    private CompoundSpeechHandler nextHandler;

    private final static Pattern REGEX_WORD = Pattern.compile("[a-zA-Z-]+");
    private final static Pattern REGEX_EXPRESSION = Pattern.compile("[\\p{Punct}\\p{Digit}]{3,}");
    private final static Pattern REGEX_CHARACTER = Pattern.compile("([\\s.—,’])|([()])");

    SentenceHandler() {
        this.nextHandler = null;
    }

    @Override
    public SpeechModel handle(String text) throws SpeechNotFoundException {
        List<SpeechModel> simpleSpeeches = new ArrayList<>();
        for (String simpleSpeech : SentenceOnSimpleSpeechParser.getInstance().execute(text)) {
            simpleSpeeches.add(SpeechModel.newInstance(createSpeechContext(simpleSpeech)));
        }
        CompoundSpeechContext SentenceContext = createSentenceContext(simpleSpeeches);
        return SpeechModel.newInstance(SentenceContext);
    }


    @Override
    public void next(CompoundSpeechHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    private CompoundSpeechContext createSpeechContext(String simpleSpeech) {
        CompoundSpeechContext speechContext = null;
        if (isWord(simpleSpeech)) {
            speechContext = createWordContext(simpleSpeech);
        }
        if (isCharacter(simpleSpeech)) {
            speechContext = createCharacterContext(simpleSpeech);
        }
        if (isExpression(simpleSpeech)) {
            int result = Interpreter.newInstance().execute(simpleSpeech);
            speechContext = createExpressionContext(Integer.toString(result));
        }
        return speechContext;
    }

    private CompoundSpeechContext createExpressionContext(String simpleSpeech) {
        return new CompoundSpeechContext(SpeechTypeModel.EXPRESSION, Collections.emptyList()
                , SimpleSpeechContext.of("", simpleSpeech, '\0'));
    }

    private CompoundSpeechContext createCharacterContext(String simpleSpeech) {
        return new CompoundSpeechContext(SpeechTypeModel.CHARACTER, Collections.emptyList()
                , SimpleSpeechContext.of("", "", simpleSpeech.charAt(0)));
    }

    private CompoundSpeechContext createWordContext(String simpleSpeech) {
        return new CompoundSpeechContext(SpeechTypeModel.WORD, Collections.emptyList()
                , SimpleSpeechContext.of(simpleSpeech, "", '\0'));
    }

    private CompoundSpeechContext createSentenceContext(List<SpeechModel> simpleSpeeches) {
        return new CompoundSpeechContext(SpeechTypeModel.TEXT_COMPOUND_PART
                , simpleSpeeches, SimpleSpeechContext.of("", "", '\0'));
    }

    private boolean isWord(String simpleSpeech) {
        Matcher wordMatcher = REGEX_WORD.matcher(simpleSpeech);
        return wordMatcher.matches();
    }

    private boolean isExpression(String simpleSpeech) {
        Matcher expressionMatcher = REGEX_EXPRESSION.matcher(simpleSpeech);
        return expressionMatcher.matches();
    }

    private boolean isCharacter(String simpleSpeech) {
        Matcher characterMatcher = REGEX_CHARACTER.matcher(simpleSpeech);
        return characterMatcher.matches();
    }
}
