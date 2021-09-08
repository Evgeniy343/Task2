package interpreter;

import java.util.Stack;

public interface ExpressionContext {
    int pop();

    void push(int value);

    Stack<Integer> getExpressions();
}
