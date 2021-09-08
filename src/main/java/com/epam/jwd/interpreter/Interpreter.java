package com.epam.jwd.interpreter;

public interface Interpreter {
    Integer execute(String expression);

    static Interpreter newInstance() {
        return ExpressionInterpreter.getInstance();
    }
}
