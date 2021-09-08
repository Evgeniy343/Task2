package com.epam.jwd.interpreter;

public interface Expression {
    void interpret(ExpressionContext context);

    default int calculate() {
        ExpressionContext context = new ExpressionStack();
        this.interpret(context);
        return context.pop();
    }
}
