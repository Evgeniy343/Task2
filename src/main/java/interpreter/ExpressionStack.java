package interpreter;

import java.util.Stack;

public class ExpressionStack implements ExpressionContext {

    private final Stack<Integer> expressions = new Stack<>();

    @Override
    public int pop() {
        return expressions.pop();
    }

    @Override
    public void push(int value) {
        expressions.push(value);
    }

    public Stack<Integer> getExpressions() {
        return expressions;
    }
}