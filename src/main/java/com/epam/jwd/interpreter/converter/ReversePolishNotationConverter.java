package com.epam.jwd.interpreter.converter;

public interface ReversePolishNotationConverter {

    String convert(String expression);

    static ReversePolishNotationConverter instanceReversePolishNotation() {
        return ReversePolishNotation.INSTANCE;
    }
}
