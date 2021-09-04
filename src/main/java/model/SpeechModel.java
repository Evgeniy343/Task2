package model;

import exception.SpeechNotFoundException;
import parser.context.CompoundSpeechContext;

import java.util.List;

public interface SpeechModel {
    void print();

    void add(SpeechModel component);

    void remove(SpeechModel component);

    List<SpeechModel> getComponents();

    static SpeechModel newInstance(CompoundSpeechContext context) throws SpeechNotFoundException {
        switch (context.getType()) {
            case TEXT_COMPOUND_PART:
                if (context.getComponents().isEmpty()) {
                    return new TextCompoundPartModel();
                } else {
                    return new TextCompoundPartModel(context.getComponents());
                }
            case WORD:
                return new WordModel(context.getSimpleContext().getWord());
            case CHARACTER:
                return new CharacterModel(context.getSimpleContext().getCharacter());
            case EXPRESSION:
                return new ExpressionModel(context.getSimpleContext().getExpression());
            default:
                throw new SpeechNotFoundException("This speech not found!");
        }
    }
}
