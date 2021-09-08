package interpreter;

public interface ExpressionParser {
    Expression parse(String expression);

    static ExpressionParser instanceReversePolishNotationExpressionParser(){
        return ReversePolishNotationExpressionParser.INSTANCE;
    }
}
