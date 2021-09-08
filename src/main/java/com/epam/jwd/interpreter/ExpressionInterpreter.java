package com.epam.jwd.interpreter;

import com.epam.jwd.interpreter.converter.ReversePolishNotationConverter;

public class ExpressionInterpreter implements Interpreter {
    private static ExpressionInterpreter instance;

    private ExpressionInterpreter() {
    }

    public static Interpreter getInstance(){
        if(instance == null){
            instance = new ExpressionInterpreter();
        }
        return instance;
    }

    @Override
    public Integer execute(String expression) {
        ReversePolishNotationConverter converter = ReversePolishNotationConverter.instanceReversePolishNotation();
        ExpressionParser parser = ExpressionParser.instanceReversePolishNotationExpressionParser();
        Expression reversePolishNotation = parser.parse(converter.convert(expression));
        return reversePolishNotation.calculate();
    }
}
